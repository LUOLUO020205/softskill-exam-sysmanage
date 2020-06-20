package com.softskill.exam.service;

import com.softskill.exam.domain.QuestionOptions;

import java.util.List;

public interface IQuestionOptionService {

    /**
     * 保存选项
     * @param questionOptionsList
     * @return
     */
    int saveOrUpdateOptions(List<QuestionOptions> questionOptionsList);

    /**
     * 批量保存选项
     * @param questionOptionsList
     * @return
     */
    int batchInsert(List<QuestionOptions> questionOptionsList);

    /**
     * 根据试题ID查询所有选项
     * @param cQuestId
     * @return
     */
    List<QuestionOptions> queryAllQuestionOptionByCQuestId(Long cQuestId);

    /**
     * 根据试题删除所有选项
     * @param cQuestId
     * @return
     */
    int deleteOptionByCQuesId(Long cQuestId);

    int batchUpdate(List<QuestionOptions> questionOptionsList);
}
