package com.dong.system.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dong.model.system.SysRole;
import com.dong.system.mapper.SysRoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
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
    // 测试添加操作
    @Test
    public void add(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("小虫");
        sysRole.setRoleCode("TEST");
        sysRole.setDescription("测试");
        int insert = sysRoleMapper.insert(sysRole);
        System.out.println(insert);
    }
    // 修改操作
    @Test
    public void update(){
        // 根据ID查询
        SysRole sysRole = sysRoleMapper.selectById(1);
        // 设置修改值
        sysRole.setDescription("系统管理员111111111111111");
        // 调用方法实现修改
        sysRoleMapper.updateById(sysRole);
    }

    // 删除(物理删除 和 逻辑删除)
    /**
     *物理删除  表数据真正删除
     *
     *逻辑删除  表数据还存在,但是这个数据查询不出来
     */
    // id删除
    @Test
    public void delete(){
        int i = sysRoleMapper.deleteById(2);
        System.out.println(i);
    }
    // 批量删除
    public void deleteAll(){
        sysRoleMapper.deleteBatchIds(Arrays.asList(1,2));
    }

    // 条件查询
    @Test
    public void select(){
        // 创建一个条件构造器
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        wrapper.eq("role_name","系统管理员111111111111111");
        List<SysRole> list = sysRoleMapper.selectList(wrapper);
        System.out.println(list);
    }
    // 条件删除
    @Test
    public void testDelete(){
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_name","系统管理员111111111111111");
        sysRoleMapper.delete(queryWrapper);
    }
}

