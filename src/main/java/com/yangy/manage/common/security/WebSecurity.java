//package com.yangy.manage.common.security;
//
//import com.yangy.manage.common.security.handler.AccessDeniesHandler;
//import com.yangy.manage.common.security.handler.AuthFailHandler;
//import com.yangy.manage.common.security.handler.AuthSuccessHandler;
//import com.yangy.manage.common.security.handler.EntryPointUnauthorizedHandler;
//import com.yangy.manage.common.security.jwt.JwtAuthenticationTokenFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsUtils;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
///**
// * Spring Security 配置类
// *
// * @author K. L. Mao
// * @EnableGlobalMethodSecurity 开启注解的权限控制，默认是关闭的。
// * prePostEnabled：使用表达式实现方法级别的控制，如：@PreAuthorize("hasRole('ADMIN')")
// * securedEnabled: 开启 @Secured 注解过滤权限，如：@Secured("ROLE_ADMIN")
// * jsr250Enabled: 开启 @RolesAllowed 注解过滤权限，如：@RolesAllowed("ROLE_ADMIN")
// * @create 2019/1/11
// */
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurity extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private UserDetailsService userDetailsService;
//    @Autowired
//    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
//    @Autowired
//    private EntryPointUnauthorizedHandler entryPointUnauthorizedHandler;
//    @Autowired
//    private AccessDeniesHandler accessDeniesHandler;
//    @Autowired
//    private AuthSuccessHandler authSuccessHandler;
//    @Autowired
//    private AuthFailHandler authFailHandler;
//
//    /**
//     * 从容器中取出 AuthenticationManagerBuilder，执行方法里面的逻辑之后，放回容器
//     *
//     * @param authenticationManagerBuilder
//     * @throws Exception
//     */
//    @Autowired
//    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
//
//    private PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        /**
//         * 在 UsernamePasswordAuthenticationFilter 之前添加 JwtAuthenticationTokenFilter
//         */
//        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
//
//        http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and().authorizeRequests()
//                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                // 角色校验时，会自动拼接 "ROLE_"
//                .antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
//                .antMatchers("/non-auth/**").permitAll()
//                .anyRequest().authenticated()   // 任何请求,登录后可以访问
//                .and().formLogin().loginProcessingUrl("/login")
//                .successHandler(authSuccessHandler)
//                .failureHandler(authFailHandler)
//                .and().headers().cacheControl();
//
//        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.authorizeRequests();
//        //让Spring security 放行所有preflight request（cors 预检请求）
//        registry.requestMatchers(CorsUtils::isPreFlightRequest).permitAll();
//        // 处理异常情况：认证失败和权限不足
//        http.exceptionHandling().authenticationEntryPoint(entryPointUnauthorizedHandler).accessDeniedHandler(accessDeniesHandler);
//    }
//
//    /**
//     * 跨域配置
//     *
//     * @param
//     * @return org.springframework.web.filter.CorsFilter
//     * @date 2019-09-10
//     * @author yang yang
//     **/
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration cors = new CorsConfiguration();
//        cors.setAllowCredentials(true);
//        cors.addAllowedOrigin("*");
//        cors.addAllowedHeader("*");
//        cors.addAllowedMethod("*");
//        configurationSource.registerCorsConfiguration("/**", cors);
//        return new CorsFilter(configurationSource);
//    }
//}
