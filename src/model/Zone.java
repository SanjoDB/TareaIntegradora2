package model;

public class Zone{
	
	/** 
	 * type String is use to store the type of zone
	 * nameUbication String is use to store the name of the ubication of the zone
	 */
	private String type, nameUbication;
	
	//constructor
	/** 
	 * Constructor used for obj Zone
	 * @param type
	 * @param nameUbication
	 */
	public Zone(String type, String nameUbication){
		
		this.type = type;
		this.nameUbication = nameUbication;
		
	}

	
	/** 
	 * @return String
	 */
	//get and set
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
	public String getNameUbication(){
		
		return nameUbication;
		
	}

	
	/** 
	 * @param nameUbication
	 */
	public void setNameUbication(String nameUbication){
		
		this.nameUbication= nameUbication;
		
	}

	public String toString() {
		return "Type of Zone: " + type+ "\n" + "Name of the Ubication: " + nameUbication;
	}
}