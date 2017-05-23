package bb.ebalsa.code;

import java.util.Scanner;

public class BuildingBlocksClient {

	public static void main(String[] args) {
	
		// APP LOOP -> PRINT OPTIONS MENU 
		Scanner in = new Scanner(System.in);
        boolean exit=false;
        int option;
		while(!exit){
			printOptions();
		    try{
		    	option = in.nextInt();
				if (option == 1){        //1.New request
					System.out.println("OPCION 1 ESCOGIDA: ");
				
				} else if (option == 2){ //2.List Requests
					System.out.println("OPCION 2 ESCOGIDA: ");
					
				} else if (option == 3){ //3.Exit
					exit=true;
				} else{
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
		System.out.println("3. Exit");

	}

}
