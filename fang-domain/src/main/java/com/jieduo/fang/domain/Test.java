package com.jieduo.fang.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.jieduo.fang.domain.base.BaseDomain;

/**
 * 测试domain
 * 
 * @author lyh
 *
 */
@JsonIgnoreProperties({ "yn", "modifiedTime", "createTime", "modifier",
		"creator", "pageSize", "pageIndex", "offset" })
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Test extends BaseDomain {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
