package com.example.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.mybatisplus.mapper.AdminMapper;
import com.example.mybatisplus.model.domain.Admin;
import com.example.mybatisplus.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisplusApplicationTests {

    @Autowired
    private AdminMapper adminMapper;
    @Test
    void testMethod() {

        //准备写一条插入，两条查询，一条删除，一条更改
        Admin admin = new Admin().setLoginName("钟民杰").setPassword("123456");

        //添加
        adminMapper.insert(admin);

        //查询
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("LoginName","钟民杰");
        List<Admin> admins = adminMapper.selectList(queryWrapper);
        System.out.println(admins);

        admin = adminMapper.selectById(2);
        System.out.println(admin);

        //删除
        adminMapper.deleteById(1);

        //更改
        admin.setPassword("233333");
        UpdateWrapper<Admin> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("LoginName","钟民杰");
        adminMapper.update(admin, updateWrapper);
    }

}
