package com.impetus.casestudy.microservice.searchuser.dao;

import java.util.List;

import com.impetus.casestudy.microservice.searchuser.County;

	public interface SearchCountyDao {

		public abstract County findCountyById(String id);

		public abstract County findCountyByZip(String zip);

		public abstract List<County> findAllCounties();
		
	}
