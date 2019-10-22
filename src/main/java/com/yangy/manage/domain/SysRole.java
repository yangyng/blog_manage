package com.yangy.manage.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "sys_role")
public class SysRole  implements Serializable {

	private static final long serialVersionUID = 7893413170551676337L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String desp;

	private Integer valid;

}
