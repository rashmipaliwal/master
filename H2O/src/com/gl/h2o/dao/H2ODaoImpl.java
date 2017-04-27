/**
 *
 */
package com.gl.h2o.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.TimeZone;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.gl.h2o.pojos.ThingMeasure;
import com.gl.h2o.pojos.ThingsData;

/**
 * @author rashmi.paliwal
 *
 */
public class H2ODaoImpl implements H2ODao {

	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(H2ODaoImpl.class.getName());

	/**
	 * Datasource.
	 */
	private DataSource dataSource;

	/**
	 * Named JDBC paramater.
	 */
	private NamedParameterJdbcTemplate jdbcTemplateObject;


	/** SQL property map. */
    private Properties sqlSource;

    protected class ThingsDataMapper implements RowMapper<ThingMeasure> {

        @Override
        public ThingMeasure mapRow(ResultSet rslt, int rowNum)
            throws SQLException {
            ThingMeasure thingsMeasure = new ThingMeasure();
            thingsMeasure.setThingId(rslt.getInt("THINGS_ID"));
            ThingsData thingsData = new ThingsData();
            thingsData.setLoggedDate(rslt.getDate("DATE"));
            thingsData.setData(rslt.getBigDecimal("CONSUMPTION"));
            ArrayList<ThingsData> data = new ArrayList<ThingsData>();
            data.add(thingsData);
            thingsMeasure.setWaterConsumptionList(data);
            return thingsMeasure;
        }

    }
	/* (non-Javadoc)
	 * @see com.gl.h2o.dao.H2ODao#recordConsumption(java.math.BigDecimal, java.lang.String)
	 */
	@Override
	public void recordConsumption(Integer deviceId, BigDecimal volume) {
		DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		dfm.setTimeZone(TimeZone.getTimeZone("IST"));
		String currentTime = dfm.format(new Date());
		// get sql from properties
		  String SQL = sqlSource.getProperty(WATER_CONSUMPTION_INSERT);

	      MapSqlParameterSource namedParameters = new MapSqlParameterSource();
	      namedParameters.addValue("deviceId", deviceId);
	      namedParameters.addValue("volume", volume);
	      namedParameters.addValue("loggedInTime", currentTime);

	      jdbcTemplateObject.update( SQL, namedParameters);
	      System.out.println("Created Record deviceId = " + deviceId  + " Surname = " + volume);
	      return;
	}

	/**
	  * Inject datasource.
	  *
	 * @param dataSource dataSource
	 */
	public void setDataSource(DataSource dataSourceParam) {
	      this.dataSource = dataSourceParam;
	      this.jdbcTemplateObject = new NamedParameterJdbcTemplate(dataSource);
	}

	/**
	 * Sets the sql properties resource.
	 * @param sqlSource the sqlSource to set
	 */
	public void setSqlSource(Properties sqlSource) {
		this.sqlSource = sqlSource;
	}

    @Override
    public ThingMeasure getCurrentWeekData(String userId) {
        String SQL = sqlSource.getProperty(FETCH_CONSUMPTION_DATA_FOR_CURRENT_WEEK);
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        if (null == userId) {
            namedParameters.addValue("userId", "1");
        } else {
            namedParameters.addValue("userId", userId);
        }
        List<ThingMeasure> thingsData = jdbcTemplateObject.query(SQL, namedParameters, new ThingsDataMapper());
        ThingMeasure returnVal = new ThingMeasure();
        ArrayList<ThingsData> data = new ArrayList<ThingsData>();
        for (ThingMeasure tm : thingsData) {
            returnVal.setThingId(tm.getThingId());
            data.add(tm.getWaterConsumptionList().get(0));
        }
        returnVal.setWaterConsumptionList(data);
        return returnVal;
    }

    @Override
    public ThingMeasure getPreviousWeekData(String userId) {
        String SQL = sqlSource.getProperty(FETCH_CONSUMPTION_DATA_FOR_PREVIOUS_WEEK);
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        if (null == userId) {
            namedParameters.addValue("userId", "1");
        } else {
            namedParameters.addValue("userId", userId);
        }
        List<ThingMeasure> thingsData = jdbcTemplateObject.query(SQL, namedParameters, new ThingsDataMapper());
        ThingMeasure returnVal = new ThingMeasure();
        ArrayList<ThingsData> data = new ArrayList<ThingsData>();
        for (ThingMeasure tm : thingsData) {
            returnVal.setThingId(tm.getThingId());
            data.add(tm.getWaterConsumptionList().get(0));
        }
        returnVal.setWaterConsumptionList(data);
        return returnVal;
    }

    @Override
    public ThingMeasure getCurrentMonthData(String userId) {
        String SQL = sqlSource.getProperty(FETCH_CONSUMPTION_DATA_FOR_CURRENT_MONTH);
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        if (null == userId) {
            namedParameters.addValue("userId", "1");
        } else {
            namedParameters.addValue("userId", userId);
        }
        List<ThingMeasure> thingsData = jdbcTemplateObject.query(SQL, namedParameters, new ThingsDataMapper());
        ThingMeasure returnVal = new ThingMeasure();
        ArrayList<ThingsData> data = new ArrayList<ThingsData>();
        for (ThingMeasure tm : thingsData) {
            returnVal.setThingId(tm.getThingId());
            data.add(tm.getWaterConsumptionList().get(0));
        }
        returnVal.setWaterConsumptionList(data);
        return returnVal;
    }

    @Override
    public ThingMeasure getPreviousMonthData(String userId) {
        String SQL = sqlSource.getProperty(FETCH_CONSUMPTION_DATA_FOR_PREVIOUS_MONTH);
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        if (null == userId) {
            namedParameters.addValue("userId", "1");
        } else {
            namedParameters.addValue("userId", userId);
        }
        namedParameters.addValue("count", 7);
        List<ThingMeasure> thingsData = jdbcTemplateObject.query(SQL, namedParameters, new ThingsDataMapper());
        ThingMeasure returnVal = new ThingMeasure();
        ArrayList<ThingsData> data = new ArrayList<ThingsData>();
        for (ThingMeasure tm : thingsData) {
            returnVal.setThingId(tm.getThingId());
            data.add(tm.getWaterConsumptionList().get(0));
        }
        returnVal.setWaterConsumptionList(data);
        return returnVal;
    }

}
