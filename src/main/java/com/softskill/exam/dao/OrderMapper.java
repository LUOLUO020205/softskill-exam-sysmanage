package com.softskill.exam.dao;

import com.softskill.exam.domain.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(Long cOrderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long cOrderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}