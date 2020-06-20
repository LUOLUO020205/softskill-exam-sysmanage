package com.softskill.exam.dao;

import com.softskill.exam.domain.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CourseMapper {
    int deleteByPrimaryKey(Long cCourseId);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Course course);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    List<Course> selectAll();

    Long countAllCourseByParams(Map<String, Object> params);

    List<Course> selectAllCourseByParams(Map<String, Object> params);

}