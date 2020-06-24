package org.bobo.clockin.mapper;

import org.bobo.clockin.bean.Subsidy;

public interface SubsidyMapper {
    int deleteByPrimaryKey(Integer ssId);

    int insert(Subsidy record);

    int insertSelective(Subsidy record);

    Subsidy selectByPrimaryKey(Integer ssId);

    int updateByPrimaryKeySelective(Subsidy record);

    int updateByPrimaryKey(Subsidy record);
}