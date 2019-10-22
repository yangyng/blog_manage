package com.yangy.manage.service.impl;

import com.yangy.manage.common.model.Result;
import com.yangy.manage.dao.SysUserMapper;
import com.yangy.manage.domain.SysMenu;
import com.yangy.manage.domain.SysUser;
import com.yangy.manage.pojo.LoginVO;
import com.yangy.manage.service.ISysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yang yang
 * @email m17610912950@163.com
 * @time 2019年08月13日 17:10
 **/
@Service
public class SysUserServiceImpl implements ISysUserService {

    @Resource
    private SysUserMapper userRepository;

    /**
     * 根据用户名查询用户信息
     *
     * @param accountName
     * @return
     */
    @Override
    public SysUser findByAccountName(String accountName) {
        return userRepository.findByAccountName(accountName);
    }

    /**
     * 查询菜单集合
     * @param accountName
     * @return com.yangy.manage.domain.SysUser
     * @date 2019-09-12
     * @author yang yang
     **/
    public SysUser findMenuList(String accountName) {
        return null;
    }

    /**
     * 测试方法 用来递归方式实现菜单列表
     *
     * @param args
     * @return void
     * @date 2019-09-12
     * @author yang yang
     **/
    public static void main(String[] args) {
//        SysUser sysUser = new SysUser();
//        LinkedList<SysMenu> menuList = sysUser.getMenuList();
//        //获取菜单列表中 父菜单为空的 及 一级主菜单
//        List<SysMenu> parentMenu = menuList.stream()
//                .filter(sysMenu -> null == sysMenu.getParentMenu())
//                .collect(Collectors.toList());
//
//        List<SysMenu> children = menuList.stream()
//                .filter(sysMenu -> null != sysMenu.getParentMenu())
//                .collect(Collectors.toList());
//
//        for (SysMenu menu : parentMenu) {
//
//        }

    }


    /**
     * 添加一个系统用户
     *
     * @param sysUser
     * @return void
     * @date 2019-09-10
     * @author yang yang
     **/
    @Transactional(rollbackFor = Exception.class)
    public void add(SysUser sysUser) {
        if (sysUser.getNickName().equalsIgnoreCase("yang")) {
            throw new RuntimeException("用于回滚事务");
        }
        userRepository.save(sysUser);
    }
}
