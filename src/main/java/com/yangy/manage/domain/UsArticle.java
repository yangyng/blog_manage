package com.yangy.manage.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "us_article")
public class UsArticle  implements Serializable {

	private static final long serialVersionUID = 1397125707807610669L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "article_id")
	private Integer articleId;

	private String title;

	private String name;

	@Column(name = "type_id")
	private Integer typeId;

	@Column(name = "user_id")
	private Integer userId;

	private String content;

	private Integer top;

	@Column(name = "last_edit_time")
	private Integer lastEditTime;

	@Column(name = "last_edit_ip")
	private String lastEditIp;

	@Column(name = "create_time")
	private Integer createTime;

	@Column(name = "article_ip")
	private String articleIp;

	@Column(name = "del_flag")
	private Integer delFlag;

}
