package com.jieduo.fang.domain.base;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author lyh
 *
 */
public class BaseDomain implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 创建者
	 */
	private String creator;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改者
	 */
	private String modifier;
	/**
	 * 修改时间
	 */
	private Date modifiedTime;

	private Integer yn;
	private int pageSize = 20;
	private int pageIndex = 1;
	private int offset = 0;

	public Date getModifiedTime() {
		if (modifiedTime == null) {
			return null;
		}
		return (Date) modifiedTime.clone();
	}

	public void setModifiedTime(Date modifiedTime) {
		if (modifiedTime == null) {
			this.modifiedTime = null;
		} else {
			this.modifiedTime = (Date) modifiedTime.clone();
		}
	}

	public Date getCreateTime() {
		if (createTime == null) {
			return null;
		}
		return (Date) createTime.clone();
	}

	public void setCreateTime(Date createTime) {
		if (createTime == null) {
			this.createTime = null;
		} else {
			this.createTime = (Date) createTime.clone();
		}
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Integer getYn() {
		return yn;
	}

	public void setYn(Integer yn) {
		this.yn = yn;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getOffset() {
		setOffset(getPageSize() * (getPageIndex() - 1) + offset);
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

}