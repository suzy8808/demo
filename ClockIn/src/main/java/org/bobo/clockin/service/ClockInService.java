package org.bobo.clockin.service;

import org.bobo.clockin.bean.ClockInLog;
import org.bobo.clockin.bean.Subsidy;
import org.bobo.clockin.bean.UserMaster;
import org.bobo.clockin.configuration.AppConfiguration;
import org.bobo.clockin.constant.SystemConstant;
import org.bobo.clockin.mapper.ClockInLogMapper;
import org.bobo.clockin.mapper.SubsidyMapper;
import org.bobo.clockin.mapper.UserMasterMapper;
import org.bobo.clockin.mapper.cinmapper.CinClockInLogMapper;
import org.bobo.clockin.mapper.cinmapper.CinSubsidyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@Transactional
public class ClockInService {

    @Autowired
    private CinClockInLogMapper cinClockInLogMapper;

    @Autowired
    private ClockInLogMapper clockInLogMapper;

    @Autowired
    private CinSubsidyMapper cinSubsidyMapper;

    @Autowired
    private SubsidyMapper subsidyMapper;

    @Autowired
    private UserMasterMapper userMasterMapper;

    @Autowired
    private AppConfiguration appConfiguration;

    public int clockin(Integer userId) {
        //用户不存在 异常
        UserMaster user =userMasterMapper.selectByPrimaryKey(userId);
        if(user==null)return SystemConstant.CLOCKIN_STATUS_FAIL;

        LocalDateTime now = LocalDateTime.now();
        ClockInLog clockInLog = null;


        LocalDateTime today4 =  LocalDateTime.of(now.toLocalDate(), LocalTime.of(SystemConstant.CLOCK_4, 0));
        LocalDateTime today6 = LocalDateTime.of(now.toLocalDate(), LocalTime.of(SystemConstant.CLOCK_6, 0));
        // AM 4-6 打卡属于异常
        if(now.isAfter(today4)&&now.isBefore(today6))return SystemConstant.CLOCKIN_STATUS_EXCEPTION;
        else if(now.isBefore(today4)){
            // AM 4之前属于昨天
            clockInLog = cinClockInLogMapper.selectByUidAndToday(userId, today6.plusDays(-1));
            //昨天没打卡，早上6点前打卡，异常
            if(clockInLog==null)return SystemConstant.CLOCKIN_STATUS_EXCEPTION;
            else {
                clockInLog.setEndTime(now);
                clockInLogMapper.updateByPrimaryKeySelective(clockInLog);
                return SystemConstant.CLOCKIN_STATUS_REST;
            }
        }else {
            // AM 6之后 今天
            clockInLog = cinClockInLogMapper.selectByUidAndToday(userId, today6);

            LocalDate date = now.toLocalDate();
            LocalDateTime startWorkTime = appConfiguration.getStartWorkTime(date);
            LocalDateTime endWorkTime = appConfiguration.getEndWorkTime(date);
            if (clockInLog == null) {
                //第一次打卡
                clockInLog = new ClockInLog();
                clockInLog.setUserId(userId);
                clockInLog.setStartTime(now);
                clockInLogMapper.insertSelective(clockInLog);
                if (startWorkTime.isAfter(now)) {
                    //正常
                    return SystemConstant.CLOCKIN_STATUS_SUCCESS;
                } else {
                    //迟到
                    return SystemConstant.CLOCKIN_STATUS_LATE;
                }
            } else {
                //最新一次打卡
                clockInLog.setEndTime(now);
                clockInLogMapper.updateByPrimaryKeySelective(clockInLog);
                if (endWorkTime.isBefore(now)) {
                    //休息
                    return SystemConstant.CLOCKIN_STATUS_REST;
                } else {
                    //早退
                    return SystemConstant.CLOCKIN_STATUS_EARLY;
                }
            }
        }
    }

    public Subsidy querySubsidy(Integer userId, String yearMonth) {
        UserMaster user =userMasterMapper.selectByPrimaryKey(userId);
        if(user==null)throw new IllegalArgumentException();
        int year = Integer.valueOf(yearMonth.substring(0, 4));
        int month = Integer.valueOf(yearMonth.substring(4, 6));

        //月份第一天AM 6-第二月第一天AM 4
        LocalDateTime start = LocalDateTime.of(year, month, 1, SystemConstant.CLOCK_6, 0, 0);
        LocalDateTime end = LocalDateTime.of(year, month + 1, 1, 4, SystemConstant.CLOCK_4, 0);

        Subsidy subsidy = cinSubsidyMapper.selectByUidAndYearMonth(userId, yearMonth);

        if (subsidy == null) {
            subsidy = new Subsidy();
            subsidy.setSsYearMonth(yearMonth);
            subsidy.setUserId(userId);
            subsidy.setSubsidy(new BigDecimal(0));
            List<ClockInLog> clockInLogs = cinClockInLogMapper.selectByUidAndTimeRange(userId, start, end);

            for (ClockInLog clockInLog : clockInLogs) {
                LocalDate date=clockInLog.getStartTime().toLocalDate();
                LocalDateTime startWorkTime=appConfiguration.getStartWorkTime(date);
                LocalDateTime endWorkTime=appConfiguration.getEndWorkTime(date);
                LocalDateTime subsidyRule1StartTime=appConfiguration.getSubsidyRule1StartTime(date);
                LocalDateTime subsidyRule1EndTime=appConfiguration.getSubsidyRule1EndTime(date);
                LocalDateTime subsidyRule2EndTime=appConfiguration.getSubsidyRule2EndTime(date);

                if (startWorkTime.isAfter(clockInLog.getStartTime())) {
                    if (clockInLog.getEndTime() != null && endWorkTime.isBefore(clockInLog.getEndTime())) {
                        //考勤正常
                        int dayofw=clockInLog.getStartTime().getDayOfWeek().getValue();
                        if(dayofw<6) {
                            //工作日
                            if (subsidyRule1StartTime.isBefore(clockInLog.getEndTime()) &&
                                    subsidyRule1EndTime.isAfter(clockInLog.getEndTime())) {
                                //加班 PM 7-9
                                subsidy.setSubsidy(subsidy.getSubsidy().add(appConfiguration.getSubsidyRule1()));
                            } else if (subsidyRule1EndTime.isBefore(clockInLog.getEndTime())) {
                                //加班 PM 9- AM 3
                                subsidy.setSubsidy(subsidy.getSubsidy().add(appConfiguration.getSubsidyRule1()));
                                if(subsidyRule2EndTime.isAfter(clockInLog.getEndTime())) {
                                    Duration duration = Duration.between(subsidyRule1EndTime, clockInLog.getEndTime());
                                    long hours = duration.toHours();
                                    subsidy.setSubsidy(subsidy.getSubsidy().add(appConfiguration.getSubsidyRule2().multiply(new BigDecimal(hours))));
                                }else{
                                    Duration duration = Duration.between(subsidyRule1EndTime, subsidyRule2EndTime);
                                    long hours = duration.toHours();
                                    subsidy.setSubsidy(subsidy.getSubsidy().add(appConfiguration.getSubsidyRule2().multiply(new BigDecimal(hours))));
                                }
                            } else {
                                //正常上下班
                            }
                        }else{
                            //周末
                            subsidy.setSubsidy(subsidy.getSubsidy().add(appConfiguration.getWeekSubsidyRule()));
                        }
                    } else {
                        //晚上未打卡或早退
                    }
                } else {
                    //迟到
                }

            }
            subsidyMapper.insertSelective(subsidy);
        }

        return subsidy;

    }

    public void createData(){
        for(int i=1;i<=31;i++){
            ClockInLog clockInLog=new ClockInLog();
            clockInLog.setUserId(1);
            clockInLog.setStartTime(LocalDateTime.of(2020,5,i,8,59,59));
            clockInLog.setEndTime(LocalDateTime.of(2020,5,i,17,30,1));
            clockInLogMapper.insertSelective(clockInLog);
        }
    }

}
