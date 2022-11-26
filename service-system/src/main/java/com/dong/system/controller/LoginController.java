package com.dong.system.controller;

import com.dong.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 登录接口
 */
@Api(tags="用户登录接口")
@RestController
@RequestMapping("/admin/system/index")
public class LoginController {

    // Login
    @PostMapping("login")
    public Result login(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("token","admin-token");
        // {"code":20000,"data":{"token":"admin-token"}}
        return Result.ok(map);
    }

    // info
    @GetMapping("info")
    public Result info(){
        HashMap<String, Object> map = new HashMap<>();
        // {"code":20000,"data":{"roles":["admin"],
        // "introduction":"I am a super administrator",
        // "avatar":"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif",
        // "name":"Super Admin"}}
        map.put("roles","[admin]");
        map.put("introduction","I am a super administrator");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name","Super Admin");

        return Result.ok(map);
    }
}
