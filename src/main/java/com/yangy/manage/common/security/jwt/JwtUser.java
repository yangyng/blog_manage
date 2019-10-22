//package com.yangy.manage.common.security.jwt;
//
//import lombok.AllArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
///**
// * jwt 相关的用户信息
// *
// * @author yang yang
// * @email m17610912950@163.com
// * @time 2019年09月10日 15:07
// **/
//@AllArgsConstructor
//public class JwtUser implements UserDetails {
//    private String loginName;
//    private String password;
//    private Integer lockFlag;
//    private Collection<? extends GrantedAuthority> authorities;
//
//    /**
//     * Returns the authorities granted to the user. Cannot return <code>null</code>.
//     *
//     * @return the authorities, sorted by natural key (never <code>null</code>)
//     */
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    /**
//     * Returns the password used to authenticate the user.
//     *
//     * @return the password
//     */
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    /**
//     * Returns the username used to authenticate the user. Cannot return <code>null</code>.
//     *
//     * @return the username (never <code>null</code>)
//     */
//    @Override
//    public String getUsername() {
//        return loginName;
//    }
//
//    /**
//     * Indicates whether the user's account has expired. An expired account cannot be
//     * authenticated.
//     *
//     * @return <code>true</code> if the user's account is valid (ie non-expired),
//     * <code>false</code> if no longer valid (ie expired)
//     */
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    /**
//     * Indicates whether the user is locked or unlocked. A locked user cannot be
//     * authenticated.
//     *
//     * @return <code>true</code> if the user is not locked, <code>false</code> otherwise
//     */
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    /**
//     * Indicates whether the user's credentials (password) has expired. Expired
//     * credentials prevent authentication.
//     *
//     * @return <code>true</code> if the user's credentials are valid (ie non-expired),
//     * <code>false</code> if no longer valid (ie expired)
//     */
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    /**
//     * Indicates whether the user is enabled or disabled. A disabled user cannot be
//     * authenticated.
//     *
//     * @return <code>true</code> if the user is enabled, <code>false</code> otherwise
//     */
//    @Override
//    public boolean isEnabled() {
//        return lockFlag == 1;
//    }
//}
