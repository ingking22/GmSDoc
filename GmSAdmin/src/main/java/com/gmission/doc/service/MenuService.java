package com.gmission.doc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmission.doc.mapper.MenuMapper;
import com.gmission.doc.vo.LeftMenuVO;

@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    public List<LeftMenuVO> selectLeftMenuRoleAuth(String roleName) {
        return menuMapper.selectLeftMenuRoleAuth(new LeftMenuVO() {{ setAuthoritycd(roleName); }});
    }

}
