/**
 * 
 */
package com.gl.h2o.pojos;

import java.util.List;

/**
 * @author rashmi.paliwal
 *
 */
public class DemographicsMeasure {
	
	/** Location. */
	String location;
	
	/** Water consumption list for all the users residing in the given locality. */
	List<UserMeasure> userMeasureList;

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the userMeasureList
	 */
	public List<UserMeasure> getUserMeasureList() {
		return userMeasureList;
	}

	/**
	 * @param userMeasureList the userMeasureList to set
	 */
	public void setUserMeasureList(List<UserMeasure> userMeasureList) {
		this.userMeasureList = userMeasureList;
	}
}
