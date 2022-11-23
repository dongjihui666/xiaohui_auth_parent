package com.dong.system.controller;

import com.dong.common.result.Result;
import com.dong.model.system.SysRole;
import com.dong.system.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "角色管理")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    // 1 查询所有记录
    @ApiOperation(value = "获取全部角色列表")
    @GetMapping("findAll")
    public Result<List<SysRole>>  findAll(){
        List<SysRole> list = sysRoleService.list();
        return Result.ok(list);
    }
    // 2 逻辑删除接口
    @DeleteMapping("remove/{id}")
    public Result removeRole(@PathVariable Long id){
        boolean isSuccess = sysRoleService.removeById(id);
        if (isSuccess){
            return Result.ok() ;
        }else {
            return Result.fail("删除失败");
        }
    }
}
