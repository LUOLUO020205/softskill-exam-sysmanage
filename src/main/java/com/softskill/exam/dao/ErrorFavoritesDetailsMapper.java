package com.softskill.exam.dao;

import com.softskill.exam.domain.ErrorFavoritesDetails;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ErrorFavoritesDetailsMapper {
    int deleteByPrimaryKey(Long cEfdId);

    int insert(ErrorFavoritesDetails record);

    int insertSelective(ErrorFavoritesDetails record);

    ErrorFavoritesDetails selectByPrimaryKey(Long cEfdId);

    int updateByPrimaryKeySelective(ErrorFavoritesDetails record);

    int updateByPrimaryKey(ErrorFavoritesDetails record);
}