//package com.yangy.manage.common.security.handler;
//
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * 登录失败操作
// *
// * @author K. L. Mao
// * @create 2019/1/15
// */
//@Component
//public class AuthFailHandler implements AuthenticationFailureHandler {
//    @Override
//    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
//        response.setStatus(400);
//    }
//}
