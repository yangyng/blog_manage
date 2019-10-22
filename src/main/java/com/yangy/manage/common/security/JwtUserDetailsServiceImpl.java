//package com.yangy.manage.common.security;
//
//import com.yangy.manage.common.security.jwt.JwtUser;
//import com.yangy.manage.domain.SysRole;
//import com.yangy.manage.domain.SysUser;
//import com.yangy.manage.service.ISysUserService;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.List;
//import java.util.stream.Collectors;
//
//
//@Service
//public class JwtUserDetailsServiceImpl implements UserDetailsService {
//    @Resource
//    private ISysUserService userService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        // 此处用户名可为 手机号|登录名|邮箱账号
//        SysUser user = userService.findByAccountName(username);
//        if (null == user) {
//            throw new UsernameNotFoundException(String.format("%s.这个用户不存在", username));
//        }
//        List<SimpleGrantedAuthority> authorities = user.getRoleList().stream()
//                .map(SysRole::getName)
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//        return new JwtUser(user.getLoginName(), user.getPassword(), user.getLockFlag(), authorities);
//    }
//}
