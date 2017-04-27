/**
 * 
 */
package com.gl.h2o.pojos;

import java.util.List;

/**
 * @author rashmi.paliwal
 *
 */
public class UserMeasure {
	
	/** User ID. */
	int userId;
	
	/** List to all things measurement for the user. */
	List<ThingMeasure> thingMeasureList;

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the thingMeasureList
	 */
	public List<ThingMeasure> getThingMeasureList() {
		return thingMeasureList;
	}

	/**
	 * @param thingMeasureList the thingMeasureList to set
	 */
	public void setThingMeasureList(List<ThingMeasure> thingMeasureList) {
		this.thingMeasureList = thingMeasureList;
	}
}
