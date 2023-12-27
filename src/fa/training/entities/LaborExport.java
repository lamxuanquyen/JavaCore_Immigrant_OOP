package fa.training.entities;

import java.util.Date;

public class LaborExport extends Person {

	private String company;
	private String laborType;
	
	public LaborExport() {
		// TODO Auto-generated constructor stub
	}

	
	public LaborExport(int type, String immigrantID, String name, Date birthDate, String passPort, String nationality,
			Date immigrantDate, String stayLength, double discountRate, String company, String laborType) {
		super(type, immigrantID, name, birthDate, passPort, nationality, immigrantDate, stayLength, discountRate);
		this.company = company;
		this.laborType = laborType;
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


	/**
	 * @return the laborType
	 */
	public String getLaborType() {
		return laborType;
	}


	/**
	 * @param laborType the laborType to set
	 */
	public void setLaborType(String laborType) {
		this.laborType = laborType;
	}

	

	@Override
	public String toString() {
		return "LaborExport [company=" + company + ", laborType=" + laborType + "]";
	}


	@Override
	public void showInfo() {
		System.out.println("LaborExport [" + super.toString() + "company=" + company + ", laborType=" + laborType + "]");
	}
}
