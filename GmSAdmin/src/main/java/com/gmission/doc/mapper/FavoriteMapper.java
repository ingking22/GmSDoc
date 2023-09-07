package com.gmission.doc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gmission.doc.vo.FavoriteVO;

@Mapper
public interface FavoriteMapper {

    List<FavoriteVO> selectFavoritOptionByUserID(FavoriteVO favoriteVO);

}
