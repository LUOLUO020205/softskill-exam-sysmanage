package com.softskill.exam.dao;

import com.softskill.exam.domain.HacQuestion;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HacQuestionMapper {
    int insert(HacQuestion record);

    int insertSelective(HacQuestion record);
}