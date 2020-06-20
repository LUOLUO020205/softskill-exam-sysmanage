package com.softskill.exam.dao;

import com.softskill.exam.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long cUid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long cUid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

//    User queryUserByNameAndPwd(String userName,String pwd);
}