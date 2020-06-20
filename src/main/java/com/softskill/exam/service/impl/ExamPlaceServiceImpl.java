package com.softskill.exam.service.impl;

import com.softskill.exam.dao.ExamPlaceMapper;
import com.softskill.exam.domain.ExamPlace;
import com.softskill.exam.domain.PageModel;
import com.softskill.exam.service.IExamPlaceService;
import com.softskill.exam.vo.ExamPlaceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ExamPlaceServiceImpl implements IExamPlaceService {

    @Autowired
    private ExamPlaceMapper examPlaceMapper;

    @Override
    public int saveOrUpdate(ExamPlace entity) {
        if(entity.getcEpId()!=null && entity.getcEpId().intValue()>0){
            return examPlaceMapper.updateByPrimaryKey(entity);
        }else{
            return examPlaceMapper.insert(entity);
        }
    }

    @Override
    public List<ExamPlaceVo> queryAllExamPlace() {
        return examPlaceMapper.selectAllExamPlace();
    }

    @Override
    public ExamPlace queryExamPlaceByPrimaryKey(Long cEpId) {
        return examPlaceMapper.selectByPrimaryKey(cEpId);
    }

    @Override
    public int deleteExamPlaceByPrimaryKey(Long cEpId) {
        return examPlaceMapper.deleteByPrimaryKey(cEpId);
    }

    @Override
    public List<ExamPlaceVo> queryAllExamPlaceByParams(Map<String, Object> params) {
        PageModel pageModel=(PageModel) params.get("pageModel");
        Long count = examPlaceMapper.countAllExamPlaceByCouseId(params);
        pageModel.setRecordCount(count);
        return examPlaceMapper.selectAllExamPlaceByCouseId(params);
    }


}
