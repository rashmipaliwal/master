/**
 *
 */
package com.gl.h2o.dao;

import java.math.BigDecimal;
import java.util.List;

import com.gl.h2o.pojos.ThingMeasure;

/**
 * @author rashmi.paliwal
 *
 */
public interface H2ODao {

	String WATER_CONSUMPTION_INSERT = "waterConsumptionInsertSql";

	String FETCH_CONSUMPTION_DATA_FOR_CURRENT_WEEK = "getConsumptionDataForCurrentWeek";
	String FETCH_CONSUMPTION_DATA_FOR_PREVIOUS_WEEK = "getConsumptionDataForPreviousWeek";
	String FETCH_CONSUMPTION_DATA_FOR_CURRENT_MONTH = "getConsumptionDataForCurrentMonth";
	String FETCH_CONSUMPTION_DATA_FOR_PREVIOUS_MONTH = "getConsumptionDataForPreviousMonth";
	/**
	 * Persists the volume of water consumed at a certain timestamp in database.
	 * @param deviceId deviceId
	 * @param volume consumed water volume
	 * @param interval time interval
	 */
	void recordConsumption(Integer deviceId, BigDecimal volume);

	/**
	 * Fetch current week data.
	 * @param userId user id.
	 * @return list of water consumption for each day of week.
	 */
	ThingMeasure getCurrentWeekData(String userId);

	/**
	 * Fetch previous week data.
	 * @param userId user id.
	 * @return list of water consumption.
	 */
	ThingMeasure getPreviousWeekData(String userId);

	/**
     * Fetch current month data.
     * @param userId user id.
     * @return list of water consumption.
     */
	ThingMeasure getCurrentMonthData(String userId);

	/**
     * Fetch previous month data.
     * @param userId user id.
     * @return list of water consumption.
     */
	ThingMeasure getPreviousMonthData(String userId);
}
