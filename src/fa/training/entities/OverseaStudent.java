package fa.training.entities;

import java.util.Date;

public class OverseaStudent extends Person {
	private String university;
	private String majors;
	
	public OverseaStudent() {
		// TODO Auto-generated constructor stub
	}

	public OverseaStudent(int type, String immigrantID, String name, Date birthDate, String passPort,
			String nationality, Date immigrantDate, String stayLength, double discountRate, String university, String majors) {
		super(type, immigrantID, name, birthDate, passPort, nationality, immigrantDate, stayLength, discountRate);
		this.university = university;
		this.majors = majors;
	}

	/**
	 * @return the university
	 */
	public String getUniversity() {
		return university;
	}

	/**
	 * @param university the university to set
	 */
	public void setUniversity(String university) {
		this.university = university;
	}

	/**
	 * @return the majors
	 */
	public String getMajors() {
		return majors;
	}

	/**
	 * @param majors the majors to set
	 */
	public void setMajors(String majors) {
		this.majors = majors;
	}
	

	@Override
	public String toString() {
		return "OverseaStudent [university=" + university + ", majors=" + majors + "]";
	}

	@Override
	public void showInfo() {
		System.out.println("OverseaStudent [" + super.toString() + "university=" + university + ", majors=" + majors + "]");
		
	}

}
