package com.softskill.exam.dao;

import com.softskill.exam.domain.ExercisesRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExercisesRecordMapper {
    int deleteByPrimaryKey(Long cErId);

    int insert(ExercisesRecord record);

    int insertSelective(ExercisesRecord record);

    ExercisesRecord selectByPrimaryKey(Long cErId);

    int updateByPrimaryKeySelective(ExercisesRecord record);

    int updateByPrimaryKey(ExercisesRecord record);
}