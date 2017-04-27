/**
 *
 */
package com.gl.h2o.service;

import java.math.BigDecimal;

import com.gl.h2o.pojos.ThingMeasure;

/**
 * @author rashmi.paliwal
 *
 */
public interface H2OService {
	
	String sendPOSTRequest(String data , String auth);
	
	String processXMLData(String xml);
	
	
}
