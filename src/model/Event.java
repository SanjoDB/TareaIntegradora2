package model;

public class Event{
	
	/** 
	 * host String is use to store the host of the event
	 * description String is use to store the description of the event
	 */
	private String host, description;

	/** 
	 * cost double is use to store the cost of the event
	 */
	private double cost;
	
	//Relationships
	private Date date;
	private WetEvent eventType;

	//constructor
	/** 
	 * Constructor used for obj Event
	 * @param type
	 * @param host
	 * @param description
	 * @param cost
	 */
	public Event(int eventType, int day, int month, int year, String host, String description, double cost){
		
		switch(eventType){

			case 1:
				this.eventType = WetEvent.MAINTENANCE;
			break;

			case 2:
				this.eventType = WetEvent.SCHOOL_VISIT;
			break;

			case 3:
				this.eventType = WetEvent.IMPROVEMENT_ACTIVITY;
			break;

			case 4:
				this.eventType = WetEvent.CELEBRATION;
			break;

		}

		this.date = new Date(day, month, year);
		this.host = host;
		this.description = description;
		this.cost = cost;
		
	}
	
	
	/** 
	 * @return String
	 */
	//get and set
	public WetEvent getEventType(){
		
		return eventType;
		
	}

	
	/** 
	 * @param type
	 */
	public void setEventType(WetEvent eventType){
		
		this.eventType= eventType;
		
	}

	/** 
	 * @return Date
	 */
	public Date getDate(){
		
		return date;
		
	}

	
	/** 
	 * @param date
	 */
	public void setDate(Date date){
		
		this.date= date;
		
	}
	
	/** 
	 * @return String
	 */
	public String getHost(){
		
		return host;
		
	}

	
	/** 
	 * @param host
	 */
	public void setHost(String host){
		
		this.host= host;
		
	}

	
	/** 
	 * @return String
	 */
	public String getDescription(){
		
		return description;
		
	}

	
	/** 
	 * @param description
	 */
	public void setDescription(String description){
		
		this.description= description;
		
	}

	
	/** 
	 * @return double
	 */
	public double getCost(){
		
		return cost;
		
	}

	
	/** 
	 * @param cost
	 */
	public void setCost(double cost){
		
		this.cost= cost;
		
	}

	public int getYear(){

		return date.getYear();

	}

	/**
	 * Method used to show the information of an Event
	 * @return Event
	 */
	public String toString() {
		return "Event: " + "\n" + 
		"Type: " + eventType + "\n" + 
		"Date: " + date + "\n" + 
		"Host: " + host + "\n" + 
		"Description: " + description + "\n" + 
		"Cost: " + cost + "\n";
	}
}