package com.impetus.casestudy.microservice.searchuser;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.casestudy.microservice.searchuser.service.CountySearchService;

	@RestController
	// @Path("/user")
	public class SearchCountyRestController {
		@Autowired
		CountySearchService countySearchService;
		protected Logger logger = Logger.getLogger(SearchCountyRestController.class
				.getName());

		@GetMapping(value = "/county/id/{id}")
		public County findUserById(@PathVariable("id") String id) {
			logger.info("SearchCountyRestController findUserById() invoked: " + id);
			return countySearchService.findCountyById(id);
		}

		@GetMapping(value = "/county/zip/{zip}")
		public County findCountyByZip(@PathVariable("zip") String zip) {
			logger.info("SearchCountyRestController findCountyByZip() invoked: "
					+ zip);
			return countySearchService.findCountyByZip(zip);
		}

		@GetMapping(produces = "application/json")
		public List<County> findAllCounties() {
			logger.info("SearchCountyRestController findAllCounties() invoked..");
			return countySearchService.findAllCounties();
		}
	}