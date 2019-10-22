package com.yangy.manage.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "sys_menu")
public class SysMenu  implements Serializable {

	private static final long serialVersionUID = 3177504492513166378L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String code;

	private String type;

	private String name;

	private String desp;

	@Column(name = "parent_menu")
	private String parentMenu;

	private String url;

	private String level;

	private Integer order;

	private Integer valid;

	private String icon;

}
