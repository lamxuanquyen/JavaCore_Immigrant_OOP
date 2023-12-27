package fa.training.entities;

import java.util.Date;

public class Traveler extends Person {

	private String stayPlace;
	private String company;


	public Traveler() {
		// TODO Auto-generated constructor stub
	}

	public Traveler(int type, String immigrantID, String name, Date birthDate, String passPort, String nationality,
			Date immigrantDate, String stayLength, double discountRate, String stayPlace, String company) {
		super(type, immigrantID, name, birthDate, passPort, nationality, immigrantDate, stayLength, discountRate);
		this.stayPlace = stayPlace;
		this.company = company;
	}
	
	

	/**
	 * @return the stayPlace
	 */
	public String getStayPlace() {
		return stayPlace;
	}

	/**
	 * @param stayPlace the stayPlace to set
	 */
	public void setStayPlace(String stayPlace) {
		this.stayPlace = stayPlace;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	
	

	@Override
	public String toString() {
		return "Traveler [stayPlace=" + stayPlace + ", company=" + company + "]";
	}

	@Override
	public void showInfo() {
		System.out.println("Traveler [" + super.toString()+ "stayPlace=" + stayPlace + ", company=" + company + "]");

	}
}
