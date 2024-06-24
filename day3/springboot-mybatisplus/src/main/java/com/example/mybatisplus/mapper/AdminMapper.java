package com.example.mybatisplus.mapper;

import com.example.mybatisplus.model.domain.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lxp
 * @since 2021-06-17
 */
@Repository
public interface AdminMapper extends BaseMapper<Admin> {

    List<Admin> selectByAdmin(@Param("admin") Admin admin);

    void deleteByList(@Param("ids") List<Long> list);

    void insertByAdmin(@Param("admins") List<Admin> admins);

    Admin seleIdWithRoom(@Param("id") int i);
}
