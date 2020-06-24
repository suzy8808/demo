package org.bobo.clockin.configuration;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@ToString
public class AppConfiguration {
    private String AppName;
    private String StartWorkTime;
    private String EndWorkTime;
    private String SubsidyRule1;
    private String SubsidyRule1StartTime;
    private String SubsidyRule1EndTime;
    private String SubsidyRule2;
    //private LocalDateTime SubsidyRule2StartTime;
    private String SubsidyRule2EndTime;
    private String WeekSubsidyRule;

    public String getAppName() {
        return AppName;
    }

    public LocalDateTime getStartWorkTime(LocalDate date) {
         return LocalDateTime.of(date,
                LocalTime.of(Integer.valueOf(StartWorkTime.substring(0, 2))
                        , Integer.valueOf(StartWorkTime.substring(2, 4))));

    }

    public LocalDateTime getEndWorkTime(LocalDate date) {
        return LocalDateTime.of(date,
                LocalTime.of(Integer.valueOf(EndWorkTime.substring(0, 2))
                        , Integer.valueOf(EndWorkTime.substring(2, 4))));

    }

    public BigDecimal getSubsidyRule1() {

        return new BigDecimal(SubsidyRule1);
    }

    public LocalDateTime getSubsidyRule1StartTime(LocalDate date) {

        return LocalDateTime.of(date,
                LocalTime.of(Integer.valueOf(SubsidyRule1StartTime.substring(0, 2))
                        , Integer.valueOf(SubsidyRule1StartTime.substring(2, 4))));

    }

    public LocalDateTime getSubsidyRule1EndTime(LocalDate date) {
        Integer hour=Integer.valueOf(SubsidyRule1EndTime.substring(0, 2));
        Integer minute=Integer.valueOf(SubsidyRule1EndTime.substring(2, 4));
        if(hour<6)
            return LocalDateTime.of(date.plusDays(1),
                LocalTime.of(hour
                        , minute));
        else
            return LocalDateTime.of(date,
                    LocalTime.of(hour
                            , minute));
    }

    public BigDecimal getSubsidyRule2() {

        return new BigDecimal(SubsidyRule2);

    }
//
//    public void setSubsidyRule2StartTime(String SubsidyRule2StartTime) {
//
//        this.SubsidyRule2StartTime = LocalDateTime.of(LocalDate.now(),
//                LocalTime.of(Integer.valueOf(SubsidyRule2StartTime.substring(0, 2))
//                        , Integer.valueOf(SubsidyRule2StartTime.substring(2, 4))));
//
//    }

    public LocalDateTime getSubsidyRule2EndTime(LocalDate date) {
        Integer hour=Integer.valueOf(SubsidyRule2EndTime.substring(0, 2));
        Integer minute=Integer.valueOf(SubsidyRule2EndTime.substring(2, 4));
        if(hour<6)
            return LocalDateTime.of(date.plusDays(1),
                    LocalTime.of(hour
                            , minute));
        else
             return LocalDateTime.of(date,
                    LocalTime.of(hour
                            , minute));
    }

    public BigDecimal getWeekSubsidyRule() {
        return new BigDecimal(WeekSubsidyRule);
    }
}
