package com.impetus.casestudy.microservice.searchuser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.casestudy.microservice.searchuser.County;
import com.impetus.casestudy.microservice.searchuser.dao.SearchCountyDao;

/**
 * @author prachi.singh
 *
 */
@Service("countySearchService")
public class CountySearchServiceImpl implements CountySearchService{

	
	@Autowired
	private SearchCountyDao searchCountyDao;

	@Override
	public County findCountyById(String id) {
		return searchCountyDao.findCountyById(id);
	}

	@Override
	public County findCountyByZip(String zip) {
		return searchCountyDao.findCountyByZip(zip);
	}


	@Override
	public List<County> findAllCounties() {
		return searchCountyDao.findAllCounties();
	}
}
