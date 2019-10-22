package com.yangy.manage.service;

import com.yangy.manage.pojo.LoginUserVO;
import com.yangy.manage.pojo.LoginVO;

/**
 * @author yang yang
 * @date 2019-10-22
 **/
public interface AuthService {

    /**
     * 用户登录接口
     *
     * @param loginVO
     * @return com.yangy.manage.pojo.LoginUserVO
     * @date 2019-10-22
     * @author yang yang
     **/
    LoginUserVO doLogin(LoginVO loginVO);

    /**
     * 重置密码
     *
     * @param loginVO
     * @return boolean
     * @date 2019-10-22
     * @author yang yang
     **/
    boolean resetPwd(LoginVO loginVO);

    /**
     * 修改用户信息
     *
     * @param loginVO
     * @return boolean
     * @date 2019-10-22
     * @author yang yang
     **/
    boolean updateUserInfo(LoginVO loginVO);

    /**
     * 用户登出接口
     *
     * @param loginVO
     * @return boolean
     * @date 2019-10-22
     * @author yang yang
     **/
    boolean logout(LoginVO loginVO);

    /**
     * 获取当前用户的权限信息
     * @param loginVO
     * @return java.lang.Object
     * @date 2019-10-22
     * @author yang yang
     **/
    Object getUserPermission(LoginVO loginVO);
}
