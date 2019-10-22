//package com.yangy.manage.common.security.handler;
//
//import com.alibaba.fastjson.JSONObject;
//import com.yangy.manage.common.model.Result;
//import com.yangy.manage.common.security.jwt.JwtTokenUtils;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * 登录成功操作
// * @author K. L. Mao
// * @create 2019/1/15
// */
//@Component
//@Slf4j
//public class AuthSuccessHandler implements AuthenticationSuccessHandler {
//
//    @Autowired
//    private JwtTokenUtils jwtTokenUtil;
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String token = jwtTokenUtil.generateToken(userDetails);
//        renderToken(httpServletResponse, token);
//    }
//
//    /**
//     * 渲染返回 token 页面,因为前端页面接收的都是Result对象，故使用application/json返回
//     *
//     * @param response
//     * @throws IOException
//     */
//    public void renderToken(HttpServletResponse response, String token) throws IOException {
//        response.setContentType("application/json;charset=UTF-8");
//        ServletOutputStream out = response.getOutputStream();
//        String str = JSONObject.toJSONString(new Result().ok(token));
//        out.write(str.getBytes("UTF-8"));
//        out.flush();
//        out.close();
//    }
//}
