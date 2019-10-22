package com.yangy.manage.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "us_user")
public class UsUser  implements Serializable {

	private static final long serialVersionUID = -7071516085197127348L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "user_name")
	private String userName;

	private String phone;

	private Integer gender;

	private String icon;

	@Column(name = "qq_num")
	private String qqNum;

	@Column(name = "open_id")
	private String openId;

	@Column(name = "union_id")
	private String unionId;

	private String email;

	private Integer birth;

	private String desp;

	private String address;

	private Integer locked;

	private Integer freezed;

	@Column(name = "register_ip")
	private String registerIp;

	@Column(name = "last_login_ip")
	private String lastLoginIp;

	@Column(name = "register_time")
	private Integer registerTime;

	@Column(name = "last_update_time")
	private Integer lastUpdateTime;

}
