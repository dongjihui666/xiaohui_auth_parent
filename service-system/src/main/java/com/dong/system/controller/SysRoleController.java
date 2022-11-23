package com.dong.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dong.common.result.Result;
import com.dong.model.system.SysRole;
import com.dong.model.vo.SysRoleQueryVo;
import com.dong.system.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.io.ResolverUtil;
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
    @ApiOperation("逻辑删除接口")
    @DeleteMapping("remove/{id}")
    public Result removeRole(@PathVariable Long id){
        boolean isSuccess = sysRoleService.removeById(id);
        if (isSuccess){
            return Result.ok() ;
        }else {
            return Result.fail("删除失败");
        }
    }
    // 3 条件分页查询
    @ApiOperation("条件分页查询")
    @GetMapping("/{page}/{limit}")
    public Result index(
            // sysRoleQueryVo 分页的条件
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数",required = true)
            @PathVariable Long limit,
            @ApiParam(name = "roleQueryVc",value = "查询对象", required = false)
            SysRoleQueryVo sysRoleQueryVo){
        // 创建分页查询
        Page<SysRole> pageParam = new Page<>(page, limit);
        // 调用service方法实现
        // 传入配置对象,传入条件
        IPage<SysRole> pageModel = sysRoleService.selectPage(pageParam, sysRoleQueryVo);
        // 返回
        return Result.ok(pageModel);
    }
    // 获取角色
    @ApiOperation(value = "获取角色")
    @GetMapping("/get/{id}")
    public Result get(@PathVariable Long id){
        SysRole role = sysRoleService.getById(id);
        return Result.ok(role);
    }
    // 新增角色
    @ApiOperation(value = "新增角色")
    @PostMapping("/save")
    public Result save(@RequestBody SysRole role){
        sysRoleService.save(role);
        return Result.ok("新增角色成功");
    }
    // 修改角色
    @ApiOperation(value = "修改角色")
    @PostMapping("/update")
    public Result updateById(@RequestBody SysRole role){
        sysRoleService.save(role);
        return Result.ok("修改角色成功");
    }
    // 根据ID列表删除
    @ApiOperation(value = "根据ID列表删除")
    @DeleteMapping("/batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList){
        sysRoleService.removeByIds(idList);
        return Result.ok("删除id成功");
    }
}
