package com.yangy.manage.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 当前登录用户信息对象
 *
 * @author yang yang
 * @email m17610912950@163.com
 * @time 2019年10月22日 17:48
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class LoginUserVO {
    /**
     * 当前登录用户名
     **/
    private String loginName;
    /**
     * 当前登录用户昵称
     */
    private String nickName;
    /**
     * 用户性别
     */
    private String sex;
    /**
     * 当前用户的状态 是否激活 是否锁定
     */
    private String userStatus;
    /**
     * 用户访问系统的唯一标识符
     */
    private String token;
}
