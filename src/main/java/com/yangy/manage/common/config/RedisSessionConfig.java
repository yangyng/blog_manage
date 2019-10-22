package com.yangy.manage.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * redis 集成 spring boot session 解决 session 共享问题
 * EnableRedisHttpSession maxInactiveIntervalInSeconds 设置缓存过期时间 默认值 1600 秒
 * @author yang yang
 * @email m17610912950@163.com
 * @time 2019年08月05日 18:05
 **/
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=60)
public class RedisSessionConfig {
}
