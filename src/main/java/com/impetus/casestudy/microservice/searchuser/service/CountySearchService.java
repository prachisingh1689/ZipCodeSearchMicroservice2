package com.impetus.casestudy.microservice.searchuser.service;

import java.util.List;

import com.impetus.casestudy.microservice.searchuser.County;

/**
 * @author prachi.singh
 *
 */
public interface CountySearchService {

	public abstract County findCountyById(String id);

	public abstract County findCountyByZip(String zip);

	public abstract List<County> findAllCounties();

}
