package com.softskill.exam.dao;

import com.softskill.exam.domain.Question;
import com.softskill.exam.domain.QuestionOptions;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface QuestionMapper {
    int deleteByPrimaryKey(Long cQuesId);

    Long insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Long cQuesId);

    List<Question> selectQuestionByCondition(Question question);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    Long countQuestionByParams(Map<String, Object> params);

    List<Question> selectQuestionByParams(Map<String, Object> params);
}