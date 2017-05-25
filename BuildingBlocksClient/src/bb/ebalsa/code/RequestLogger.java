package bb.ebalsa.code;

import java.util.List;
import java.util.Map;

public interface RequestLogger {

	//Save a request
	public String logRequest (String request);
	
	//List all requests
	public List<String> listRequests();
	
	//Fetch a request
	public String getRequest(int id);
	
}
