package com.softskill.exam.controller;

import com.softskill.exam.domain.*;
import com.softskill.exam.service.IQuestionOptionService;
import com.softskill.exam.service.IQuestionService;
import com.softskill.exam.vo.QuestionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private IQuestionService questionService;

    @Autowired
    private IQuestionOptionService questionOptionService;

    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, PageModel pageModel){
        Map<String, Object> returnParams = new HashMap<String, Object>();
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            WebUtil.getParamersMap(request, params);
            params.put("pageModel", pageModel);
            List<Question> list =  questionService.queryAllQuestionByParams(params);
            pageModel.setItems(list);
            returnParams.put("pageModel", pageModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnParams;
    }

    @RequestMapping("/add")
    public String add(Question question,Model model){
        model.addAttribute("model",question);
        return "question/add-question";
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(QuestionVo questionVo){
        Question  question = new Question();
        copyValue(question,questionVo);
        List<String> questionOption = questionVo.getcQoContents();
        questionService.saveOrUpdateReturnPrimaryKey(question);
        int effectRows = 0;
        Long cCorrectOptionId = null;
        if(questionVo.getcQuesId()==null){ //新增
            Long cQuesId = question.getcQuesId();//从数据库返回主键值
            List<QuestionOptions> questionOptionsList = changeQuestionOptions(questionOption,cQuesId);

            //正确答案获取及设置
            cCorrectOptionId = question.getcCorrectOptionId();//页面存储的正确选项即数组下标,需换算成QuestionOptions的主键ID
            QuestionOptions validOption = questionOptionsList.get(cCorrectOptionId.intValue());

            //执行SQL，得到正确选项的ID
            effectRows = questionOptionService.batchInsert(questionOptionsList);
            cCorrectOptionId =  validOption.getcQoId();
            question.setcCorrectOptionId(cCorrectOptionId);
            //更新正确选项的ID
            questionService.saveOrUpdateReturnPrimaryKey(question);
        }else{//修改
            questionOption = questionVo.getcQoContents();
            List<String> qoIdList = questionVo.getcQoIds();

            cCorrectOptionId = new Long(qoIdList.get(questionVo.getcCorrectOptionId().intValue()));
            question.setcCorrectOptionId(cCorrectOptionId);
            //更新正确选项的ID
            questionService.saveOrUpdateReturnPrimaryKey(question);

            //更新所有选项
            Long cQuesId = question.getcQuesId();//从页面对象中获取试题ID
            List<QuestionOptions> questionOptionsList = changeQuestionOptionsWithQoIdList(questionOption,qoIdList,cQuesId);
            effectRows = questionOptionService.batchUpdate(questionOptionsList);
        }
        if(effectRows>0){
            return "question/list-question";
        }else{
            return "error";
        }
    }

    /**
     * 组装试题对象（更新）
     * @param contentList
     * @param qoIdList
     * @param cQuesId
     * @return
     */
    private List<QuestionOptions> changeQuestionOptionsWithQoIdList(List<String> contentList, List<String> qoIdList, Long cQuesId) {
        List<QuestionOptions> questionOptionsList =  new ArrayList<QuestionOptions>();
        QuestionOptions questionOption = null;
        int i = 0;
        for(String item:contentList){
            questionOption = new QuestionOptions();
            questionOption.setcQoId(new Long(qoIdList.get(i)));
            questionOption.setcQuesId(cQuesId);
            questionOption.setcQoContent(item);
            questionOptionsList.add(questionOption);
            i++;
        }
        return questionOptionsList;
    }

    /**
     * 从QuestionVo拷贝值到Question
     * @param question
     * @param questionVo
     */
    private void copyValue(Question question, QuestionVo questionVo) {
        question.setcEpId(questionVo.getcEpId());
        question.setcChId(questionVo.getcChId());
        question.setcCorrectOptionId(questionVo.getcCorrectOptionId());
        question.setcCorrectValue(questionVo.getcCorrectValue());
        question.setcIsEnglish(questionVo.getcIsEnglish());
        question.setcQuesTitle(questionVo.getcQuesTitle());
        question.setcQuesType(questionVo.getcQuesType());
        question.setcQuesId(questionVo.getcQuesId());
    }

    /**
     * 将试题选项值转换成选项对象
     * @param questionOptions 试题选项内容集合
     * @param cQuesId 试题ID
     * @return
     */
    private List<QuestionOptions> changeQuestionOptions(List<String> questionOptions,Long cQuesId) {
        List<QuestionOptions> questionOptionsList =  new ArrayList<QuestionOptions>();
        QuestionOptions questionOption = null;
        for(String item:questionOptions){
            questionOption = new QuestionOptions();
            questionOption.setcQuesId(cQuesId);
            questionOption.setcQoContent(item);
            questionOptionsList.add(questionOption);
        }
        return questionOptionsList;
    }

    /**
     * 编辑
     * @return
     */
    @RequestMapping("/edit")
    public String edit(Question question,Model model){
        Long cQuestId = question.getcQuesId();
        Question  entity = questionService.queryQuestionByPrimaryKey(cQuestId);
        List<QuestionOptions> list = questionOptionService.queryAllQuestionOptionByCQuestId(cQuestId);
        model.addAttribute("model",entity);
        model.addAttribute("list",list);
        return "question/add-question";
    }

    @RequestMapping("/delete")
    public String delete(Question question){
        Long cQuestId = question.getcQuesId();
        int effortRow = questionOptionService.deleteOptionByCQuesId(cQuestId);
        if(effortRow >=4){
            effortRow = questionService.deleteQuestionByPrimaryKey(cQuestId);
            if(effortRow>=1){
                return "question/list-question";
            }
        }
        return "error";
    }
}
