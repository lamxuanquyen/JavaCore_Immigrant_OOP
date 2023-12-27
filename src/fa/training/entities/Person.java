package fa.training.entities;

import java.util.Date;

public abstract class Person {
	private int type;
	private String immigrantID;
	private String name;
	private Date birthDate;
	private String passPort;
	private String nationality;
	private Date immigrantDate;
	private String stayLength;
	private double discountRate;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(int type, String immigrantID, String name, Date birthDate, String passPort, String nationality,
			Date immigrantDate, String stayLength, double discountRate) {
		super();
		this.type = type;
		this.immigrantID = immigrantID;
		this.name = name;
		this.birthDate = birthDate;
		this.passPort = passPort;
		this.nationality = nationality;
		this.immigrantDate = immigrantDate;
		this.stayLength = stayLength;
		this.discountRate = discountRate;
	}

	
	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the immigrantID
	 */
	public String getImmigrantID() {
		return immigrantID;
	}

	/**
	 * @param immigrantID the immigrantID to set
	 */
	public void setImmigrantID(String immigrantID) {
		this.immigrantID = immigrantID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the passPort
	 */
	public String getPassPort() {
		return passPort;
	}

	/**
	 * @param passPort the passPort to set
	 */
	public void setPassPort(String passPort) {
		this.passPort = passPort;
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return the immigrantDate
	 */
	public Date getImmigrantDate() {
		return immigrantDate;
	}

	/**
	 * @param immigrantDate the immigrantDate to set
	 */
	public void setImmigrantDate(Date immigrantDate) {
		this.immigrantDate = immigrantDate;
	}

	/**
	 * @return the stayLength
	 */
	public String getStayLength() {
		return stayLength;
	}

	/**
	 * @param stayLength the stayLength to set
	 */
	public void setStayLength(String stayLength) {
		this.stayLength = stayLength;
	}

	/**
	 * @return the discountRate
	 */
	public double getDiscountRate() {
		return discountRate;
	}

	/**
	 * @param discountRate the discountRate to set
	 */
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	@Override
	public String toString() {
		return "type=" + type + ", immigrantID=" + immigrantID + ", name=" + name + ", birthDate=" + birthDate
				+ ", passPort=" + passPort + ", nationality=" + nationality + ", immigrantDate=" + immigrantDate
				+ ", stayLength=" + stayLength + ", discountRate=" + discountRate + ", ";
	}

	public abstract void showInfo();	

	
	
}
