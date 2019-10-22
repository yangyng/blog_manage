package com.yangy.manage.service.impl;

import com.yangy.manage.dao.SysUserRepository;
import com.yangy.manage.domain.SysUser;
import com.yangy.manage.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author yang yang
 * @email m17610912950@163.com
 * @time 2019年08月06日 17:16
 **/
@Service
@Slf4j
public class TestServiceImpl implements TestService {

    @Resource
    private SysUserRepository userRepository;

    @Override
    public void test() {
        log.info("我执行了");
        System.out.println("我执行了");
    }

    @Override
    @Transactional
    public Object testTransactional(SysUser sysUser) {
        SysUser save = null;
        try {
            userRepository.deleteAll();
            SysUser user = Optional.ofNullable(sysUser).orElseThrow(() -> new RuntimeException("参数错误"));
            if (user.getNickName().contains("yang")) {
                throw new RuntimeException("为了回滚事务");
            }
            save = userRepository.save(sysUser);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            //手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return save;
    }

    @Override
    public Object testNoTransactional(SysUser sysUser) {
        Object list = testTransactional(sysUser);
        return list;
    }

    @Override
    public Object getAll() {
        List<SysUser> all = userRepository.findAll();
        return all;
    }

    @Override
    @Transactional
    public void testTransactionalAround() {
        List<SysUser> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SysUser user = SysUser.builder()
                    .nickName("won" + i)
                    .createTime(new Date())
                    .build();

            list.add(user);
        }
        SysUser user = SysUser.builder()
                .nickName("wonaaaaa")
                .createTime(new Date())
                .build();
        userRepository.save(user);
        for (SysUser sysUser : list) {
            try {
                save(sysUser);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public List<SysUser> save(SysUser sysUser) {
        if (sysUser.getNickName().equals("won6")) {
            throw new RuntimeException("我是为了抛出异常信息的");
        } else {
            userRepository.save(sysUser);
        }
        return null;
    }
}
