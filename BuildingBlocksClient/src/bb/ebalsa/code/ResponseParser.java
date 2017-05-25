package bb.ebalsa.code;

public interface ResponseParser {

	//Receives an web-response and returns a friendly format String
	public String parseResponses(String unfriendlyString); 
}
