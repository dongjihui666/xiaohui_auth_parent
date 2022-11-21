package com.dong.system.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dong.model.system.SysRole;
import com.dong.system.service.SysRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class test02 {

    // 注入service
    @Autowired
    private SysRoleService sysRoleService;

    @Test
    // 测试查询全部
    public void findAll(){

        List<SysRole> list = sysRoleService.list();
        System.out.println(list);
    }

    @Test
    // 添加
    public void add(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("小虫1234");
        sysRoleService.save(sysRole);
    }

}
