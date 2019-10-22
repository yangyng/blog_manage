package com.yangy.manage.dao;

import com.yangy.manage.domain.SysMenu;
import com.yangy.manage.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yang yang
 */
public interface SysUserRepository extends JpaRepository<SysUser,Long> {
}
