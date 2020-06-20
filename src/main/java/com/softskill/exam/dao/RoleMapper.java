package com.softskill.exam.dao;

import com.softskill.exam.domain.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(Long cRoleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long cRoleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}