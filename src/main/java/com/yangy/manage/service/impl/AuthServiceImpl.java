package com.yangy.manage.service.impl;

import com.alibaba.fastjson.JSON;
import com.yangy.manage.dao.SysUserMapper;
import com.yangy.manage.domain.SysMenu;
import com.yangy.manage.domain.SysRole;
import com.yangy.manage.domain.SysUser;
import com.yangy.manage.pojo.LoginUserVO;
import com.yangy.manage.pojo.LoginVO;
import com.yangy.manage.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

/**
 * @author yang yang
 * @email m17610912950@163.com
 * @time 2019年10月22日 17:55
 **/
@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 用户登录接口
     *
     * @param loginVO
     * @return com.yangy.manage.pojo.LoginUserVO
     * @date 2019-10-22
     * @author yang yang
     **/
    @Override
    public LoginUserVO doLogin(LoginVO loginVO) {
        log.debug("用户登录接口->请求参数:{}", JSON.toJSONString(loginVO));
        //TODO
        //校验验证码
        //校验用户的账号密码
        //返回用户信息
        //用户信息放入 session 设置失效时间
        return null;
    }

    /**
     * 重置密码
     *
     * @param loginVO
     * @return boolean
     * @date 2019-10-22
     * @author yang yang
     **/
    @Override
    public boolean resetPwd(LoginVO loginVO) {
        //校验验证码
        return false;
    }

    /**
     * 修改用户信息
     *
     * @param loginVO
     * @return boolean
     * @date 2019-10-22
     * @author yang yang
     **/
    @Override
    public boolean updateUserInfo(LoginVO loginVO) {
        return false;
    }

    /**
     * 用户登出接口
     *
     * @param loginVO
     * @return boolean
     * @date 2019-10-22
     * @author yang yang
     **/
    @Override
    public boolean logout(LoginVO loginVO) {
        return false;
    }

    /**
     * 获取当前用户的权限信息
     *
     * @param loginVO
     * @return java.lang.Object
     * @date 2019-10-22
     * @author yang yang
     **/
    @Override
    public Object getUserPermission(LoginVO loginVO) {
        SysUser sysUserDAO = sysUserMapper.findByAccountName(loginVO.getLoginName());
        LinkedList<SysRole> roleList = sysUserDAO.getRoleList();
        LinkedList<SysMenu> menuList = sysUserDAO.getMenuList();


        return null;
    }
}
