package com.softskill.exam.service.impl;

import java.util.List;
import java.util.Map;

import com.softskill.exam.dao.CourseMapper;
import com.softskill.exam.domain.Course;
import com.softskill.exam.domain.PageModel;
import org.springframework.beans.factory.annotation.Autowired;

import com.softskill.exam.service.ICourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseMapper courseMapper;

    public int saveCourse(Course course) {
        return courseMapper.insert(course);
    }

    public List<Course> queryAllCourse() {
        return courseMapper.selectAll();
    }

    @Override
    public List<Course> queryAllCourseByParams(Map<String, Object> params) {
        PageModel pageModel=(PageModel) params.get("pageModel");
        Long count = courseMapper.countAllCourseByParams(params);
        pageModel.setRecordCount(count);
        return courseMapper.selectAllCourseByParams(params);
    }

    @Override
    public Course queryCourseDetail(Course course) {
        return courseMapper.selectByPrimaryKey(course);
    }

    @Override
    public int updateCourse(Course course) {
        return courseMapper.updateByPrimaryKeySelective(course);
    }

    @Override
    public int deleteCourseById(Long cCourseId) {
        return courseMapper.deleteByPrimaryKey(cCourseId);
    }


}
