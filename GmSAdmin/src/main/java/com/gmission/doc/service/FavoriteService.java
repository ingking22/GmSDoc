package com.gmission.doc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmission.doc.mapper.FavoriteMapper;
import com.gmission.doc.vo.FavoriteVO;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteMapper favoriteMapper;

    public List<FavoriteVO> selectFavoritOptionByUserID(FavoriteVO favoriteVO) {
        return favoriteMapper.selectFavoritOptionByUserID(favoriteVO);
    }

}
