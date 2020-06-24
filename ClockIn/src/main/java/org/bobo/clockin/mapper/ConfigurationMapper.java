package org.bobo.clockin.mapper;

import org.bobo.clockin.bean.Configuration;

public interface ConfigurationMapper {
    int deleteByPrimaryKey(String key);

    int insert(Configuration record);

    int insertSelective(Configuration record);

    Configuration selectByPrimaryKey(String key);

    int updateByPrimaryKeySelective(Configuration record);

    int updateByPrimaryKey(Configuration record);
}