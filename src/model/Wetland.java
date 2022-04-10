package model;

public class Wetland{

	public static final int length = 200;
	
	/** 
	 * name String is use to store the name of wetland it is
	 * type String is use to store the type of the wetland it is
	 * url String is use to store the url of the web page of the wetland
	 */
	private String name, type, url;

	/** 
	 * area double is use to store the area of the wetland
	 */
	private double area;

	/** 
	 * protectedArea boolean is use to check if the area of the wetland is protected or no by the goverment
	 */
	private String protectedArea;

	/** 
	 * numMaintenance int is use to check if the area of the wetland is protected or no by the goverment
	 */
	private int numMaintenance;
	
	//Relationships
	private Zone zone;
	private ManagementPlan restoragePercentage, conservationPercentage;
	private Event [] events;
	private Specie [] species;
	
	//constructor
	/** 
	 * Constructor used for obj Wetland
	 * @param name
	 * @param type
	 * @param url
	 * @param area
	 * @param protectedArea
	 */
	public Wetland(String name, String type, String url, double area, String protectedArea, Zone zone){
		
		this.name = name;
		this.type = type;
		this.url = url;
		this.area = area;
		this.protectedArea = protectedArea;
		this.zone = zone;
		//init
		events = new Event[length];
		species = new Specie[length];
		
	}

	
	/** 
	 * @return String
	 */
	//get and set
	public String getName(){
		
		return name;
		
	}

	
	/** 
	 * @param name
	 */
	public void setName(String name){
		
		this.name= name;
		
	}

	
	/** 
	 * @return String
	 */
	public String getType(){
		
		return type;
		
	}

	
	/** 
	 * @param type
	 */
	public void setType(String type){
		
		this.type= type;
		
	}

	
	/** 
	 * @return String
	 */
	public String getUrl(){
		
		return url;
		
	}

	
	/** 
	 * @param url
	 */
	public void setUrl(String url){
		
		this.url= url;
		
	}

	
	/** 
	 * @return double
	 */
	public double getArea(){
		
		return area;
		
	}

	
	/** 
	 * @param area
	 */
	public void setArea(double area){
		
		this.area= area;
		
	}

	
	/** 
	 * @return boolean
	 */
	public String getProtectedArea(){
		
		return protectedArea;
		
	}

	
	/** 
	 * @param protectedArea
	 */
	public void setProtectedArea(String protectedArea){
		
		this.protectedArea= protectedArea;
		
	}

	/** 
	 * @return int
	 */
	public int getNumMaintenance(){
		
		return numMaintenance;
		
	}
	
	/** 
	 * @param numMaintenance
	 */
	public void setNumMaintenance(int numMaintenance){
		
		this.numMaintenance= numMaintenance;
		
	}

	/** 
	 * @return Zone
	 */
	public Zone getZone(){
		
		return zone;
		
	}
	
	/** 
	 * @param zoneType
	 */
	public void setZone(Zone zone){
		
		this.zone= zone;
		
	}
	
	/** 
	 * @return ManagementPlan
	 */
	public ManagementPlan getRestoragePercentage(){
		
		return restoragePercentage;
		
	}

	
	/** 
	 * @param restoragePercentage
	 */
	public void setRestoragePercentage(ManagementPlan restoragePercentage){
		
		this.restoragePercentage= restoragePercentage;
		
	}

	
	/** 
	 * @return ManagementPlan
	 */
	public ManagementPlan getConservationPercentage(){
		
		return conservationPercentage;
		
	}

	
	/** 
	 * @param conservationPercentage
	 */
	public void setConservationPercentage(ManagementPlan conservationPercentage){
		
		this.conservationPercentage= conservationPercentage;
		
	}

	//Methods
	
	/**
	* @return true if you can add a new event, false in case it is full
	*/
	public boolean hasSpaceE(){

		boolean emptyPosition = false;

		for(int i=0; i<length && !emptyPosition; i++){

			if(events[i]==null){

				emptyPosition = true;

			}
		}

		return emptyPosition;
	}

	/**
	* @return un entero con la primera posicion vacia en el arreglo
	* y -1 si el arreglo esta lleno
	*/
	public int getEmptyPositionE(){
		boolean flag = false;
		int position = -1;

		for(int i=0; i<length && !flag; i++){

			if(events[i]==null){
				
				position = i;
				flag = true;

			}
		}

		return position;
	}

	/**
	*
	 */
	public String addEvent(int eventType, int day, int month, int year, String host, String description, double cost) {

		String out= "";
		
		int emptyPos = getEmptyPositionE(); //busco la primera posicion vacia

		//si el arreglo esta lleno?

		if(emptyPos == -1){ //esta lleno


			//no se puede agregar

			out = "The array is full";

		}else{ //Si no esta lleno

			Date date = new Date(day, month, year);
			events[emptyPos] = new Event (eventType, day, month, year, host, description, cost);
			out = "The event was added";

		}
		
		return out;
	}

	/**
	* @return true if you can add a new event, false in case it is full
	*/
	public boolean hasSpaceS(){

		boolean emptyPosition = false;

		for(int i=0; i<length && !emptyPosition; i++){

			if(species[i]==null){

				emptyPosition = true;

			}
		}

		return emptyPosition;
	}

	/**
	* @return un entero con la primera posicion vacia en el arreglo
	* y -1 si el arreglo esta lleno
	*/
	public int getEmptyPositionS(){
		boolean flag = false;
		int position = -1;

		for(int i=0; i<length && !flag; i++){

			if(species[i]==null){
				
				position = i;
				flag = true;

			}
		}

		return position;
	}

	/**
	*
	 */
	public String addSpecie(String name, String cientificName, String migratory, int type) {

		String out= "";
		
		int emptyPos = getEmptyPositionS(); //busco la primera posicion vacia

		//si el arreglo esta lleno?

		if(emptyPos == -1){ //esta lleno


			//no se puede agregar

			out = "The array is full";

		}else{ //Si no esta lleno

			species[emptyPos] = new Specie (name, cientificName, migratory, type);
			out = "The specie was added";

		}
		
		return out;
	}

	public int repeatSpecie(){

        boolean flag = false;
		int repeat= 0;
		String nameS= "";
		
		for(int i=0; i<length && !flag; i++){

			if(species[i]!=null && species[i].getName().equals(nameS)){
				
				flag = true;
				repeat = 1;

			}
		}

        return repeat;
	}

	public int numMaintenance(String name, int year){

		int counter = 0;

		for(int i = 0; i<length; i++){
			if(events[i]!=null && events[i].getEventType().equals(WetEvent.MAINTENANCE) && events[i].getYear()==(year)){
				counter++;
			}
		}

		return counter;
	}

	public String showSpecies(){
		String outs= "";

		for(int index=0; index<length; index++){

			if(species[index]!=null){
				outs+= species[index];
			}
		}

		return outs;
	}

	public int lessSpecie(int counter){

		for(int index=0; index<length; index++){
			if (species[index]!=null && species[index].getType().equals(Kind.TERRESTRIAL_FLORA) || species[index].getType().equals(Kind.AQUATIC_FLORA)){
				counter++;
			}
		}

		return counter;
	}

	public int moreSpecie(int counter){

		for(int index=0; index<length; index++){
			if (species[index]!=null){
				if(species[index].getType().equals(Kind.BIRD) || species[index].getType().equals(Kind.MAMMAL) || species[index].getType().equals(Kind.AQUATIC)){
					counter++;
				}
			}
		}

		return counter;
	}

	public int findSpecie(String name, int i){

		int pos= -1;

		for(int index=0; index<length; index++){
			if (species[index]!=null){
				if(species[index].getName().equals(name)){
					pos = i;
				}
				
			}
		}

		return pos;
	}

	public String toString() {
		return "Name of the Wetland: " + name + "\n" + 
		"Type of Wetland: " + type + "\n" + 
		"Url of the Wetland: " + url + "\n" + 
		"Area of the Wetland: " + area + "\n" + 
		"Is it protected? " + protectedArea + "\n" +
		zone.toString();
	}
}