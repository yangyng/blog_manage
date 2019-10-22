package com.yangy.manage.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "sys_role_user")
public class SysRoleUser  implements Serializable {

	private static final long serialVersionUID = 1210724195492839364L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Integer roleId;

	@Column(name = "user_id")
	private Integer userId;

}
