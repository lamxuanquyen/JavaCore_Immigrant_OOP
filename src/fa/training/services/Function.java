package fa.training.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fa.training.entities.LaborExport;
import fa.training.entities.OverseaStudent;
import fa.training.entities.Person;
import fa.training.entities.Traveler;
import fa.training.utils.ConnectionUtil;
import fa.training.utils.DateUtils;


public class Function {
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * @author : Quyenlx1
	 * @birthday: 25-12-1990
	 * insert dữ liệu của person vào database
	 * @param person
	 */
	public static int insertToDB(List<Person> personList) {
		int numberRecords = 0;
		try(Connection con = ConnectionUtil.getConnection();) {
			
			String sql = "INSERT INTO person(type,immigrantID,name,birthDate,passPort,nationality,immigrantDate,stayLength,university,majors,company,laborType,stayPlace,discountRate) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement prstmt = con.prepareStatement(sql);
			con.setAutoCommit(false);
			
			for (Person person : personList) {
				prstmt.setInt(1, person.getType());
				prstmt.setString(2, person.getImmigrantID());
				prstmt.setString(3, person.getName());
				prstmt.setDate(4, DateUtils.convertUtilToSqlDate(person.getBirthDate()));
				prstmt.setString(5, person.getPassPort());
				prstmt.setString(6, person.getNationality());
				prstmt.setDate(7, DateUtils.convertUtilToSqlDate(person.getImmigrantDate()));
				prstmt.setString(8, person.getStayLength());
				
				prstmt.setDouble(14, person.getDiscountRate());
				
//				prstmt.setNull(9, java.sql.Types.INTEGER);
//				prstmt.setNull(8, java.sql.Types.DATE);
//				prstmt.setNull(12, java.sql.Types.TINYINT);
//				prstmt.setNull(13, java.sql.Types.VARCHAR);						
				
				if (person instanceof OverseaStudent) {
					prstmt.setString(9, ((OverseaStudent)person).getUniversity());
					prstmt.setString(10, ((OverseaStudent)person).getMajors());
					prstmt.setNull(11, java.sql.Types.VARCHAR); 
					prstmt.setNull(12, java.sql.Types.VARCHAR); 
					prstmt.setNull(13, java.sql.Types.VARCHAR);
				}
				if (person instanceof LaborExport) {
					prstmt.setNull(9, java.sql.Types.VARCHAR); 
					prstmt.setNull(10, java.sql.Types.VARCHAR); 
					prstmt.setString(11, ((LaborExport)person).getCompany());
					prstmt.setString(12, ((LaborExport)person).getLaborType());
					prstmt.setNull(13, java.sql.Types.VARCHAR);
				}
				if (person instanceof Traveler) {
					prstmt.setNull(9, java.sql.Types.VARCHAR); 
					prstmt.setNull(10, java.sql.Types.VARCHAR); 
					prstmt.setString(11, ((Traveler)person).getCompany());
					prstmt.setNull(12, java.sql.Types.VARCHAR);
					prstmt.setString(13, ((Traveler)person).getStayPlace());
				}
				
				prstmt.addBatch();				
			}
			
			int[] result = prstmt.executeBatch();
			
			con.commit();
			con.setAutoCommit(true);
			
			for (int i = 0; i < result.length; i++) {
				numberRecords += result[i];
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return numberRecords;
		}
		return numberRecords;
	}

	/**
	 * @author : Quyenlx1
	 * @birthday: 25-12-1990
	 * hiển thị thông tin của person ra ->( note: chưa xong)
	 * @param personList
	 */
	public static void showInformation(List<Person> personList) {
		for (Person person : personList) {
			if (person == null) {
				continue;
			}
			if (person instanceof OverseaStudent) {
				((OverseaStudent) person).showInfo();
				System.out.println("--------------------");
			}
			if (person instanceof LaborExport) {
				((LaborExport) person).showInfo();
				System.out.println("--------------------");
			}
			if (person instanceof Traveler) {
				((Traveler) person).showInfo();
				System.out.println("--------------------");
			}
		}
	}
	
	/**
	 * @author : Quyenlx1
	 * @birthday: 25-12-1990
	 * lấy tất cả person từ data
	 * @return
	 */
	public static List<Person> getAllPerson() {
		List<Person> personList = new ArrayList<>();
		
		String sql = "SELECT * FROM person";
		
		try(Connection con = ConnectionUtil.getConnection();) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {		
				int personType = rs.getInt("type");				
				switch (personType) {
				case 1:					
					Person dhs = new OverseaStudent();
					dhs.setType(rs.getInt("type"));
					dhs.setImmigrantID(rs.getString("immigrantID"));
					dhs.setName(rs.getString("name"));
					dhs.setBirthDate(DateUtils.convertSqlToUtilDate(rs.getDate("birthDate")));
					dhs.setPassPort(rs.getString("passPort"));
					dhs.setNationality(rs.getString("Nationality"));
					dhs.setImmigrantDate(DateUtils.convertSqlToUtilDate(rs.getDate("ImmigrantDate")));
					dhs.setStayLength(rs.getString("StayLength"));
					dhs.setDiscountRate(rs.getDouble("DiscountRate"));
										
					((OverseaStudent) dhs).setUniversity(rs.getString("university"));
					((OverseaStudent) dhs).setMajors(rs.getString("majors"));
					
					personList.add(dhs);
					
					break;
				case 2:
					Person xkld = new LaborExport();
					xkld.setType(rs.getInt("type"));
					xkld.setImmigrantID(rs.getString("immigrantID"));
					xkld.setName(rs.getString("name"));
					xkld.setBirthDate(DateUtils.convertSqlToUtilDate(rs.getDate("birthDate")));
					xkld.setPassPort(rs.getString("passPort"));
					xkld.setNationality(rs.getString("Nationality"));
					xkld.setImmigrantDate(DateUtils.convertSqlToUtilDate(rs.getDate("ImmigrantDate")));
					xkld.setStayLength(rs.getString("StayLength"));
					xkld.setDiscountRate(rs.getDouble("DiscountRate"));
										
					((LaborExport) xkld).setCompany(rs.getString("company"));
					((LaborExport) xkld).setLaborType(rs.getString("laborType"));
					
					personList.add(xkld);	
					
					break;			
				case 3:
					Person nguoiDuLich = new Traveler();
					nguoiDuLich.setType(rs.getInt("type"));
					nguoiDuLich.setImmigrantID(rs.getString("immigrantID"));
					nguoiDuLich.setName(rs.getString("name"));
					nguoiDuLich.setBirthDate(DateUtils.convertSqlToUtilDate(rs.getDate("birthDate")));
					nguoiDuLich.setPassPort(rs.getString("passPort"));
					nguoiDuLich.setNationality(rs.getString("Nationality"));
					nguoiDuLich.setImmigrantDate(DateUtils.convertSqlToUtilDate(rs.getDate("ImmigrantDate")));
					nguoiDuLich.setStayLength(rs.getString("StayLength"));
					nguoiDuLich.setDiscountRate(rs.getDouble("DiscountRate"));
										
					((Traveler) nguoiDuLich).setCompany(rs.getString("company"));
					((Traveler) nguoiDuLich).setStayPlace(rs.getString("stayPlace"));
					
					personList.add(nguoiDuLich);
					
					break;
				default:
					break;
				}				
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personList;
	}
	

	/**
	 * @author : Quyenlx1
	 * @birthday: 25-12-1990
	 * get name of all person from database
	 * @return
	 */
	public static ArrayList<String> getNameperson() {
		ArrayList<String> nameList = new ArrayList<>();
		
		String sql = "SELECT FullName FROM person";
		
		try(Connection con = ConnectionUtil.getConnection();) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				nameList.add(rs.getString("FullName"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return nameList;
	}
	
	/**
	 * @author : Quyenlx1
	 * @birthday: 25-12-1990
	 * get id of all person from database
	 * @return
	 */
	public static ArrayList<String> getIdperson() {
		ArrayList<String> idList = new ArrayList<>();
		
		String sql = "SELECT personID FROM person";
		
		try(Connection con = ConnectionUtil.getConnection();) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				idList.add(rs.getString("personID"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return idList;
	}
	
	/**
	 * @author : Quyenlx1
	 * @birthday: 25-12-1990
	 * update discountRate by id
	 * @param idString
	 * @param name
	 */
	public static int updateDiscountRate(String idString, double numDouble) {

		String sql = "UPDATE PERSON SET discountRate = ? WHERE immigrantID = ?";
		int countRowUpdate = 0;
		try(Connection con = ConnectionUtil.getConnection();) {
			PreparedStatement prstmt = con.prepareStatement(sql);
			
			prstmt.setDouble(1, numDouble);
			prstmt.setString(2, idString);
			
			countRowUpdate = prstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		return countRowUpdate;
	}
	
	/**
	 * @author : Quyenlx1
	 * @birthday: 25-12-1990
	 * delete person where passPort is null
	 * @param idString
	 * @param name
	 */
	public static int deletePerson() {

		String sql = "DELETE FROM PERSON WHERE passPort IS NULL";
		int countRowUpdate = 0;
		try(Connection con = ConnectionUtil.getConnection();) {
			PreparedStatement prstmt = con.prepareStatement(sql);		
			countRowUpdate = prstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		return countRowUpdate;
	}

}
