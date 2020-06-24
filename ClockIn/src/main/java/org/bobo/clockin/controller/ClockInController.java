package org.bobo.clockin.controller;

import org.bobo.clockin.bean.Subsidy;
import org.bobo.clockin.common.result.ResultMap;
import org.bobo.clockin.configuration.AppConfiguration;
import org.bobo.clockin.constant.SystemConstant;
import org.bobo.clockin.service.ClockInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClockInController {
    @Autowired
    private AppConfiguration appConfiguration;
    @Autowired
    private ClockInService clockInService;
    //打卡
    @PostMapping("/clockin")
    public ResultMap<Integer> clockin(Integer userId) {
        if(userId==null)return ResultMap.success(SystemConstant.SUCCESS, SystemConstant.CLOCKIN_STATUS_FAIL);

        int clockinStatus=clockInService.clockin(userId);
        return ResultMap.success(SystemConstant.SUCCESS, clockinStatus);


    }
    //查询补贴
    @PostMapping("/querySubsidy")
    public ResultMap<String> querySubsidy(Integer userId,String yearMonth) {
        if(userId==null||yearMonth==null||yearMonth.length()!=6)return ResultMap.failure();
        try {
            Subsidy subsidy = clockInService.querySubsidy(userId, yearMonth);
            return ResultMap.success(SystemConstant.SUCCESS, subsidy.getSubsidy().toString());
        }catch (Exception e){
            return ResultMap.failure();
        }

    }

    @GetMapping("/createData")
    public ResultMap<String> createData() {
        clockInService.createData();
        return ResultMap.success(SystemConstant.SUCCESS, appConfiguration.getAppName());
    }
}
