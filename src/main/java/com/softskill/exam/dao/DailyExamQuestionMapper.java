package com.softskill.exam.dao;

import com.softskill.exam.domain.DailyExamQuestion;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DailyExamQuestionMapper {
    int insert(DailyExamQuestion record);

    int insertSelective(DailyExamQuestion record);
}