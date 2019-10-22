package com.yangy.manage.controller;

import com.yangy.manage.domain.SysUser;
import com.yangy.manage.service.TestService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;


/**
 * 测试使用的Controller
 *
 * @author yang yang
 * @email m17610912950@163.com
 * @time 2019年08月06日 10:13
 **/
@RequestMapping("test")
@Controller
@Slf4j
public class TestController {

    @Resource
    private TestService testService;

    @PostMapping("/test")
    @ResponseBody
    @ApiOperation("测试")
    @Cacheable(value = "test:age")
    public Object test(@RequestParam("age") Integer age,
                       HttpServletRequest request) throws Exception {

        log.info(String.valueOf(request.getAttribute("filt")));
        log.info(String.valueOf(request.getAttribute("inte")));
        log.info(String.valueOf(request.getAttribute("aop")));

        HashMap<Object, Object> map = new HashMap<>();

        map.put("username", "蜗牛");
        map.put("pwd", "111");
        return map;
    }

    @PostMapping("/test2")
    @ResponseBody
    @ApiOperation("测试2")
    @Cacheable(value = "test:age")
    public Object test2(@RequestParam("age") Integer age){
        testService.test();
        HashMap<Object, Object> map = new HashMap<>();

        map.put("username", "蜗牛");
        map.put("pwd", "112");
        return map;
    }

    @PostMapping("/test/no/tran")
    @ResponseBody
    @ApiOperation("测试事务")
    public Object testNoTran(@RequestBody SysUser sysUser){
        return testService.testNoTransactional(sysUser);
    }

    @PostMapping("/test/tran")
    @ResponseBody
    @ApiOperation("测试事务")
    public Object testTran(@RequestBody SysUser sysUser){
        return testService.testTransactional(sysUser);
    }

    @GetMapping("/test/get/all")
    @ResponseBody
    @ApiOperation("获取所有用户信息")
    public Object getAll(){
        return testService.getAll();
    }

    @GetMapping("/test/333")
    @ResponseBody
    @ApiOperation("获取所有用户信息")
    public Object test11(){
        testService.testTransactionalAround();
        return null;
    }
}
