package com.yangy.manage.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 秒杀控制器实现
 *
 * @author yang yang
 * @email m17610912950@163.com
 * @time 2019年09月06日 15:18
 **/
@RestController
@RequestMapping("sec/kill")
public class SecKillController extends BaseController {

    @Resource
    private RedisTemplate redisTemplate;


    public void secKill(){
        String userId = getUserId();
    }



}
