package org.bobo.clockin.mapper.cinmapper;


import org.apache.ibatis.annotations.Mapper;
import org.bobo.clockin.bean.Configuration;

import java.util.List;

@Mapper
public interface CinConfigurationMapper {
    List<Configuration> selectAll();
}
