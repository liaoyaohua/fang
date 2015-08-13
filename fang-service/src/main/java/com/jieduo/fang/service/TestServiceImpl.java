package com.jieduo.fang.service;

import javax.annotation.Resource;

import com.jieduo.fang.dao.TestDao;
import com.jieduo.fang.dao.base.BaseDao;
import com.jieduo.fang.domain.Test;
import com.jieduo.fang.service.base.BaseServiceImpl;

/**
 * 
 * @author lyh
 *
 */
public class TestServiceImpl extends BaseServiceImpl<Test> implements TestService {
	@Resource
	private TestDao testDao;
	
    @Override
	public BaseDao<Test> getDao() {
		return testDao;
	}

}
