package com.impetus.casestudy.microservice.searchuser.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.impetus.casestudy.microservice.searchuser.County;
import com.impetus.casestudy.microservice.searchuser.CountySearchConstants;

@Repository("searchCountyDAO")
@PropertySource("classpath:sql.properties")
public class SearchCountyDaoImpl implements SearchCountyDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
/*	@Autowired
	HazelcastInstance hazelcastInstance;*/

	@Value("${searchbyid}")
	private String FINDCOUNTYBYID_QUERY;

	@Value("${searchbyzip}")
	private String FINDCOUNTYBYZIP_QUERY;

	@Value("${searchall}")
	private String FINDALLCOUNTIES_QUERY;

	protected Logger logger = Logger.getLogger(SearchCountyDaoImpl.class
			.getName());

	@Override
	public County findCountyById(String id) {
		logger.info("CountyDAO findCountyById() invoked: " + id);
		return findCounty(FINDCOUNTYBYID_QUERY, id);
	}


	@Override
	public County findCountyByZip(String zip) {
		logger.info("CountyDAO findCountyByZip() invoked: " + zip);
		County county = null;
		IMap<String, County> map = null; 
				//hazelcastInstance.getMap(zip);
		if (map.containsKey(zip)) {
			logger.info("CountyDAO findCountyByZip() getting county from cache: "
					+ zip);
			county = map.get(zip);
		} else {
			if (findCounty(FINDCOUNTYBYZIP_QUERY, zip) != null) {
				county = findCounty(FINDCOUNTYBYZIP_QUERY, zip);
				map.put(zip, county);
			}
		}
		return county;
	}


	@Override
	public List<County> findAllCounties() {
		return findCounties(FINDALLCOUNTIES_QUERY, null);
	}

	public List<County> findCounties(String query, String param) {
		List countyList = null;
		List<Map<String, Object>> countyMap = null;
		if (param != null) {
			countyMap = jdbcTemplate.queryForList(query, new Object[]{param});
		} else {
			countyMap = jdbcTemplate.queryForList(query);
		}
		if (countyMap != null && !countyMap.isEmpty()) {
			countyList = getCountyList(countyMap);
		}
		return countyList;
	}

	private County findCounty(String query, String queryParam) {
		logger.info("CountyDAO findCounty() getting county from database: "
				+ queryParam);
		return (County) jdbcTemplate.queryForObject(query,
				new Object[]{queryParam}, new CountyRowMapper());
	}
	private List<County> getCountyList(List<Map<String, Object>> countyMap) {
		List<County> countyList = new ArrayList<>();
		for (Map row : countyMap) {
			County county = new County();
			county.setId((Long) (row.get(CountySearchConstants.COUNTY_ID)));
			county.setZipCode((String) row.get(CountySearchConstants.ZIPCODE));
			county.setCountyName((String) row.get(CountySearchConstants.COUNTY_NAME));
			countyList.add(county);
		}
		return countyList;
	}
}
