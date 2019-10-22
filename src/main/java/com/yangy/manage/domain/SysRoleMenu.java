package com.yangy.manage.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "sys_role_menu")
public class SysRoleMenu  implements Serializable {

	private static final long serialVersionUID = 3849309599656803413L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Integer roleId;

	@Column(name = "menu_code")
	private String menuCode;

}
