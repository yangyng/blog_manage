package com.yangy.manage.controller;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yang yang
 * @email m17610912950@163.com
 * @time 2019年09月06日 15:22
 **/
@RestControllerAdvice
public class BaseController {

    /**
     * 获取用户信息
     *
     * @param
     * @return java.lang.Object
     * @date 2019-09-10
     * @author yang yang
     **/
    public Object getUserInfo(HttpServletRequest request) {
        String token = request.getHeader("user:token:");
        //TODO 根据用户的session获取用户信息

        return null;
    }

    /**
     * 获取用户主键
     *
     * @param
     * @return java.lang.String
     * @date 2019-09-10
     * @author yang yang
     **/
    public String getUserId() {
        return null;
    }

    /**
     * 获取用户角色列表
     *
     * @param
     * @return java.lang.Object
     * @date 2019-09-10
     * @author yang yang
     **/
    public Object getUserRoleList() {
        return null;
    }

    /**
     * 获取用户的权限列表
     *
     * @param
     * @return java.lang.Object
     * @date 2019-09-10
     * @author yang yang
     **/
    public Object getUserPermList() {

        return null;
    }

    private Object getUserInfoByToken(String token) {

        return null;
    }
}
