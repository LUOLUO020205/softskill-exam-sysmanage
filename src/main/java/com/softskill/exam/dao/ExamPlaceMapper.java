package com.softskill.exam.dao;

import com.softskill.exam.domain.ExamPlace;
import com.softskill.exam.vo.ExamPlaceVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ExamPlaceMapper {
    int deleteByPrimaryKey(Long cEpId);

    int insert(ExamPlace record);

    int insertSelective(ExamPlace record);

    ExamPlace selectByPrimaryKey(Long cEpId);

    int updateByPrimaryKeySelective(ExamPlace record);

    int updateByPrimaryKey(ExamPlace record);

    List<ExamPlaceVo> selectAllExamPlace();

    List<ExamPlaceVo> selectAllExamPlaceByCouseId(Map<String, Object> params);

    Long countAllExamPlaceByCouseId(Map<String, Object> params);
}