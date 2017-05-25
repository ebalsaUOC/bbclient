package bb.ebalsa.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RequestLoggerMemImpl implements RequestLogger {

	private int counter;
	private List<String> requests;
	
	public RequestLoggerMemImpl(){
		this.counter = 0;
		this.requests = new ArrayList<String>();
	}
	
	@Override
	public String logRequest(String request) {
		this.counter++;
		this.requests.add(counter + ": " + request);
		return "OK";
	}

	@Override
	public List<String> listRequests() {
		return this.requests;
	}

	@Override
	public String getRequest(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
