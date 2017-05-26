package bb.ebalsa.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParamsStringBuilder {

	private String origin;
	private String destination;
	private Map<String,String> additionalParameters;
	
	public static final List<String> ALLOWED_PARAMETERS;
	static {
		ALLOWED_PARAMETERS = new ArrayList<String>();

		ALLOWED_PARAMETERS.add("GET_IDCENTER");
		ALLOWED_PARAMETERS.add("");
	
	}
	
	//Builder: origins + destination + map pars<K,V>
	public ParamsStringBuilder(String origin, String destination,
			Map<String, String> additionalParameters) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.additionalParameters = additionalParameters;
	}
	
	public String buildParameterString(){
		String paramStr ="";
		paramStr += "?units=imperial&origins=";
		origin = origin.replace(" ", "+");
		paramStr += origin+"&destinations=";
		destination=destination.replace(" ", "+");
		paramStr += destination;
		
		//TODO:additional params:
		
		
		return(paramStr);
		
		
	}
	


}
