package model;

public class Specie{
	
	/** 
	 * name String is use to store the name of the specie
	 * cientificName String is use to store the cientific name of the specie
	 * type String is use to store the type of the specie
	 */
	private String name, cientificName;

	/** 
	 * migratory boolean is use to check if the specie is migratory
	 */
	private String migratory;

	/** 
	 * numFauna int is use to store the name of the specie
	 * numFlora int is use to store the cientific name of the specie
	 */
	//private int numFauna, numFlora;

	//Relationships
	private Kind type;
	
	/** 
	 * Constructor used for obj Specie
	 * @param name
	 * @param cientificName
	 * @param type
	 * @param migratory
	 */
	//constructor
	public Specie(String name, String cientificName, String migratory, int type){
		
		this.name = name;
		this.cientificName = cientificName;
		this.migratory = migratory;

		switch(type){

			case 1:
				this.type = Kind.TERRESTRIAL_FLORA;
			break;

			case 2:
				this.type = Kind.AQUATIC_FLORA;
			break;

			case 3:
				this.type = Kind.BIRD;
			break;

			case 4:
				this.type = Kind.MAMMAL;
			break;

			case 5:
				this.type = Kind.AQUATIC;
			break;

		}
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
	public String getCientificName(){
		
		return cientificName;
		
	}

	
	/** 
	 * @param cientificName
	 */
	public void setCientificName(String cientificName){
		
		this.cientificName= cientificName;
		
	}

	
	/** 
	 * @return String
	 */
	public Kind getType(){
		
		return type;
		
	}

	
	/** 
	 * @param type
	 */
	public void setType(Kind type){
		
		this.type= type;
		
	}

	
	/** 
	 * @return boolean
	 */
	public String getMigratory(){
		
		return migratory;
		
	}

	
	/** 
	 * @param migratory
	 */
	public void setMigratory(String migratory){
		
		this.migratory= migratory;
		
	}

	public String toString() {
		return "Specie: " + "\n" + 
		"Name: " + name + "\n" + 
		"Cientific name: " + cientificName + "\n" + 
		"Type: " + type + "\n" + 
		"Is the Specie migratory? " + migratory + "\n";
	}
}