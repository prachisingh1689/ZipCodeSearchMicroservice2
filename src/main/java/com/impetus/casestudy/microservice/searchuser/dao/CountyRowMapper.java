package com.impetus.casestudy.microservice.searchuser.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.impetus.casestudy.microservice.searchuser.County;
import com.impetus.casestudy.microservice.searchuser.CountySearchConstants;

public class CountyRowMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		County county = new County();
		county.setId(rs.getLong(CountySearchConstants.COUNTY_ID));
		county.setZipCode(rs.getString(CountySearchConstants.ZIPCODE));
		county.setCountyName(rs.getString(CountySearchConstants.COUNTY_NAME));
		return county;
	}

}

