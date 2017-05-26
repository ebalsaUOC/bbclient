package bb.ebalsa.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RemoteServiceInvoker {

	static final String URL_BASE = "https://maps.googleapis.com/maps/api/distancematrix/";
	static final String JSON = "json";
	static final String XML = "xml";
	static final String APP_KEY = "&key=AIzaSyCa8BGOGSfSo2FLe9f1-ZJixzRXw0gypOQ";
	
	private ResponseParser rp;
	
	//Returns friendly format String (JSON)
	public String sendJSONrequest(String parametersString) throws MalformedURLException{
		
		URL fullURL = new URL(URL_BASE+JSON+parametersString+APP_KEY);
		//URL fullURL = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins=Washington,DC&destinations=New+York+City,NY"+APP_KEY);
		rp=new ResponseParserJSONimpl();
		String friendlyResponse = "";
		String data = "";
		
		//log Request:
		this.saveRequest(fullURL.toString());
		
		//call remote service:
		data=callRemoteService(fullURL);
				
		//parse response:
		friendlyResponse=rp.parseResponses(data);
		
		return friendlyResponse;
	}
	
	//Returns friendly format String (XML)
	public String sendXMLrequest(String parametersString){
		String fullURL = URL_BASE+XML+parametersString+APP_KEY; 
		
		throw new RuntimeException("Not implemented yet!!");
		
		//return null;
	}
	
	
	//Call Remote Service:
	public String callRemoteService(URL fullURL){
		String data="";
		try{
			HttpURLConnection conn = (HttpURLConnection) fullURL.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
			
			String output="";
			while ((output = br.readLine()) != null) {
				data += output;
			}

			conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }
		
		return data;
	}
	
	//Log request:
	public void saveRequest(String request){
		BuildingBlocksClient.requestLogger.logRequest(request);
	}
}
