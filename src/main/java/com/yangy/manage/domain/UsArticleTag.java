package com.yangy.manage.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "us_article_tag")
public class UsArticleTag  implements Serializable {

	private static final long serialVersionUID = 3667168120036327471L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tag_id")
	private Integer tagId;

	@Column(name = "tag_name")
	private String tagName;

	@Column(name = "del_flag")
	private Integer delFlag;

	@Column(name = "create_time")
	private Integer createTime;

	@Column(name = "update_time")
	private Integer updateTime;

}
