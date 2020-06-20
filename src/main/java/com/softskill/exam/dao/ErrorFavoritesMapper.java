package com.softskill.exam.dao;

import com.softskill.exam.domain.ErrorFavorites;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ErrorFavoritesMapper {
    int deleteByPrimaryKey(Long cEfId);

    int insert(ErrorFavorites record);

    int insertSelective(ErrorFavorites record);

    ErrorFavorites selectByPrimaryKey(Long cEfId);

    int updateByPrimaryKeySelective(ErrorFavorites record);

    int updateByPrimaryKey(ErrorFavorites record);
}