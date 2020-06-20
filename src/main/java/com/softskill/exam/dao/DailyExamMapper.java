package com.softskill.exam.dao;

import com.softskill.exam.domain.DailyExam;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DailyExamMapper {
    int deleteByPrimaryKey(Long cDeId);

    int insert(DailyExam record);

    int insertSelective(DailyExam record);

    DailyExam selectByPrimaryKey(Long cDeId);

    int updateByPrimaryKeySelective(DailyExam record);

    int updateByPrimaryKey(DailyExam record);
}