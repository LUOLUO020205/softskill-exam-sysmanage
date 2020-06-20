package com.softskill.exam.dao;

import com.softskill.exam.domain.Chapter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ChapterMapper {
    int deleteByPrimaryKey(Long cChId);

    int insert(Chapter record);

    int insertSelective(Chapter record);

    Chapter selectByPrimaryKey(Long cChId);

    int updateByPrimaryKeySelective(Chapter record);

    int updateByPrimaryKey(Chapter record);

    List<Chapter> selectAllChapterByCouseId(Map<String, Object> params);

    Long countAllChapterByCouseId(Map<String, Object> params);
}