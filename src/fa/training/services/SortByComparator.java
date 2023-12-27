package fa.training.services;

import java.util.Comparator;

import fa.training.entities.Person;

public class SortByComparator implements Comparator<Person> {
	
	@Override
	public int compare(Person o1, Person o2) {

		if (o1.getImmigrantDate().equals(o2.getImmigrantDate())) {				
			//return (int)o1.getDiscountRate() - (int)o2.getDiscountRate();
			if (o1.getDiscountRate() > o2.getDiscountRate()) {
				return 1;
			}else {
				return -1;
			}
		}		
		return o2.getImmigrantDate().compareTo(o1.getImmigrantDate());
		
	}
	
//	@Override
//	public int compare(Candidate o1, Candidate o2) {
//		// Sap xep tang dan theo name
//		// Sap xep giam dan theo type
//		// sap xep tang dan theo ngay sinh
//
//		if (o1.getFullName().equals(o2.getFullName())) {
//			if (o1.getCandidate_type() == o2.getCandidate_type()) {
//				o1.getBirthDay().compareTo(o2.getBirthDay());
//			} else if (o1.getCandidate_type() > o2.getCandidate_type()) {
//				return -1;
//			} else {
//				return 1;
//			}
//		}
//		return o1.getFullName().compareTo(o2.getFullName());
//	}
}
