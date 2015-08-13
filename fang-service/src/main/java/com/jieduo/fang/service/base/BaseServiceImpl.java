package com.jieduo.fang.service.base;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jieduo.fang.dao.base.BaseDao;

/**
 * 
 * @author lyh
 *
 * @param <T>
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(BaseServiceImpl.class);

	/**
	 * 获取DAO操作类
	 */
	public abstract BaseDao<T> getDao();

	/**
	 * 添加对象
	 * 
	 * @param t
	 * @return
	 */
	public Long insert(T t) {
		if (t == null) {
			return null;
		}

		try {
			return getDao().insert(t);
		} catch (Exception e) {
			LOGGER.error("BaseServiceImpl insert error", e);
		}

		return null;
	}

	/**
	 * 删除对象,主键
	 * 
	 * @param key
	 * @return
	 */
	public int delete(Serializable key) {
		if (key == null) {
			return 0;
		}

		try {
			return getDao().delete(key);
		} catch (Exception e) {
			LOGGER.error("BaseServiceImpl delete error", e);
		}

		return 0;
	}

	/**
	 * 更新对象,条件主键
	 * 
	 * @param t
	 * @return
	 */
	public int update(T t) {
		if (t == null) {
			return 0;
		}

		try {
			return getDao().update(t);
		} catch (Exception e) {
			LOGGER.error("BaseServiceImpl update error", e);
		}

		return 0;
	}

	/**
	 * 查询对象,条件主键
	 * 
	 * @param t
	 * @return
	 */
	public T select(Serializable key) {
		if (key == null) {
			return null;
		}

		try {
			return getDao().select(key);
		} catch (Exception e) {
			LOGGER.error("BaseServiceImpl select error", e);
		}

		return null;
	}

	/**
	 * 查询对象,只要不为NULL与空则为条件
	 * 
	 * @param t
	 * @return
	 */
	public List<T> select(T t) {
		if (t == null) {
			return Collections.emptyList();
		}

		try {
			return getDao().select(t);
		} catch (Exception e) {
			LOGGER.error("BaseServiceImpl select list error", e);
		}

		return Collections.emptyList();
	}

	/**
	 * 查询对象总数
	 * 
	 * @param t
	 * @return
	 */
	public int selectCount(T t) {
		if (t == null) {
			return 0;
		}

		try {
			return getDao().selectCount(t);
		} catch (Exception e) {
			LOGGER.error("BaseServiceImpl selectCount error", e);
		}

		return 0;
	}

	/**
	 * 获取分页数据
	 * 
	 * @param t
	 * @param page
	 * @return
	 */
	public List<T> selectPage(T t) {
		if (t == null) {
			return Collections.emptyList();
		}

		try {
			return getDao().selectPage(t);
		} catch (Exception e) {
			LOGGER.error("BaseServiceImpl selectPage error", e);
		}

		return Collections.emptyList();
	}
	
	/**
     * 批量插入
     *
     * @param list
     */
    public void batchInsert(List<T> list) {
    	if (CollectionUtils.isEmpty(list)) {
			return;
		}

		getDao().batchInsert(list);
    }
    
    /**
     * 批量删除
     *
     * @param list
     */
    public void batchDelete(List<T> list) {
    	if (CollectionUtils.isEmpty(list)) {
			return;
		}

    	try {
    		getDao().batchDelete(list);
		} catch (Exception e) {
			LOGGER.error("BaseServiceImpl batchDelete error", e);
		}
    }
    
    /**
	 * 批量更新
	 * 
	 * @param list
	 */
    public void batchUpdate(List<T> list) {
    	if (CollectionUtils.isEmpty(list)) {
			return;
		}
    	
    	try {
    		getDao().batchUpdate(list);
		} catch (Exception e) {
			LOGGER.error("BaseServiceImpl batchUpdate error", e);
		}
    }
}
