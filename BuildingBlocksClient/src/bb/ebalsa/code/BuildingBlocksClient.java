package bb.ebalsa.code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BuildingBlocksClient {

	static RequestLogger requestLogger = null;
	
	public static void main(String[] args) {
	
		// APP LOOP -> PRINT OPTIONS MENU 
		iniLogger();
		Scanner in = new Scanner(System.in);
				
        boolean exit=false;
        int option;
		while(!exit){
			printOptions();
		    try{
		    	option = in.nextInt();
		    	String remainder = in.nextLine();
				
		    	if (option == 1){        //1.New request
		    		String additionalParameters = "";
		    		String origin="";
		    		String destination="";
		    		Map<String,String> parameters = new HashMap<String, String>();
		    		
			    	System.out.println("Please, insert origin and press enter:");
			    	origin = in.nextLine();
			    	System.out.println("Please, insert destination and press enter:");
			    	destination = in.nextLine();
			    	System.out.println("Additional parameters? (Y/N):");
			    	additionalParameters = in.nextLine();
			    	while(!"N".equalsIgnoreCase(additionalParameters.trim())){					    		
		    			if("Y".equalsIgnoreCase(additionalParameters.trim())){
		    				
		    			} else {
		    				System.out.println("\n Additional parameters? (Y/N):");
				    		additionalParameters = in.nextLine();
		    			}
		    		}
		    		
		    		//Instantiate a parameterbuilder:
		    		ParamsStringBuilder psb = new ParamsStringBuilder(origin, destination, parameters);
		    		String paramString = psb.buildParameterString();
					
					//Instantiate an invoker and call(parsString)
					RemoteServiceInvoker rm = new RemoteServiceInvoker();
					String output = rm.sendJSONrequest(paramString);
					System.out.println(output);
				
				} else if (option == 2){  //2.List Requests
					
					System.out.println("\n" ); 
					List<String> responses = requestLogger.listRequests();
					for(String s: responses){
						System.out.println(s);
					}
					System.out.println("\n" );
					
				} else if (option == 3){ 
					
				} else if (option==0){ //0.Exit
					exit=true;
				}
				
				else{
					//Do nothing
				}
		    } catch (Exception e) {
		    	System.out.println("Unrecognized option. Please check your fingers!!");
			}
			
		}
		 
	}
	
	private static void printOptions(){
		System.out.println("Please choose one option: ");
		System.out.println("1. New request ");
		System.out.println("2. List Requests log");
		System.out.println("3. Execute historical requests");
		System.out.println("0. Exit");
	
	}
	
	private static void iniLogger(){
		BuildingBlocksClient.requestLogger = new RequestLoggerMemImpl();
	}

}
