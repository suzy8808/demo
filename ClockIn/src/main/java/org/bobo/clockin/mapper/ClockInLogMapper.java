package org.bobo.clockin.mapper;

import org.bobo.clockin.bean.ClockInLog;

public interface ClockInLogMapper {
    int deleteByPrimaryKey(Integer cinId);

    int insert(ClockInLog record);

    int insertSelective(ClockInLog record);

    ClockInLog selectByPrimaryKey(Integer cinId);

    int updateByPrimaryKeySelective(ClockInLog record);

    int updateByPrimaryKey(ClockInLog record);
}