package fa.training.main;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import fa.training.entities.Person;
import fa.training.services.Function;
import fa.training.services.ReadFileData;
import fa.training.services.SortByComparator;

public class Management {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {


		LOOP: do {
			System.out.println("Moi chon chuc nang");
			System.out.println("1/ them thong tin person");
			System.out.println("2/ hien thi toan bo person");
			System.out.println("3/ Cập nhật tỷ lệ giảm giá ưu đãi ");
			System.out.println("4/ delete person ");
			System.out.println("5/ get all person after update and sort");
			System.out.println("6/ ");		
			System.out.println("7/ ");
			System.out.println("8/ Thoat vong lap");

			int choice;
			try {
				choice = Integer.parseInt(sc.nextLine().trim());
			} catch (NumberFormatException nfe) {
				System.out.println("Invalid number. Please enter again!");
				continue;
			}
			
			List<Person> personList = ReadFileData.readDataFromFile();

			switch (choice) {
			case 1:
				System.out.println("----- nhap thong tin person -----");				
				int countResult = Function.insertToDB(personList);
				System.out.println("Số lượng bản ghi đã được chèn vào bảng la:" + countResult);
				break;
			case 2:
				System.out.println("----- Thong Tin Toan Bo person ----");
				Function.showInformation(personList);
				
				break;
			case 3:
				System.out.println(" Cập nhật tỷ lệ giảm giá ưu đãi");
				Random random = new Random();
				int randomNumber;
				for (Person person : personList) {
					randomNumber = random.nextInt(1,31);
					
					if (person.getType() == 1 && randomNumber <= 30) {
						Function.updateDiscountRate(person.getImmigrantID(), (double)randomNumber);
					}
					if (person.getType() == 2 && randomNumber <= 20) {
						Function.updateDiscountRate(person.getImmigrantID(), (double)randomNumber);
					}
					if (person.getType() == 3 && randomNumber <= 10) {
						Function.updateDiscountRate(person.getImmigrantID(), (double)randomNumber);
					}
				}
				
				
				
				break;
			case 4:
				System.out.println("delete person where passport is null");
				int count = Function.deletePerson();
				System.out.println("so record duoc xoa la: " + count);
				break;
			case 5:
				System.out.println("get all person after update and sort");
			
				List<Person> allPersonList = Function.getAllPerson();
//				Collections.sort(allPersonList, new SortByComparator());
				
				Collections.sort(allPersonList, Comparator.comparing(Person::getImmigrantDate,Comparator.reverseOrder())
						.thenComparingDouble(Person::getDiscountRate));
				Function.showInformation(allPersonList);
				
				break;
			case 6:
				System.out.println(" ");
		
				
				break;
			case 7:
				System.out.println(" ");
			
				break;
			case 8:
				System.out.println("Hẹn gặp lại");
				break LOOP;
			default:
				System.out.println("Bạn nhập không hợp lệ! Vui lòng nhập lại!");
				break;
			}
		} while (true);
	}


}
