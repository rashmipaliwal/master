/**
 *
 */
package com.gl.h2o.controller;

import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gl.h2o.service.H2OService;

/**
 * @author rashmi.paliwal
 *
 */

// @Controller
public class H2OController {

	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(H2OController.class.getName());

	/**
	 * Service class.
	 */
	private H2OService h2oService;


	 @RequestMapping(value = "/processXml",
			    method = RequestMethod.POST,
			    consumes = "application/xml")
			  public ResponseEntity<String> processXml(
			    @RequestBody String requestBody , HttpServletRequest req){
		 System.out.println("processign xml");
		 System.out.println("xml is "+ requestBody);
		 
		 
		 String username = "";
		 String password ="";
		 
		 final String authorization = req.getHeader("Authorization");
    if (authorization != null && authorization.startsWith("Basic")) {
        // Authorization: Basic base64credentials
        String base64Credentials = authorization.substring("Basic".length()).trim();
        String credentials = new String(Base64.decodeBase64(base64Credentials),Charset.forName("UTF-8"));
        // credentials = username:password
        final String[] values = credentials.split(":",2);
        username = values[0];
        password = values[1];
    }

		 //String processedXMl = this.h2oService.processXMLData(requestBody);
    String processedXMl = requestBody;

	String result =	 this.h2oService.sendPOSTRequest(processedXMl ,authorization);

			    return new ResponseEntity<String>(
			      "Handled application/xml request. Request body was: " 
			      + result, 
			      new HttpHeaders(), 
			      HttpStatus.OK);
			  }
	 
	 @RequestMapping(value = "/printXML",
			    method = RequestMethod.POST,
			    consumes = "application/xml")
			  public ResponseEntity<String> printXML(
			    @RequestBody String requestBody){
		 System.out.println("processign xml");
		 System.out.println("printing xml is "+ requestBody);
			    return new ResponseEntity<String>(
			      "Handled application/xml request. Request body was: " 
			      + requestBody, 
			      new HttpHeaders(), 
			      HttpStatus.OK);
			  }

	/**
	 * Inject service class.
	 * @param h2oService the h2oService to set
	 */
	public void setH2oService(H2OService h2oService) {
		this.h2oService = h2oService;
	}

}
