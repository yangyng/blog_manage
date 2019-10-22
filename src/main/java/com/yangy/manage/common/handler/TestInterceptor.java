package com.yangy.manage.common.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 测试拦截器
 *
 * @author yang yang
 * @email m17610912950@163.com
 * @time 2019年08月07日 15:00
 **/
@Component
@Slf4j
public class TestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> stringEntry : parameterMap.entrySet()) {
            log.info("key: " +stringEntry.getKey()+" value: "+stringEntry.getValue());
        }

        String nonce = request.getHeader("nonce");
        String sign = request.getHeader("sign");
        String timestamp = request.getHeader("timestamp");

        request.setAttribute("inte","bbbb");
        log.info("interceptor preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("interceptor postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("interceptor afterCompletion");
    }
}
