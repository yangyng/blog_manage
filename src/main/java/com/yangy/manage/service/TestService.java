package com.yangy.manage.service;

import com.yangy.manage.domain.SysUser;

public interface TestService {
    void test();
    Object testTransactional(SysUser sysUser);
    Object testNoTransactional(SysUser sysUser);
    public void testTransactionalAround();
    Object getAll();
}
