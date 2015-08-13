package com.jieduo.fang.dao.base;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.ibatis.sqlmap.client.SqlMapExecutor;

/**
 * 
 * @author lyh
 *
 * @param <T>
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public abstract class BaseDaoImpl<T> extends SqlMapClientTemplate implements
		BaseDao<T> {

	protected static final String INSERT_ENTRY = "insertEntry";
	protected static final String UPDATE_ENTRY_BY_KEY = "updateEntryByKey";
	protected static final String BATCH_UPDATE_ENTRY_BY_KEY = "batchUpdateEntryByKey";
	protected static final String DELETE_ENTRY_BY_KEY = "deleteEntryByKey";
	protected static final String DELETE_ENTRY_BY_WHERE = "deleteEntryByWhere";
	protected static final String SELECT_ENTRY_BY_KEY = "selectEntryByKey";
	protected static final String SELECT_ENTRY_BY_WHERE = "selectEntryByWhere";
	protected static final String SELECT_ENTRY_BY_WHERE_COUNT = "selectEntryByWhereCount";
	protected static final String SELECT_ENTRY_BY_WHERE_PAGE = "selectEntryByWherePage";

	public abstract String getNameSpace(String statement);

	public Long insert(T t) {
		return (Long) this.insert(getNameSpace(INSERT_ENTRY), t);
	}

	public int update(T t) {
		return this.update(getNameSpace(UPDATE_ENTRY_BY_KEY), t);
	}

	public int delete(Serializable key) {
		return this.delete(getNameSpace(DELETE_ENTRY_BY_KEY), key);
	}

	public int delete(T t) {
		return this.delete(getNameSpace(DELETE_ENTRY_BY_WHERE), t);
	}

	public T select(Serializable key) {
		return (T) queryForObject(getNameSpace(SELECT_ENTRY_BY_KEY), key);
	}

	public List<T> select(T t) {
		return this.queryForList(getNameSpace(SELECT_ENTRY_BY_WHERE), t);
	}

	public int selectCount(T t) {
		return (Integer) queryForObject(
				getNameSpace(SELECT_ENTRY_BY_WHERE_COUNT), t);
	}

	public List<T> selectPage(T t) {
		return queryForList(getNameSpace(SELECT_ENTRY_BY_WHERE_PAGE), t);
	}
	
	@Override
	public void batchInsert(final List<T> list) {
		this.execute(new SqlMapClientCallback() {
			@Override
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				executor.startBatch();
				for (T t : list) {
					executor.insert(getNameSpace(INSERT_ENTRY), t);
				}
				executor.executeBatch();
				return null;
			}
		});
	}
	
	@Override
	public void batchDelete(final List<T> list) {
		this.execute(new SqlMapClientCallback() {
			@Override
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				executor.startBatch();
				for (T t : list) {
					executor.delete(getNameSpace(DELETE_ENTRY_BY_KEY), t);
				}
				executor.executeBatch();
				return null;
			}
		});
	}
	
	@Override
	public void batchUpdate(final List<T> list) {
		this.execute(new SqlMapClientCallback() {
			@Override
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				executor.startBatch();
				for (T t : list) {
					executor.update(getNameSpace(UPDATE_ENTRY_BY_KEY), t);
				}
				executor.executeBatch();
				return null;
			}
		});
	}
}
