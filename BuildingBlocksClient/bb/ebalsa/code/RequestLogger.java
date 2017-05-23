package bb.ebalsa.code;

import java.util.Map;

public interface RequestLogger {

	//Save a request
	public String logRequest (String request);
	
	//List all requests
	public Map<Integer,String> listRequests();
	
	//Fetch a request
	public String getrRequest(int id);
	
}
