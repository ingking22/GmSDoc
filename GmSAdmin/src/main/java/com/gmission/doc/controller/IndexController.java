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
@RequestMapping("/DTC")
public class IndexController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/indexDTC")
    public String dtcIndex(Model model) {
        model.addAttribute("leftMenu", GetAuthLeftMenu(""));

        return "/indexDTC";
    }


    @GetMapping("/RequestExport")
    public String requestExport(Model model) {
        model.addAttribute("leftMenu", GetAuthLeftMenu("MN0101"));

        return "/export/RequestExport";
    }

    public List<LeftMenuVO> GetAuthLeftMenu(String activeMenu) {
        // 1. 사용자의 권한 Name으로 메뉴를 조회 한다.
        UserLoginVO loginVO= (UserLoginVO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<LeftMenuVO> leftMenuList = menuService.selectLeftMenuRoleAuth(loginVO.getUserauthcd());

        LeftMenuVO defVO = new LeftMenuVO();
        if(!activeMenu.equals(""))
            leftMenuList.stream().filter(a -> a.getProgramcd().equals(activeMenu)).findFirst().orElse(defVO).setActiveyn("Y");

        return leftMenuList;
    }


}
