package com.yangy.manage.common.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Map;

/**
 * 测试过滤器
 *
 * @author yang yang
 * @email m17610912950@163.com
 * @time 2019年08月06日 16:35
 **/
@Component
@Order(10)
@Slf4j
@WebFilter(urlPatterns = "/**",filterName = "myfilter")
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      log.info("myFilter 创建了");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Map<String, String[]> parameterMap = servletRequest.getParameterMap();
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            stringBuffer.append(" key: "+entry.getKey()+" value: "+entry.getValue());
        }

        servletRequest.setAttribute("filt","aaaa");

        log.info("myFilter 正在执行: "+ stringBuffer.toString());
        filterChain.doFilter(servletRequest, servletResponse);

        log.info("myFilter 执行完了");
        return;
    }

    @Override
    public void destroy() {
        log.info("myFilter 销毁了");
    }
}
