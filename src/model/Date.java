package model;

public class Date{
	
	/** 
	 * day String is use to store the day of a date
	 * month String is use to store the month of a date
	 * year String is use to store the year of a date
	 */
	private int day, month, year;
	
	/** 
	 * Constructor used for obj Date
	 * @param pDay
	 * @param pMonth
	 * @param pYear
	 */
	public Date(int pDay, int pMonth, int pYear){
		
		day= pDay;
		month= pMonth;
		year= pYear;
		
	}
	
	
	/** 
	 * @return int
	 */
	public int getDay(){
		
		return day;
		
	}
	
	
	/** 
	 * @return int
	 */
	public int getMonth(){
		
		return month;
		
	}
	
	
	/** 
	 * @return int
	 */
	public int getYear(){
		
		return year;
		
	}
	
	
	/** 
	 * @param pDay
	 */
	public void setDay(int pDay){
		
		day= pDay;
		
	}
	
	
	/** 
	 * @param pMonth
	 */
	public void setMonth(int pMonth){
		
		month= pMonth;
		
	}
	
	
	/** 
	 * @param pYear
	 */
	public void setYear(int pYear){
		
		year= pYear;
		
	}
	
	public String toString() {
		return day + "/" + month + "/" + year;
	}
}