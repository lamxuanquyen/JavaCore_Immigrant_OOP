package fa.training.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fa.training.entities.LaborExport;
import fa.training.entities.OverseaStudent;
import fa.training.entities.Person;
import fa.training.entities.Traveler;
import fa.training.user.exception.CommonException;
import fa.training.utils.DateUtils;
import fa.training.utils.IOUtil;
import fa.training.utils.Validator;

public class ReadFileData {

//	public static void main(String[] args) {
//
//		List<Person> personList = readDataFromFile();
//		for (Person person : personList) {
//			person.showInfo();
//		}
//	}

	/**
	 * @author : Quyenlx1
	 * @birthday: 1990-12-25
	 * read data from file
	 * @return
	 */
	public static List<Person> readDataFromFile() {
		String path = "D:\\baitap_java\\Immigrant_OOP\\src\\data.csv";
		List<Person> list = new ArrayList<>();
		try {
			List<String> lineDataList = IOUtil.readDataInFile(path);
			int type = 0;
			String immigrantID;
			String name;
			Date birthDate;
			String passPort;
			String nationality;
			Date immigrantDate;
			String stayLength;
			String university;
			String majors;
			String company;
			String laborType;
			String stayPlace;
			double discountRate = 0d;

			ArrayList<String> idList = new ArrayList<>();
			
			for (String line : lineDataList) {				
				String[] lineData = line.split(",");
				
				if (Validator.isIntNumber(lineData[Constants.TYPE_IDX])) {
					type = Integer.parseInt(lineData[Constants.TYPE_IDX]);
				}
				
				immigrantID = lineData[Constants.IMMIGRANTID_IDX];
				if (idList.contains(immigrantID)) {
					System.out.println("Immigrant " + immigrantID + " has duplicate ID");
					continue;
				}else {
					idList.add(immigrantID);
				}
				
				name = lineData[Constants.NAME_IDX];
				
				birthDate = DateUtils.convertStringToUtilDate(lineData[Constants.BIRTHDATE_IDX]);
				if (!DateUtils.isDateBeforeCurrentDate(birthDate)) {
					System.out.println("BirthDate must be before current date!!!");
					continue;
				}
				
				passPort = lineData[Constants.PASSPORT_IDX];
				try {
					if (!Validator.isNumAndChar(passPort)) {
						throw new CommonException("Passport is invalid!!!");
					}
				} catch (CommonException e) {
					System.out.println(e.getMessage());
					continue;
				}				
				
				nationality = lineData[Constants.NATIONALITY_IDX];
				immigrantDate = DateUtils.convertStringToUtilDate(lineData[Constants.IMMIGRANTDATE_IDX]);
				stayLength = lineData[Constants.STAYLENGTH_IDX];
				if (lineData.length >= 14) {
					if (Validator.isDoubleNumber(lineData[Constants.DISCOUNTRATE_IDX])) {
						discountRate = Double.parseDouble(lineData[Constants.DISCOUNTRATE_IDX]);
					}
				}				

				switch (type) {
				case 1:
					university = lineData[Constants.UNIVERSITY_IDX];
					majors = lineData[Constants.MAJORS_IDX];
					Person dhs = new OverseaStudent(type,  immigrantID,  name,  birthDate,  passPort,
							 nationality,  immigrantDate,  stayLength,  discountRate,  university,  majors);
					
					list.add(dhs);
					break;
				case 2:
					company = lineData[Constants.COMPANY_IDX];
					laborType = lineData[Constants.LABORTYPE_IDX];
					Person xkld = new LaborExport(type,  immigrantID,  name,  birthDate,  passPort,
							 nationality,  immigrantDate,  stayLength,  discountRate,  company, laborType);
					
					list.add(xkld);
					break;
				case 3:
					company = lineData[Constants.COMPANY_IDX];
					stayPlace = lineData[Constants.STAYPLACE_IDX];
					Person nguoidulich = new Traveler(type,  immigrantID,  name,  birthDate,  passPort,
							 nationality,  immigrantDate,  stayLength,  discountRate,  stayPlace, company);
					
					list.add(nguoidulich);
					break;
				default:
					break;
				}
			}

		} catch (IOException e) {
			System.out.println("Loi doc file data");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Program have an unexpected error occurred !!!");
			e.printStackTrace();
		}
		return list;
	}
}
