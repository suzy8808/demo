package org.bobo.clockin.mapper.cinmapper;

import org.apache.ibatis.annotations.Mapper;
import org.bobo.clockin.bean.Subsidy;

@Mapper
public interface CinSubsidyMapper {
    public Subsidy selectByUidAndYearMonth(Integer userId, String yearMonth);
}
