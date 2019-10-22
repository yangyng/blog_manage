//package com.yangy.manage.common.config;
//
//import org.apache.shiro.authc.credential.AllowAllCredentialsMatcher;
//import org.apache.shiro.mgt.RememberMeManager;
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.session.mgt.SessionManager;
//import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//
//import java.util.LinkedHashMap;
//
///**
// * <p>
// * shiro权限管理配置文件
// * </P>
// *
// * @author yang yang
// * @create 2018/11/5
// */
//@Configuration
//public class ShiroConfig {
//
//    /**
//     * 配置过滤器
//     * @param securityManager
//     * @return
//     */
//    @Bean
//    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
//        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
//        filterFactoryBean.setSecurityManager(securityManager);
//        LinkedHashMap<String, String> filterChainMap = new LinkedHashMap<>();
//        filterChainMap.put("/**", "anon");
//
//        filterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
//        //
//        filterFactoryBean.setLoginUrl("/unauth");
//        return filterFactoryBean;
//    }
//
//    /**
//     * 配置 securityManager
//     * @return
//     */
//    @Bean
//    public SecurityManager securityManager() {
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setRealm(getRealm());
//        securityManager.setSessionManager(securityManager);
//        securityManager.setCacheManager(null);
//        securityManager.setRememberMeManager(rememberMeManager());
//        return securityManager;
//    }
//
//    /**
//     * 自定义sessionManager
//     * @return
//     */
//    @Bean
//    public SessionManager sessionManager(){
//        return null;
//    }
//
//    @Bean
//    public RememberMeManager rememberMeManager(){
//        return null;
//    }
//
//
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authAttrSourceAdvisor() {
//        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
//        advisor.setSecurityManager(securityManager());
//        return advisor;
//    }
//
//    @Bean
//    public AllowAllCredentialsMatcher matcher() {
//        AllowAllCredentialsMatcher matcher = new AllowAllCredentialsMatcher();
////        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
////        matcher.setHashAlgorithmName("md5");
////        matcher.setHashIterations(1);
//        return matcher;
//    }
//
//    @Bean
//    public ShiroRealm getRealm() {
//        ShiroRealm realm = new ShiroRealm();
//        realm.setCredentialsMatcher(matcher());
//        return realm;
//    }
//
//    /**
//     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证 * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)和AuthorizationAttributeSourceAdvisor)即可实现此功能 * @return
//     */
//    @Bean
//    @DependsOn({"lifecycleBeanPostProcessor"})
//    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
//        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
//        advisorAutoProxyCreator.setProxyTargetClass(true);
//        return advisorAutoProxyCreator;
//    }
//
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
//        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
//        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
//        return authorizationAttributeSourceAdvisor;
//    }
//
//}
