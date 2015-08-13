package com.jieduo.fang.dao.base;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author lyh
 *
 * @param <T>
 */
public interface BaseDao<T> {

	/**
	 * 获取命名空间
	 */
	String getNameSpace(String statement);

	/**
	 * 添加对象
	 *
	 * @param t
	 * @return
	 */
	Long insert(T t);

	/**
	 * 更新对象,条件主键
	 * 
	 * @param t
	 * @return
	 */
	int update(T t);

	/**
	 * 删除对象,主键
	 * 
	 * @param key
	 * @return
	 */
	int delete(Serializable key);

	/**
	 * 删除对象
	 * 
	 * @param t
	 * @return
	 */
	int delete(T t);

	/**
	 * 查询对象,条件主键
	 * 
	 * @param t
	 * @return
	 */
	T select(Serializable key);

	/**
	 * 查询对象
	 *
	 * @param t
	 * @return
	 */
	List<T> select(T t);

	/**
	 * 条件查询对象总数
	 *
	 * @param t
	 * @return
	 */
	int selectCount(T t);

	/**
	 * 查询对象列表
	 * 
	 * @param t
	 * @return
	 */
	List<T> selectPage(T t);

	/**
	 * 批量插入
	 *
	 * @param list
	 */
	void batchInsert(final List<T> list);

	/**
	 * 批量删除
	 *
	 * @param list
	 */
	public void batchDelete(final List<T> list);

	/**
	 * 批量更新
	 * 
	 * @param rules
	 */
	void batchUpdate(final List<T> list);
}
