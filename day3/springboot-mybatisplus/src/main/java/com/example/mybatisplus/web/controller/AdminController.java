package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.AdminService;
import com.example.mybatisplus.model.domain.Admin;

import java.util.List;


/**
 *
 *  前端控制器
 *
 *
 * @author lxp
 * @since 2021-06-17
 * @version v1.0
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final Logger logger = LoggerFactory.getLogger( AdminController.class );

    @Autowired
    private AdminService adminService;
    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Admin  admin =  adminService.getById(id);
        return JsonResponse.success(admin);
    }

    @GetMapping("/all")
    public JsonResponse getAll() throws Exception {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        List<Admin> admins = adminService.list(queryWrapper);
        return JsonResponse.success(admins);
    }
}

