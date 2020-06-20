package com.softskill.exam.controller;

import com.softskill.exam.domain.Chapter;
import com.softskill.exam.domain.Course;
import com.softskill.exam.domain.PageModel;
import com.softskill.exam.domain.WebUtil;
import com.softskill.exam.service.IChapterService;
import com.softskill.exam.service.ICourseService;
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
@RequestMapping(value = "/chapter")
public class ChapterController {

    @Autowired
    private IChapterService chapterService;
    @Autowired
    private ICourseService courseService;

    @RequestMapping("/list")
    @ResponseBody
    public  Map<String, Object> list(HttpServletRequest request, PageModel pageModel){
        Map<String, Object> returnParams = new HashMap<String, Object>();
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            WebUtil.getParamersMap(request, params);
            params.put("pageModel", pageModel);
            List<Chapter> chapterList = chapterService.queryAllChapter(params);
            pageModel.setItems(chapterList);
            returnParams.put("pageModel", pageModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnParams;
    }

    @RequestMapping("/add")
    public String add(Model model){
        Map<String, Object> params = new HashMap<String, Object>();
        List<Course> courseList = courseService.queryAllCourse();
        model.addAttribute("courseList",courseList);
        return "chapter/add-chapter";
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Long cChId,Long cCourseId,String cChName,Integer cCourseSortnum){
        Chapter chapter = new Chapter();
        chapter.setcChId(cChId);
        chapter.setcCourseId(cCourseId);
        chapter.setcChName(cChName);
        chapter.setcCourseSortnum(cCourseSortnum);
        int effectRows = chapterService.saveOrUpdate(chapter);
        if(effectRows>0){
            return "chapter/list-chapter"; //重定向到当前controller的list方法
        }else{
            return "error";
        }
    }

    @RequestMapping("/delete")
    public String delete(Long cChId){
        int effectRows = chapterService.deleteChapterBycChId(cChId);
        if(effectRows>0){
            return "chapter/list-chapter";
        }else{
            return "error";
        }
    }

    @RequestMapping("/edit")
    public String edit(Long cChId,Model model){
        Chapter chapter = chapterService.selectChapterById(cChId);
        model.addAttribute("model",chapter);
        List<Course> courseList = courseService.queryAllCourse();
        model.addAttribute("courseList",courseList);
        return "chapter/add-chapter";
    }
}
