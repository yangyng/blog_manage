package com.yangy.manage.service;

import com.yangy.manage.domain.SysUser;

/**
 * @author yang yang
 */
public interface ISysUserService {

    /**
     * 根据用户名查询用户信息
     *
     * @param accountName
     * @return
     */
    SysUser findByAccountName(String accountName);
}
