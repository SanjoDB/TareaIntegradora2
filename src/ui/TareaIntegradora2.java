package ui;

import java.util.Scanner;

import model.Control;
import model.Zone;

public class TareaIntegradora2{
	
	private Control control;
	private Zone newZone;
	private Scanner sc;
	
	/**
	 * Constructor of the class, do not recieve parameters.  
	 * Initialize the lector
	 * Initilize the values of the app
	 */
	public TareaIntegradora2() {
		sc= new Scanner(System.in);
		control = new Control();
	}

	/**
	 * Main method
	 */
	public static void main(String [] args) {
		
		System.out.println("Initialicing the app");
		
		TareaIntegradora2 obPpal= new TareaIntegradora2();
		
		int option=0;
		
		do{
			option= obPpal.showMenu();
			obPpal.executeOperation(option);
			
		}while (option!=0);
		
	}

	/**
	 * Method that shows the menu of the app, miss the validation of the typed value
	 * @return option int, the option type by the user
	 */
	public int showMenu() {
		int option=0;

		System.out.println(
				"Select one of the options\n" +
				"(1) Add a Wetland\n" +
				"(2) Add a Specie\n"+
				"(3) Add an Event \n"+
				"(4) Show the number of maintenance of a wetland\n" +
				"(5) Show all the Wetlands known\n" +  
				"(6) Show the Wetland with the least Species of Flora\n" +
				"(7) Show the Wetland with the most Species of Fauna\n" +
				"(8) Show the Wetlands with an specific Specie\n" +
				"(0) End"
				);
		option= sc.nextInt();
		sc.nextLine();
		return option;
	}

	/**
	 * Method incharge to call the methods that solve every requirement of the aplication 
	 * @param operation int, is the number type by the user 
	 */
	public void executeOperation(int operation) {
		
		switch(operation) {
		case 0:
			System.out.println("Bye!");
			break;
		case 1:
			addWetland();
			break;
		case 2:
			addSpecie();
			break;
	
		case 3:
			addEvent();
			break;

		case 4:
			numMaintenanceWetland();
			break;
		
		case 5:
			System.out.println(control.showWetlands());
			break;
		
		case 6:
			wetlandWithLeastFlora();
			break;

		case 7:
			wetlandWithMostFauna();
			break;
		case 8:
			wetlandsSpecie();
			break;
		default:
			System.out.println("Error, the option is not valid");
		
		}
	}

	/**
	 * Method incharge to add a Wetland to the array 
	 */
	public void addWetland() {

		if(control.hasSpace()){
			
			String name= "";
			String type= "";
			String url;
			double area;
			String protectedArea= "";
			String zoneType = "", nameUbication = "";
			int zone, typeNum, protectedA;

			//ask for values

			System.out.println("Please type the name of the new Wetland");
			boolean flag= true;
			while(flag){

				name= sc.nextLine();

				if(control.repeatWetland(name)==1){

					System.out.println("This name is already registered");

				}
				else if(control.repeatWetland(name)==0){

					flag= false;

				}
			}

			System.out.println("Please write the type of the new Wetland");
			System.out.println("1 --> Public or 2 --> Private");
			flag= true;
			while(flag){

				typeNum= Integer.parseInt(sc.nextLine());

				if(typeNum==1){
					type= "Public";
					flag= false;
				}
				if(typeNum==2){
					type= "Private";
					flag= false;
				}
				else{
					System.out.println("Please type one of the specified options");
				}
			}
		
			System.out.println("Please type the url of the new Wetland");
			url= sc.nextLine();

			System.out.println("Please type the area of the new Wetland");
			System.out.println("(on square kilometers)");
			area= sc.nextDouble();
			sc.nextLine();

			System.out.println("Please type if the Wetland is protected");
			System.out.println("1 --> Yes or 2 --> No");
			flag= true;
			while(flag){

				protectedA= Integer.parseInt(sc.nextLine());

				if(protectedA==1){
					protectedArea= "Yes";
					flag= false;
				}
				if(protectedA==2){
					protectedArea= "No";
					flag= false;
				}
				else{
					System.out.println("Please type one of the specified options");
				}
			}

			System.out.println("Please type the zone where the Wetland is located");
			System.out.println("1 --> Urban or 2 --> Rural");
			flag= true;
			while(flag){

				zone = Integer.parseInt(sc.nextLine());
				if(zone==1){
					System.out.println("Please type the name of the neighborhood where the Wetland is located");
					nameUbication = sc.nextLine();
					zoneType= "Urban";
					flag= false;
				}
				if(zone==2){
					System.out.println("Please type the name of the corregimiento where the Wetland is located");
					nameUbication = sc.nextLine();
					zoneType= "Rural";
					flag= false;
				}
				else{
					System.out.println("Please type one of the specified options");
				}
			}

			newZone= new Zone(zoneType, nameUbication);

			//add the Wetland
			control.addWetland(name, type, url, area, protectedArea, newZone);

		}else{

			System.out.println("There is no space in the array to add more Wetlands");

		}
	}

	/**
	 * Method incharge to add a Specie to an specific Wetland of the array 
	 */
	public void addSpecie() {

		if(control.hasWetland()){
			String name= "";

			//ask for wetland
			System.out.println("Please type the name of the Wetland where you want to add a specie");
			boolean flag= true;
			while(flag){

				name= sc.nextLine();

				if(control.findWetlandBool(name)==1){

					flag= false;

				}
				else if(control.findWetlandBool(name)==0){

					System.out.println("This Wetland has not been registered");

				}
			}
			
			int type;
			String nameS= "", cientificName, migratory= "";
			int migrate;

			//ask for values

			System.out.println("Please type the name of the Specie");
			flag= true;
			while(flag){

				nameS = sc.nextLine();
				if(control.repeatSpecies(name)==1){
					System.out.println("The Specie is already registered");
				}
				else if(control.repeatSpecies(name)==0){
					flag= false;
				}
			}

			System.out.println("Please type the cientific name of the Specie");
			cientificName = sc.nextLine();
		
			System.out.println("Please type if the Specie is migratory");
			System.out.println("1 -- Yes or 2 -- No");
			flag= true;
			while(flag){

				migrate= Integer.parseInt(sc.nextLine());

				if(migrate==1){
					migratory= "Yes";
					flag= false;
				}
				if(migrate==2){
					migratory= "No";
					flag= false;
				}
				else{
					System.out.println("Please type one of the specified options");
				}
			}

			System.out.println("Please write the type of Specie it is");
			System.out.println("Type \n 1 --> TERRESTRIAL_FLORA \n 2 --> AQUATIC_FLORA \n 3 --> BIRD \n 4 --> MAMMAL \n 5 --> AQUATIC");
			type= sc.nextInt();
			sc.nextLine();

			//add the Specie
			control.addSpecieToWetland(name, nameS, cientificName, migratory, type);

		}else{

			System.out.println("There is no Wetlands registered");

		}
	}

	/**
	 * Method incharge to add an Event to an specific Wetland of the array 
	 */
	public void addEvent() {

		if(control.hasWetland()){

			String name= "";

			//ask for wetland
			System.out.println("Please type the name of the Wetland where you want to add a event");
			boolean flag= true;
			while(flag){

				name= sc.nextLine();

				if(control.findWetlandBool(name)==1){

					flag= false;

				}
				else if(control.findWetlandBool(name)==0){

					System.out.println("This Wetland has not been registered");

				}
			}
			
			int eventType, day, month, year;
			String host, description;
			double cost;

			//ask for values

			System.out.println("Please write the type of Event it is going to be");
			System.out.println("Type \n 1 --> MAINTENANCE \n 2 --> SCHOOL_VISIT \n 3 --> IMPROVEMENT_ACTIVITY \n 4 --> CELEBRATION");
			eventType= sc.nextInt();
			sc.nextLine();

			System.out.println("Please type the day the Event will be");
			day= sc.nextInt();
			sc.nextLine();
		
			System.out.println("Please type the month the Event will be");
			month= sc.nextInt();
			sc.nextLine();

			System.out.println("Please type the year the Event will be");
			year= sc.nextInt();
			sc.nextLine();

			System.out.println("Please type the name of the host of the Event");
			host= sc.nextLine();

			System.out.println("Please type a short description of the Event");
			description= sc.nextLine();

			System.out.println("Please type the cost of the Event");
			cost= sc.nextDouble();
			sc.nextLine();

			//add the Event
			control.addEventToWetland(name, eventType, day, month, year, host, description, cost);

		}else{

			System.out.println("There is no Wetlands registered");

		}
	}

	/**
	 * Method incharge of showing the number of maintenances made in an specific Wetland in a certain year
	 */
	public void numMaintenanceWetland() {

		if(control.hasWetland()){

			String name= "";
			System.out.println("Please type the name of the Wetland you want to know the number of maintenances per year");
			boolean flag= true;
			while(flag){

				name= sc.nextLine();

				if(control.findWetlandBool(name)==1){

					flag= false;

				}
				else if(control.findWetlandBool(name)==0){

					System.out.println("This Wetland has not been registered");

				}
			}

			int year;
			System.out.println("Please type the year you want to see");
			year= sc.nextInt();
			sc.nextLine();

			System.out.println(control.maintenanceWetland(name, year));

		}else{

			System.out.println("There is no Wetlands registered");

		}
	}

	
	/**
	 * Method incharge of showing the name of the Wetland with the least number of species of flora
	 */
	public void wetlandWithLeastFlora(){

		if(control.hasWetland()){

			System.out.println(control.leastFlora());

		}else{

			System.out.println("There is no Wetlands registered");

		}

	}

	/**
	 * Method incharge of showing the name of the Wetland with the most number of species of fauna
	 */
	public void wetlandWithMostFauna(){

		if(control.hasWetland()){

			System.out.println(control.mostFauna());

		}else{

			System.out.println("There is no Wetlands registered");

		}
		
	}

	/**
	 * Method incharge of showing the Wetlands with the an specific Specie
	 */
	public void wetlandsSpecie(){

		String name;
		System.out.println("Please type the name of the Specie you want to search");
		name= sc.nextLine();

		System.out.println(control.specieWetlands(name));
	}
}