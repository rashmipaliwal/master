/**
 *
 */
package com.gl.h2o.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;



/**
 * @author rashmi.paliwal
 *
 */
public class H2OServiceImpl implements H2OService {

	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(H2OServiceImpl.class.getName());

	
	private final String USER_AGENT = "Mozilla/5.0";


	@Override
	public String sendPOSTRequest(String data , String auth) {
		
		String result = "";
		
		try {

		//String url = "http://localhost:8080/H2O/printXML.htm";
			String url  =	"http://spot-usecase2.cloudhub.io:80/spot";
		URL obj = new URL(url);
		//HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("content-type", "application/xml; charset=utf-8");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Authorization", auth);


		String urlParameters = data;

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());
		
		result = response.toString();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception occured");
		}
		
		return result;

	}

	@Override
	public String processXMLData(String xml) {
		System.out.println("processign xml data");
		String newxml = "";

		try {
			Document doc = StringToDocument(xml);
			updateNodeValue(doc);
			newxml = DocumentToString(doc);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception while modifying XML");
		}

		return newxml;
	}
	
	 public static Document StringToDocument(String strXml) throws Exception {

	        Document doc = null;
	        try {
	            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder builder = factory.newDocumentBuilder();
	            StringReader strReader = new StringReader(strXml);
	            InputSource is = new InputSource(strReader);
	            doc = (Document) builder.parse(is);
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw e;
	        }

	        return doc;
	    }
	 
	 
	 public static String DocumentToString(Document doc) throws Exception {

	        TransformerFactory tf = TransformerFactory.newInstance();
	        Transformer transformer = tf.newTransformer();
	        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
	        StringWriter writer = new StringWriter();
	        transformer.transform(new DOMSource(doc), new StreamResult(writer));
	        String output = writer.getBuffer().toString();
	        return output;
	    }
	 
	  public static void updateNodeValue(Document doc) {

	        Node rootNode = doc.getFirstChild();
	        Element newElement = doc.createElement("Promotion");
	        newElement.setAttribute("id", "1234");
	        newElement.setTextContent("BOGO");
	        rootNode.appendChild(newElement);
	    }

}
