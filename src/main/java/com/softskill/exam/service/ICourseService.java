package com.softskill.exam.service;

import com.softskill.exam.domain.Course;

import java.util.List;
import java.util.Map;

public interface ICourseService {

    public int saveCourse(Course course);

    public List<Course> queryAllCourse();

    List<Course> queryAllCourseByParams(Map<String, Object> params);

    Course queryCourseDetail(Course course);

    int updateCourse(Course course);

    int deleteCourseById(Long cCourseId);
}
