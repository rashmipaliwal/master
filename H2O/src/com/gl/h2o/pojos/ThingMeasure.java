/**
 *
 */
package com.gl.h2o.pojos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author rashmi.paliwal
 *
 */
public class ThingMeasure implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** Thing id. */
	int thingId;

	/** List of water volumes measured by the thing. */
	private ArrayList<ThingsData> waterConsumptionList;

	/**
	 * @return the thingId
	 */
	public int getThingId() {
		return thingId;
	}

	/**
	 * @param thingId the thingId to set
	 */
	public void setThingId(int thingId) {
		this.thingId = thingId;
	}

	/**
	 * @return the waterConsumptionList
	 */
	public ArrayList<ThingsData> getWaterConsumptionList() {
		return waterConsumptionList;
	}

	/**
	 * @param waterConsumptionList the waterConsumptionList to set
	 */
	public void setWaterConsumptionList(ArrayList<ThingsData> waterConsumptionList) {
		this.waterConsumptionList = waterConsumptionList;
	}

}
