package com.gmission.doc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gmission.doc.service.MenuService;
import com.gmission.doc.springsecurity.UserLoginVO;
import com.gmission.doc.vo.LeftMenuVO;

@Controller
@RequestMapping("/dtc")
public class IndexController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/indexDTC")
    public String dtcIndex(Model model) {
        // 1. 사용자의 권한 Name으로 메뉴를 조회 한다.
        UserLoginVO loginVO= (UserLoginVO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("leftMenu", menuService.selectLeftMenuRoleAuth(loginVO.getUserauthcd()));

        return "/indexDTC";
    }




}
