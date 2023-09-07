package com.gmission.doc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmission.doc.service.FavoriteService;
import com.gmission.doc.springsecurity.UserLoginVO;
import com.gmission.doc.vo.FavoriteVO;

@RestController
@RequestMapping("/Favorite")
public class FavoriteController {


    @Autowired
    private FavoriteService favoriteService;

    @PostMapping("/selectFavoritOptionByUserID")
    public List<FavoriteVO> selectFavoritOptionByUserID(
            @RequestBody(required = false) FavoriteVO favoriteVO) {

        // 사용자 정보를 꺼내온다
        UserLoginVO loginVO= (UserLoginVO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        favoriteVO.setUserid(loginVO.getLoginid());

        return favoriteService.selectFavoritOptionByUserID(favoriteVO);
    }




}
