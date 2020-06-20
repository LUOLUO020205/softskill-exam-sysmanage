package com.softskill.exam.service;

import com.softskill.exam.domain.Question;

import java.util.List;
import java.util.Map;

public interface IQuestionService {
    /**
     * 根据条件查询所有试题
     * @param question
     * @return
     */
    public List<Question> queryAllQuestionByCondition(Question question);

    /**
     * 保存试题并返回主键ID
     * @param question
     * @return
     */
    Long saveOrUpdateReturnPrimaryKey(Question question);

    Question queryQuestionByPrimaryKey(Long cQuestId);

    /**
     * 根据ID删除试题
     * @param cQuestId
     */
    int deleteQuestionByPrimaryKey(Long cQuestId);

    List<Question> queryAllQuestionByParams(Map<String, Object> params);
}
