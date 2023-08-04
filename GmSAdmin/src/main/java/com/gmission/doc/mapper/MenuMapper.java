package com.gmission.doc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.gmission.doc.vo.LeftMenuVO;

@Repository
@Mapper
public interface MenuMapper {

    List<LeftMenuVO> selectLeftMenuRoleAuth(LeftMenuVO leftMenuVO);

}
