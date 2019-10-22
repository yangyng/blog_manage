package com.yangy.manage.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 测试日志切面
 *
 * @author yang yang
 * @email m17610912950@163.com
 * @time 2019年08月06日 17:05
 **/
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("execution(public * com.yangy.manage.controller.*.*(..))")
    public void logAspect() {
    }

    /**
     * 在 controller 执行之前 执行该代码
     * @param joinPoint
     */
    @Before("logAspect()")
    public void deBefore(JoinPoint joinPoint) {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        log.info("请求地址: " + request.getRequestURL());
        log.info("请求方法: " + request.getMethod());
        log.info("请求方法: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("请求参数: " + Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * 在页面渲染完成返回给客户端之前执行
     */
    @After("logAspect()")
    public void doAfter(JoinPoint jp) {
    }
}
