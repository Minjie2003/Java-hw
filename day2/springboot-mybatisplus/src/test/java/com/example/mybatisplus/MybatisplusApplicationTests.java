package com.example.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.example.mybatisplus.mapper.AdminMapper;
import com.example.mybatisplus.mapper.RoomMapper;
import com.example.mybatisplus.model.domain.Admin;
import com.example.mybatisplus.model.domain.Room;
import com.example.mybatisplus.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootTest
class MybatisplusApplicationTests {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private RoomMapper roomMapper;
    //多条件查询
    @Test
    void queryCondition(){
        //select * from admin where id=#{id} and LoginName=#{loginName}
        Admin admin = new Admin().setId(4L).setLoginName("样例1");
        List<Admin> admins = adminMapper.selectByAdmin(admin);
        System.out.println(admins);
    }

    //批量删除
    @Test
    void deleteCondition(){
        //delete from admin where id=(5,6,7)
        List<Long> list = Arrays.asList(5L,6L,7L);
        adminMapper.deleteByList(list);

    }

    //批量添加
    @Test
    void addCondition(){
        //insert into admin(loginName,password) values (..) (...)
        Admin admin1 = new Admin().setLoginName("欧文").setPassword("213157");
        Admin admin2 = new Admin().setLoginName("库里").setPassword("965802");
        List<Admin> admins = Arrays.asList(admin1,admin2);
        adminMapper.insertByAdmin(admins);
    }

    //表admin连接room
    @Test
    void contact1(){
        //select * from room
        //LEFT JOIN admin ON room.admin_id=admin,id
        //WHERE room.id=1
        Room room = roomMapper.selectIdWithAdmin(1);
        System.out.println(room);
    }

    //表room连接admin
    @Test
    void contact2(){
        //select * from admin
        //LEFT JOIN room On room.admin_id=admin.id
        //WHERE admin.id=1
        Admin admin = adminMapper.seleIdWithRoom(2);
        System.out.println(admin);
    }
}
