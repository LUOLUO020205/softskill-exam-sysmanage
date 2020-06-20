package com.softskill.exam.dao;

import com.softskill.exam.domain.QuestionDiscuss;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionDiscussMapper {
    int deleteByPrimaryKey(Long cQdId);

    int insert(QuestionDiscuss record);

    int insertSelective(QuestionDiscuss record);

    QuestionDiscuss selectByPrimaryKey(Long cQdId);

    int updateByPrimaryKeySelective(QuestionDiscuss record);

    int updateByPrimaryKey(QuestionDiscuss record);
}