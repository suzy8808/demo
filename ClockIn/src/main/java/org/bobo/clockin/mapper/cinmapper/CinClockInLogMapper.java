package org.bobo.clockin.mapper.cinmapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.bobo.clockin.bean.ClockInLog;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface CinClockInLogMapper {
    public ClockInLog selectByUidAndToday(@Param("userId") Integer userId, @Param("today") LocalDateTime today);

    public List<ClockInLog> selectByUidAndTimeRange(@Param("userId") Integer userId
            , @Param("start") LocalDateTime start
            , @Param("end") LocalDateTime end);
}
