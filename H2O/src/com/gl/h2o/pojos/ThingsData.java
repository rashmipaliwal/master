/**
 *
 */
package com.gl.h2o.pojos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sujatha Malik
 *
 */
public class ThingsData {

    /**
     * Date logged.
     */
    private Date loggedDate;

    /**
     * Data.
     */
    private BigDecimal data;

    /**
     * @return the loggedDate
     */
    public Date getLoggedDate() {
        return loggedDate;
    }

    /**
     * @param loggedDate the loggedDate to set
     */
    public void setLoggedDate(Date loggedDate) {
        this.loggedDate = loggedDate;
    }

    /**
     * @return the data
     */
    public BigDecimal getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(BigDecimal data) {
        this.data = data;
    }

}
