package com.yangy.manage.dao;

import com.yangy.manage.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yang yang
 */
@Mapper
public interface SysUserMapper {

    /**
     * 根据账户名称查询用户信息
     *
     * @param accountName
     * @return com.yangy.manage.domain.SysUser
     * @date 2019-09-10
     * @author yang yang
     **/
    SysUser findByAccountName(String accountName);

    /**
     * 添加一个用户
     *
     * @param sysUser
     * @return int
     * @date 2019-09-10
     * @author yang yang
     **/
    int save(SysUser sysUser);

    int deleteAll();
}
