package com.jieduo.fang.dao;

import org.springframework.stereotype.Repository;

import com.jieduo.fang.dao.base.BaseDaoImpl;
import com.jieduo.fang.domain.Test;

/**
 * 
 * @author lyh
 *
 */
@Repository("testDao")
public class TestDaoImpl extends BaseDaoImpl<Test> implements TestDao {

	private final static String NAME_SPACE = "com.jieduo.fang.dao.TestDao.";
	
	@Override
	public String getNameSpace(String statement) {
		return NAME_SPACE + statement;
	}
}
