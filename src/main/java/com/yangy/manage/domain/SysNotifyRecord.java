package com.yangy.manage.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "sys_notify_record")
public class SysNotifyRecord  implements Serializable {

	private static final long serialVersionUID = -2123536775797990764L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "record_id")
	private Integer recordId;

	@Column(name = "user_id")
	private Integer userId;

	private String title;

	private String content;

	@Column(name = "send_all")
	private Integer sendAll;

	@Column(name = "send_time")
	private Integer sendTime;

}
