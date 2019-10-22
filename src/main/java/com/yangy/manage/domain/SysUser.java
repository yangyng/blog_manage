package com.yangy.manage.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;

@Data
@Builder
@Entity
@Table(name = "sys_user")
public class SysUser  implements Serializable {

	private static final long serialVersionUID = 6433375700854121952L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "login_name")
	private String loginName;

	@Column(name = "nick_name")
	private String nickName;

	@Column(name = "real_name")
	private String realName;

	private String password;

	private String salt;

	private Integer gender;

	private String email;

	private Integer phone;

	@Column(name = "wx_open_id")
	private String wxOpenId;

	@Column(name = "wx_union_id")
	private String wxUnionId;

	@Column(name = "wx_session_key")
	private String wxSessionKey;

	@Column(name = "create_time")
	private java.util.Date createTime;

	@Column(name = "lock_flag")
	private Integer lockFlag;

	@Column(name = "icon_url")
	private String iconUrl;

	private LinkedList<SysRole> roleList;
	private LinkedList<SysMenu> menuList;
}
