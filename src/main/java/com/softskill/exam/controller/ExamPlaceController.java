package com.softskill.exam.controller;

import com.softskill.exam.domain.Chapter;
import com.softskill.exam.domain.ExamPlace;
import com.softskill.exam.domain.PageModel;
import com.softskill.exam.domain.WebUtil;
import com.softskill.exam.service.IExamPlaceService;
import com.softskill.exam.vo.ExamPlaceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/exam-place")
public class ExamPlaceController {

    @Autowired
    private IExamPlaceService examPlaceService;

    @RequestMapping("/add")
    public String add(Long cChId,Model model){
        ExamPlace entity = new ExamPlace();
        entity.setcChId(cChId);
        model.addAttribute("model",entity);
        return "exam-place/add-examPlace";
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(ExamPlace entity){
        int effectRows = examPlaceService.saveOrUpdate(entity);
        if(effectRows>0){
            return  "exam-place/list-examPlace";
        }else{
            return "error";
        }
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, PageModel pageModel){
        Map<String, Object> returnParams = new HashMap<String, Object>();
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            WebUtil.getParamersMap(request, params);
            params.put("pageModel", pageModel);
            List<ExamPlaceVo>  examPlaceList = examPlaceService.queryAllExamPlaceByParams(params);
            pageModel.setItems(examPlaceList);
            returnParams.put("pageModel", pageModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnParams;
    }

    @RequestMapping("/edit")
    public String edit(Long cEpId,Model model){
        ExamPlace examPlace = examPlaceService.queryExamPlaceByPrimaryKey(cEpId);
        model.addAttribute("model",examPlace);
        return "exam-place/add-examPlace";
    }

    @RequestMapping("/delete")
    public String delete(Long cEpId){
        int effectRows = examPlaceService.deleteExamPlaceByPrimaryKey(cEpId);
        if(effectRows>0){
            return "exam-place/list-examPlace";
        }else{
            return "error";
        }
    }

}
