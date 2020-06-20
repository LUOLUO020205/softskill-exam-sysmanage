package com.softskill.exam.service.impl;

import com.softskill.exam.dao.QuestionMapper;
import com.softskill.exam.domain.PageModel;
import com.softskill.exam.domain.Question;
import com.softskill.exam.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class QuestionServiceImpl implements IQuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public List<Question> queryAllQuestionByCondition(Question question) {
        return questionMapper.selectQuestionByCondition(question);
    }

    @Override
    public Long saveOrUpdateReturnPrimaryKey(Question question) {
        if(question.getcQuesId()==null){
            return questionMapper.insert(question);
        }else{
            questionMapper.updateByPrimaryKey(question);
            return question.getcQuesId();
        }
    }

    @Override
    public Question queryQuestionByPrimaryKey(Long cQuestId) {
        return questionMapper.selectByPrimaryKey(cQuestId);
    }

    @Override
    public int deleteQuestionByPrimaryKey(Long cQuestId) {
        return questionMapper.deleteByPrimaryKey(cQuestId);
    }

    @Override
    public List<Question> queryAllQuestionByParams(Map<String, Object> params) {
        PageModel pageModel=(PageModel) params.get("pageModel");
        Long count = questionMapper.countQuestionByParams(params);
        pageModel.setRecordCount(count);
        return questionMapper.selectQuestionByParams(params);
    }
}
