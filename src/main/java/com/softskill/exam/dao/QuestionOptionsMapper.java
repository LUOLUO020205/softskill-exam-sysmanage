package com.softskill.exam.dao;

import com.softskill.exam.domain.QuestionOptions;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionOptionsMapper {
    int deleteByPrimaryKey(Long cQoId);

    int insert(QuestionOptions record);

    int insertSelective(QuestionOptions record);

    QuestionOptions selectByPrimaryKey(Long cQoId);

    int updateByPrimaryKeySelective(QuestionOptions record);

    int updateByPrimaryKey(QuestionOptions record);

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
    List<QuestionOptions> selectAllQuestionOptionByCQuestId(Long cQuestId);

    int deleteOptionByCQuesId(Long cQuestId);

    int batchUpdate(List<QuestionOptions> questionOptionsList);
}