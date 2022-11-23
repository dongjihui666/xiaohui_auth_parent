package com.dong.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dong.model.system.SysRole;
import com.dong.model.vo.SysRoleQueryVo;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;


@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {
    // 条件分页查询
    IPage<SysRole> selectPage(Page<SysRole> page,@Param("vo") SysRoleQueryVo roleQueryVo);
}
