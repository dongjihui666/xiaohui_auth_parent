package com.dong.system.controller;

import com.dong.model.system.SysRole;
import com.dong.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    // 1 查询所有记录
    @GetMapping("findAll")
    public List<SysRole> findAll(){
        List<SysRole> list = sysRoleService.list();
        return list;
    }
    // 2 逻辑删除接口
    @DeleteMapping("remove/{id}")
    public boolean removeRole(@PathVariable Long id){

        boolean isSuccess = sysRoleService.removeById(id);
        return isSuccess ;
    }
}
