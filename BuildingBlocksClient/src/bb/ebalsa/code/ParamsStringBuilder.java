package bb.ebalsa.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParamsStringBuilder {

	private List<String> origins;
	private String destination;
	private Map<String,String> additionalParameters;
	
	public static final List<String> ALLOWED_PARAMETERS;
	static {
		ALLOWED_PARAMETERS = new ArrayList<String>();

		ALLOWED_PARAMETERS.add("GET_IDCENTER");
		ALLOWED_PARAMETERS.add("");
	
	}
	
	//Builder: origins + destination + map pars<K,V>
	public ParamsStringBuilder(List<String> origins, String destination,
			Map<String, String> additionalParameters) {
		super();
		this.origins = origins;
		this.destination = destination;
		this.additionalParameters = additionalParameters;
	}
	
	public String buildParameterString(){
		String paramStr ="";
		
		
		return("work in progress!!");
		
		
	}
	


}
