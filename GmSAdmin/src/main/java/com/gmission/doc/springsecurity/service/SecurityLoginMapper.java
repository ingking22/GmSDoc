package com.gmission.doc.springsecurity.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.gmission.doc.springsecurity.UserLoginVO;

@Repository	
@Mapper
public interface SecurityLoginMapper {

	List<UserLoginVO> selectLoginCheck(String loginid);
	
}
