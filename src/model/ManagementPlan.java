package model;

public class ManagementPlan{
	
	/** 
	 * restoragePercentage double is use to store the percentage of the restorage of the wetland
	 * conservationPercentage double is use to store the percentage of the conservation of the wetland
	 */
	private double restoragePercentage, conservationPercentage;
	
	//constructor
	/** 
	 * Constructor used for obj ManagementPlan
	 * @param restoragePercentage
	 * @param conservationPercentage
	 */
	public ManagementPlan(double restoragePercentage, double conservationPercentage){
		
		this.restoragePercentage = restoragePercentage;
		this.conservationPercentage = conservationPercentage;
		
	}

	
	/** 
	 * @return double
	 */
	//get and set
	public double getRestoragePercentage(){
		
		return restoragePercentage;
		
	}

	
	/** 
	 * @param restoragePercentage
	 */
	public void setRestoragePercentage(double restoragePercentage){
		
		this.restoragePercentage= restoragePercentage;
		
	}

	
	/** 
	 * @return double
	 */
	public double getConservationPercentage(){
		
		return conservationPercentage;
		
	}

	
	/** 
	 * @param conservationPercentage
	 */
	public void setConservationPercentage(double conservationPercentage){
		
		this.conservationPercentage= conservationPercentage;
		
	}

	public String toString() {
		return "Percentage of restorage: " + restoragePercentage + "%" + "\n" + "Percentage of conservation: " + conservationPercentage + "%";
	}
}