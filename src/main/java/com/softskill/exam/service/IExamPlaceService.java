package com.softskill.exam.service;

import com.softskill.exam.domain.ExamPlace;
import com.softskill.exam.vo.ExamPlaceVo;

import java.util.List;
import java.util.Map;

public interface IExamPlaceService {
    public int saveOrUpdate(ExamPlace entity);
    List<ExamPlaceVo> queryAllExamPlace();
    ExamPlace queryExamPlaceByPrimaryKey(Long cEpId);
    int deleteExamPlaceByPrimaryKey(Long cEpId);

    List<ExamPlaceVo> queryAllExamPlaceByParams(Map<String, Object> params);
}
