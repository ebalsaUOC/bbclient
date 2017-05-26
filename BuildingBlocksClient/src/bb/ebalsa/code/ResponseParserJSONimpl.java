package bb.ebalsa.code;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ResponseParserJSONimpl implements ResponseParser {

	@Override
	public String parseResponses(String unfriendlyString) {

		//String test="";
		String friendlyString="";
				
		
		JSONParser parser = new JSONParser();
		try{
			Object obj = parser.parse(unfriendlyString);
	       	JSONObject jsonObject = (JSONObject) obj;
	       	
	       	String status =  (String) jsonObject.get("status");
	       	
	       	if(!"OK".equalsIgnoreCase(status)){
	       		return "Bad request: " + status;
	       	}
	       	
	       	List<String> origins =  (List) jsonObject.get("origin_addresses");
	       	String origin = origins.get(0);
	       	List<String>  destinations = (List) jsonObject.get("destination_addresses");
	       	String destination = destinations.get(0);
	       	List<JSONObject> rows = (List) jsonObject.get("rows");
	       	JSONObject row = rows.get(0);
	       	List<JSONObject> elements =(List) row.get("elements");
	       	JSONObject element = elements.get(0);
	        JSONObject distanceObj = (JSONObject) element.get("distance");
	        String distance = (String) distanceObj.get("text");
	        JSONObject durationObj = (JSONObject) element.get("duration");
	        String duration = (String) durationObj.get("text");
	        
	        friendlyString = "\n" + "Distance from " + origin + " to " + destination +  " is " + distance + ". Average duration is " + duration + "." + "\n";
	       	
	       	
		} catch (Exception e) {
			e.printStackTrace();
		}

		return friendlyString;

	}

}
