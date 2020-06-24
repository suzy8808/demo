package org.bobo.clockin.mapper;

import org.bobo.clockin.bean.UserMaster;

public interface UserMasterMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserMaster record);

    int insertSelective(UserMaster record);

    UserMaster selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserMaster record);

    int updateByPrimaryKey(UserMaster record);
}