package com.impetus.casestudy.microservice.searchuser;

import java.io.Serializable;

import javax.persistence.GeneratedValue;

import org.springframework.data.annotation.Id;

/**
 * @author prachi.singh
 *
 */
public class County implements Serializable{

	@Id
	@GeneratedValue
	Long id;

	private String zipCode;

	private String countyName;

/*	 @Override
	 public int hashCode()
	 {
	 final int prime = 31;
	 int result = 1;
	 result = prime * result + (int) (id ^ (id >>> 32));
	 return result;
	 }
*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		County other = (County) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder countyObj = new StringBuilder();
		countyObj.append("County [");
		if (id != null)
			countyObj.append("id=" + id);
		countyObj.append(" zipCode=" + zipCode);
		countyObj.append(" countyName=" + countyName);
		countyObj.append("]");
		return countyObj.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

}
