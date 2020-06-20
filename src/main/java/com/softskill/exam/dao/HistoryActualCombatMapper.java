package com.softskill.exam.dao;

import com.softskill.exam.domain.HistoryActualCombat;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HistoryActualCombatMapper {
    int deleteByPrimaryKey(Long cHacId);

    int insert(HistoryActualCombat record);

    int insertSelective(HistoryActualCombat record);

    HistoryActualCombat selectByPrimaryKey(Long cHacId);

    int updateByPrimaryKeySelective(HistoryActualCombat record);

    int updateByPrimaryKey(HistoryActualCombat record);
}