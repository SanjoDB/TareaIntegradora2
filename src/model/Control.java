package model;

public class Control{

	/** 
	 * Number of wetlands in the array
	 */
	public static final int size = 80;
	
	/** 
	 * wetland array is use to store all the wetlands of the programm
	 */
	private Wetland [] wetlands;
	
	/** 
	 * Constructor of the class, receive no parameters
	 */
	public Control(){
		
		//init
		wetlands = new Wetland[size];
		
	}

	/**
	 * Method used to verify if there is space on the array of Wetlands
	 * @return true if you can add a new wetland, false in case it is full
	 */
	public boolean hasSpace(){

		boolean emptyPosition = false;

		for(int i=0; i<size && !emptyPosition; i++){

			if(wetlands[i]==null){

				emptyPosition = true;

			}
		}

		return emptyPosition;
	}

	/**
	 * Method used to obtain the position of an empty space on the array of Wetlands
	 * @return position int, the empty position in the array
	 */
	public int getEmptyPosition(){
		boolean flag = false;
		int position = -1;

		for(int i=0; i<size && !flag; i++){

			if(wetlands[i]==null){
				
				position = i;
				flag = true;

			}
		}

		return position;
	}

	/**
	 * Method used to verify if the name of the wetland we want to store is already registered
	 * @param name String, name of the Wetland
	 * @return repeat int, defines if it is registered or not
	 */
	public int repeatWetland(String name){

        boolean flag = false;
		int repeat= 0;
		
		for(int i=0; i<size && !flag; i++){

			if(wetlands[i]!=null && wetlands[i].getName().equals(name)){
				
				flag = true;
				repeat = 1;

			}
		}

        return repeat;
	}

	/**
	 * Method used to search the position of a Wetland registered
	 * @param name String, name of the wetland registered
	 * @param type String, type of the wetland (Public or Private) registered
	 * @param url String, url of the wetland registered
	 * @param area double, area of the wetland registered
	 * @param protectedArea String, if the area is protected or not
	 * @param zone Zone, type of the zone and its ubication registered
	 * @return out String, wetland added
	 */
	public String addWetland(String name, String type, String url, double area, String protectedArea, Zone zone) {

		String out= "";
		
		int emptyPos = getEmptyPosition(); //busco la primera posicion vacia

		//si el arreglo esta lleno?

		if(emptyPos == -1){ //esta lleno


			//no se puede agregar

			out = "The array is full";

		}else{ //Si no esta lleno

			wetlands[emptyPos] = new Wetland (name, type, url, area, protectedArea, zone);
			out = "The wetland was added";

		}
		
		return out;
	}

	/**
	 * Method used to search the position of a Wetland registered
	 * @return position int, position of the Wetland
	 */
	public int findWetland(String name){

        boolean flag = false;
		int position = -1;
		
		for(int i=0; i<size && !flag; i++){

			if(wetlands[i]!=null && wetlands[i].getName().equals(name)){
				
				flag = true;
				position = i;

			}
		}

        return position;
	}

	/**
	 * Method used to verify if there is any Wetland registered
	 * @return ocupiedPosition boolean, defines if there is or not
	 */
	public boolean hasWetland(){

		boolean ocupiedPosition = false;

		for(int i=0; i<size && !ocupiedPosition; i++){

			if(wetlands[i]!=null){

				ocupiedPosition = true;

			}
		}

		return ocupiedPosition;
	}

	/**
	 * Method used to verify if the Wetland exists
	 * @return find int, defines if it exists or not
	 */
	public int findWetlandBool(String name){

        boolean flag = false;
		int find= 0;
		
		for(int i=0; i<size && !flag; i++){

			if(wetlands[i]!=null && wetlands[i].getName().equals(name)){
				
				flag = true;
				find = 1;

			}
		}

        return find;
	}

	/**
	 * Method that add an event to an specific Wetland
	 * @param name String, name of the Wetland where it is gonna be added
	 * @param eventType int, type of event registered
	 * @param day int, value of the day of the event registered
	 * @param month int, value of the month of the event registered
	 * @param year int, value of the year of the event registered
	 * @param host String, name of the host of the event registered
	 * @param description String, short description of the event registered
	 * @param cost double, value of the event registered
	 */
	public void addEventToWetland(String name, int eventType, int day, int month, int year, String host, String description, double cost){

		int pos = findWetland(name);
		if(pos!= -1){
			wetlands[pos].addEvent(eventType, day, month, year, host, description, cost);
		}
	}

	/**
	 * Method used to verify if the name of the specie we want to store is not registered yet
	 * @param name String, name of the specie
	 * @return save int, defines if it is registered or not
	 */
	public int repeatSpecies(String name){

		int pos = findWetland(name);
		int save= 0;
		if(pos!= -1){
			save= wetlands[pos].repeatSpecie();
		}

		return save;
	}

	/**
	 * Method that add a specie to an specific Wetland
	 * @param name String, name of the Wetland where it is gonna be added
	 * @param nameS String, name of the specie registered
	 * @param cientificName String, cientific name of the specie registered
	 * @param migratory String, if the specie is migratory or not
	 * @param type int, type of the specie registered
	 */
	public void addSpecieToWetland(String name, String nameS, String cientificName, String migratory, int type){

		int pos = findWetland(name);
		if(pos!= -1){
			wetlands[pos].addSpecie(nameS, cientificName, migratory, type);
		}
	}

	/**
	 * Method that searches in the array of wetlands and store each of them with their species
	 * @return out String, the String of the Wetlands with their species
	 */
	public String showWetlands(){

		String out= "";
        boolean flag = false;

        for(int i=0; i<size && !flag; i++){

            if(wetlands[i]==null){

			    flag = true;

		    }else{
                
                out += wetlands[i] + "\n"
				+ wetlands[i].showSpecies() + "\n";

		    }
        }

		return out;
	}

	/**
	 * Method that searches in the array of wetlands an specific Wetland giving the number of maintenances per year
	 * @param name String, is the name of the Wetland entered by the user
	 * @param year int, is the year entered by the user
	 * @return count String, the number of maintenances made in a Wetland
	 */
	public int maintenanceWetland(String name, int year){

		boolean flag= false;
		int count = 0;

		for(int index=0; index<size; index++){

			if(wetlands[index]!=null){
				if(wetlands[index].getName().equals(name)){
					count = wetlands[index].numMaintenance(year);
				}
			}
		}

		return count;
	}

	/**
	 * Method that searches in the array of wetlands the Wetland with the least number of Flora Species
	 * @return out String, the name of the Wetland with the least Flora Species
	 */
	public String leastFlora(){

		int least = 100000;
		String out = "";
		int pos = -1;
		int save = 0;

		for(int i=0; i<size; i++){
			int counter = 0;
			if(wetlands[i]!=null){
				save =wetlands[i].lessSpecie(counter);
				if(save<least){
					least=save;
					pos = i;
				}
			}
		}
		out = wetlands[pos].getName();

		return out;
	}

	/**
	 * Method that searches in the array of wetlands the Wetland with the most number of Fauna Species
	 * @return out String, the name of the Wetland with the most Fauna Species
	 */
	public String mostFauna(){

		int most = 0;
		String out = "";
		int pos = -1;
		int save = 0;

		for(int i=0; i<size; i++){
			int counter = 0;
			if(wetlands[i]!=null){
				save = wetlands[i].moreSpecie(counter);
				if(most<save){
					most=save;
					pos = i;
				}
			}
		}
		out = wetlands[pos].getName();

		return out;
	}

	/**
	 * Method that searches in the array of wetlands those who have an specific Specie and storage them
	 * @param name String, is the name of a specie a user entered
	 * @return out String, the Wetlands storaged
	 */
	public String specieWetlands(String name){

		String out = "";
		int save = 0;
		boolean flag= false;

		for(int i=0; i<size && wetlands[i]!=null && !flag; i++){
			save = wetlands[i].findSpecie(name, i);
			if(save!=-1){
				out += wetlands[save] + "\n";
			}
		}

		return out;
	}
}