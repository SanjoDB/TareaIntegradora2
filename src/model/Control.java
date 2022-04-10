package model;

public class Control{

	public static final int size = 80;
	
	//Relationships
	/** 
	 * wetland array is use to store all the wetlands of the programm
	 */
	private Wetland [] wetlands;
	
	//constructor
	/** 
	 * @return int
	 */
	public Control(){
		
		//init
		wetlands = new Wetland[size];
		
	}

	/**
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
	* @return un entero con la primera posicion vacia en el arreglo
	* y -1 si el arreglo esta lleno
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
	*
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
	//POR CADA WETLAND HAGO UN CICLO DE ESPECIES O DE EVENTOS PARA MOSTRARLOS

	public boolean hasWetland(){

		boolean ocupiedPosition = false;

		for(int i=0; i<size && !ocupiedPosition; i++){

			if(wetlands[i]!=null){

				ocupiedPosition = true;

			}
		}

		return ocupiedPosition;
	}

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

	public void addEventToWetland(String name, int eventType, int day, int month, int year, String host, String description, double cost){

		int pos = findWetland(name);
		if(pos!= -1){
			wetlands[pos].addEvent(eventType, day, month, year, host, description, cost);
		}
	}

	public int repeatSpecies(String name){

		int pos = findWetland(name);
		int save= 0;
		if(pos!= -1){
			save= wetlands[pos].repeatSpecie();
		}

		return save;
	}

	public void addSpecieToWetland(String name, String nameS, String cientificName, String migratory, int type){

		int pos = findWetland(name);
		if(pos!= -1){
			wetlands[pos].addSpecie(nameS, cientificName, migratory, type);
		}
	}

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

	public int maintenanceWetland(String name, int year){

		boolean flag= false;
		int count = 0;

		for(int index=0; index<size; index++){

			if(wetlands[index]!=null){
				if(wetlands[index].getName().equals(name)){
					count = wetlands[index].numMaintenance(name, year);
				}
			}
		}

		return count;
	}

	public String leastFlora(){

		int least = 100000;
		String out = "";
		int pos = -1;

		for(int i=0; i<size && wetlands[i]!=null; i++){
			int counter = 0;
			wetlands[i].lessSpecie(counter);
			if(wetlands[i].lessSpecie(counter)<least){
				least=counter;
				pos = i;
			}
		}
		out += wetlands[pos].getName();

		return out;
	}

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