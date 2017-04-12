package com.impetus.casestudy.microservice.searchuser;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CountyNotFoundException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public CountyNotFoundException(String zipcode) {
			super("No such county : " + zipcode);
		}
	}
