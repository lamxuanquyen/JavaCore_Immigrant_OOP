package fa.training.main;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import fa.training.user.exception.CommonException;
import fa.training.utils.DateUtils;
import fa.training.utils.Validator;

public class Test {
	public static void main(String[] args){
//		String str = "gfhsgfASDGA1234454";
//
//		System.out.println(Validator.isNumAndChar(str));

//		String strDate = "10/1/2023";
//		
//		Date date = DateUtils.convertStringToUtilDate(strDate);
//		LocalDate local = DateUtils.cvrtUtilToLocalDate(date);
//		
//		Calendar cal = Calendar.getInstance();
//		Date currentDate = cal.getTime();
//		
//		if (date.after(currentDate)) {
//			System.out.println(date + " after " + currentDate);
//		}else {
//			System.out.println(date + " before " + currentDate);
//		}
//		
//		LocalDate currentDate1 = LocalDate.now();
//		System.out.println(currentDate1);
//		
//		if (local.isAfter(currentDate1) || local.isEqual(currentDate1)) {
//			System.out.println(local + " after " + currentDate1);
//		}else {
//			System.out.println(local + " before " + currentDate1);
//		}
//		
//		System.out.println(local.isEqual(currentDate1));
		
		String test = "IMfgfasjkfakfajf";
		try {
			System.out.println(Validator.isCheckFullName(test));
		} catch (CommonException e) {
			System.out.println(e.getMessage());
		}

	}
	
}