package com.jieduo.fang.service.base;

import java.io.Serializable;
import java.util.List;

import com.jieduo.fang.dao.base.BaseDao;

/**
 * 
 * @author lyh
 *
 * @param <T>
 */
public interface BaseService<T> {
	
    /**
     * 获取DAO操作类
     */
    BaseDao<T> getDao();

    /**
     * 添加对象
     * @param t
     * @return
     */
    Long insert(T t);

    /**
     * 删除对象,主键
     * 
     * @param key
     * @return
     */
    int delete(Serializable key);

    /**
     * 更新对象,条件主键
     * 
     * @param t
     * @return
     */
    int update(T t);
    
    /**
     * 查询对象,条件主键
     * @param t
     * @return
     */
    T select(Serializable key);

    /**
     * 查询对象,只要不为NULL与空则为条件
     * @param t
     * @return
     */
    List<T> select(T t);

    /**
     * 查询对象总数
     * @param t
     * @return
     */
    int selectCount(T t);

    /**
     * 获取分页数据
     * @param t
     * @param page
     * @return
     */
    public List<T> selectPage(T t);
    
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
    void batchDelete(List<T> list);
    
    /**
	 * 批量更新
	 * 
	 * @param list
	 */
	void batchUpdate(final List<T> list);
}
