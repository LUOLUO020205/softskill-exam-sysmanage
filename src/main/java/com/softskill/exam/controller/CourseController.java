package com.softskill.exam.controller;

import com.softskill.exam.domain.Chapter;
import com.softskill.exam.domain.Course;
import com.softskill.exam.domain.PageModel;
import com.softskill.exam.domain.WebUtil;
import com.softskill.exam.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @RequestMapping("/save")
    public String saveCourse(Course course) {
        String url = "error";
        Course courseDetail = courseService.queryCourseDetail(course);
        if(courseDetail == null && course.getcCourseId()==null){//新增
            course.setcCreateTime(new Date());
            course.setcUpdateTime(new Date());
            int rn = courseService.saveCourse(course);
            if (rn > 0) {
                url = "course/list-course";
            }
        }else{//修改
            int effectRows = courseService.updateCourse(course);
            if(effectRows>0){
                url = "course/list-course";
            }
        }
        return url;
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> listCourse(HttpServletRequest request, PageModel pageModel) {
        Map<String, Object> returnParams = new HashMap<String, Object>();
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            WebUtil.getParamersMap(request, params);
            params.put("pageModel", pageModel);
            List<Course> courseList = courseService.queryAllCourseByParams(params);
            pageModel.setItems(courseList);
            returnParams.put("pageModel", pageModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnParams;
    }

    @RequestMapping("/edit")
    public String edit(Course course,Model model){
        Course courseDetail  = courseService.queryCourseDetail(course);
        model.addAttribute("model",courseDetail);
        return "course/add-course";
    }

    @RequestMapping("/delete")
    public String edit(Long cCourseId){
        String url = "error";
        int effectRows = courseService.deleteCourseById(cCourseId);
        if(effectRows>0){
            url = "course/list-course";
        }
        return url;
    }
}
