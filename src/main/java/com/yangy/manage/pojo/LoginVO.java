package com.yangy.manage.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 登录VO对象
 *
 * @author yang yang
 * @email m17610912950@163.com
 * @time 2019年08月13日 17:03
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class LoginVO {

    /**
     * 登录名
     */
    private String loginName;
    /**
     * 登录密码
     */
    private String pwd;
    /**
     * 登录IP地址
     */
    private String ip;
    /**
     * 验证码
     */
    private String verifyCode;
}
