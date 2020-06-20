package com.softskill.exam.service.impl;

import com.softskill.exam.dao.QuestionMapper;
import com.softskill.exam.dao.QuestionOptionsMapper;
import com.softskill.exam.domain.QuestionOptions;
import com.softskill.exam.service.IQuestionOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionOptionServiceImpl implements IQuestionOptionService {

    @Autowired
    private QuestionOptionsMapper questionOptionsMapper;

    @Override
    public int saveOrUpdateOptions(List<QuestionOptions> questionOptionsList) {
        return 0;
    }

    @Override
    public int batchInsert(List<QuestionOptions> questionOptionsList) {
        return questionOptionsMapper.batchInsert(questionOptionsList);
    }

    @Override
    public List<QuestionOptions> queryAllQuestionOptionByCQuestId(Long cQuestId) {
        return questionOptionsMapper.selectAllQuestionOptionByCQuestId(cQuestId);
    }

    @Override
    public int deleteOptionByCQuesId(Long cQuestId) {
        return questionOptionsMapper.deleteOptionByCQuesId(cQuestId);
    }

    @Override
    public int batchUpdate(List<QuestionOptions> questionOptionsList) {
        return questionOptionsMapper.batchUpdate(questionOptionsList);
    }
}
