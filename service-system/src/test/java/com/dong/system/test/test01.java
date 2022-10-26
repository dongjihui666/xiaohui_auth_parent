package com.dong.system.test;

import com.dong.model.system.SysRole;
import com.dong.system.mapper.SysRoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class test01 {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Test
    public void testSelectList(){
        System.out.println("select");
        //UserMapper 中的 selectList() 方法的参数为 MP 内置的条件封装器 Wrapper
        //所以不填写就是无任何条件
        List<SysRole> users  = sysRoleMapper.selectList(null);
        for (SysRole sysRole : users){
            System.out.println(sysRole);
        }
    }
}
