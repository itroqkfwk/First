import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.StudentDAO;
import com.dao.StudentGradeDAO;
import com.dto.StudentDTO;
import com.dto.StudentGradeDTO;
import com.service.StudentService;
import com.service.StudentServiceImpl;

public class StudentMain {

	public static void main(String[] args) {

		StudentService service = new StudentServiceImpl();
		service.setDao(new StudentDAO());
		service.setDao2(new StudentGradeDAO());

		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		while (true) {
			System.out.println("*********************************");
			System.out.println("\t[학생 정보 관리 메뉴]");
			System.out.println("*********************************");
			System.out.println("1. 전체 학생 목록");
			System.out.println("2. 학생 이름 검색");
			System.out.println("3. 학생 입학년도 범위 검색 (예> 2000부터 2003년까지");
			System.out.println("4. 학생 학번으로 다중 검색 (쉼표 구분자)");
			System.out.println("5. 학생 휴학 일괄수정");
			System.out.println("6. 학과 정원 일괄수정");
			System.out.println("7. 학생 학점 검색");
			System.out.println("8. 전체 학생 목록-페이징");
			System.out.println("0. 종료");
			System.out.println("*********************************");
			System.out.println("메뉴 입력 => ");
			String input_num = scan.next();
			if ("1".equals(input_num)) {
				List<StudentDTO> list = service.findAll();
				System.out.println("============================================");
				System.out.println("학번 \t 이름 \t 주민번호 \t 주소 \t 입학년도 \t 휴학여부");
				System.out.println("--------------------------------------------");
				for (StudentDTO tb_student : list) {
					String ssn = String.valueOf(tb_student.getStussn());
					String ssn2 = ssn.substring(0, 8) + "******";
					String address = tb_student.getStuAddress();
					if (address == null) {
						address = "***주소 미상***";
					} else if (address.length() > 10) {
						address = address.substring(0, 10) + "...";
					}
					String entDateStr = tb_student.getEntDate();
					SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date entDate = null;
					try {
						entDate = sdfInput.parse(entDateStr); 
					} catch (ParseException e) {
						e.printStackTrace(); 
					}
					String fDate = sdf.format(entDate);
					System.out.printf("%s\t %s\t %s\t %s\t %s\t %c\t \n", tb_student.getStuNo(), tb_student.getStuName(), ssn2,
							address, fDate, tb_student.getAbsyn());
				}
				System.out.printf("전체 학생 수: %d 명\n", list.size());
			}else if ("2".equals(input_num)) {
				System.out.println("검색할 학생명을 입력하시오 =>");
				String student_name = scan.next();
				List<StudentDTO> list = service.findName(student_name);
				System.out.println("============================================");
				System.out.println("학번 \t 이름 \t 주민번호 \t 주소 \t 입학년도 \t 휴학여부");
				System.out.println("--------------------------------------------");
				for (StudentDTO tb_student : list) {
					String ssn = String.valueOf(tb_student.getStussn());
					String ssn2 = ssn.substring(0, 8) + "******";
					String address = tb_student.getStuAddress();
					if (address == null) {
						address = "***주소 미상***";
					} else if (address.length() > 10) {
						address = address.substring(0, 10) + "...";
					}
					String entDateStr = tb_student.getEntDate();
					SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date entDate = null;
					try {
						entDate = sdfInput.parse(entDateStr); 
					} catch (ParseException e) {
						e.printStackTrace(); 
					}
					String fDate = sdf.format(entDate);
					System.out.printf("%s\t %s\t %s\t %s\t %s\t %c\t \n", tb_student.getStuNo(), tb_student.getStuName(), ssn2,
							address, fDate, tb_student.getAbsyn());
				}
				System.out.printf("총 학생 수: %d 명\n", list.size());
				
			}else if ("3".equals(input_num)) {
				System.out.println("시작 입학년도 입력하시오 =>");
				String startYear = scan.next();
				System.out.println("끝 입학년도 입력하시오 =>");
				String endYear = scan.next();
				List<StudentDTO> list = service.findYear(startYear, endYear);
				System.out.println("============================================");
				System.out.println("학번 \t 이름 \t 주민번호 \t 주소 \t 입학년도 \t 휴학여부");
				System.out.println("--------------------------------------------");
				for (StudentDTO tb_student : list) {
					String ssn = String.valueOf(tb_student.getStussn());
					String ssn2 = ssn.substring(0, 8) + "******";
					String address = tb_student.getStuAddress();
					if (address == null) {
						address = "***주소 미상***";
					} else if (address.length() > 10) {
						address = address.substring(0, 10) + "...";
					}
					String entDateStr = tb_student.getEntDate();
					SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date entDate = null;
					try {
						entDate = sdfInput.parse(entDateStr); 
					} catch (ParseException e) {
						e.printStackTrace(); 
					}
					String fDate = sdf.format(entDate);
					System.out.printf("%s\t %s\t %s\t %s\t %s\t %c\t \n", tb_student.getStuNo(), tb_student.getStuName(), ssn2,
							address, fDate, tb_student.getAbsyn());
				}
				System.out.printf("총 학생 수: %d 명\n", list.size());
				
			}else if ("4".equals(input_num)) {
				System.out.println("검색할 학생의 학번을 입력하시오 =>");
				String studentNo = scan.next();
				List<String> studentNoList = Arrays.asList(studentNo.split(","));
				List<StudentDTO> list = service.findNo(studentNoList);
				System.out.println("============================================");
				System.out.println("학번 \t 이름 \t 주민번호 \t 주소 \t 입학년도 \t 휴학여부");
				System.out.println("--------------------------------------------");
				for (StudentDTO tb_student : list) {
					String ssn = String.valueOf(tb_student.getStussn());
					String ssn2 = ssn.substring(0, 8) + "******";
					String address = tb_student.getStuAddress();
					if (address == null) {
						address = "***주소 미상***";
					} else if (address.length() > 10) {
						address = address.substring(0, 10) + "...";
					}
					String entDateStr = tb_student.getEntDate();
					SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date entDate = null;
					try {
						entDate = sdfInput.parse(entDateStr); 
					} catch (ParseException e) {
						e.printStackTrace(); 
					}
					String fDate = sdf.format(entDate);
					System.out.printf("%s\t %s\t %s\t %s\t %s\t %c\t \n", tb_student.getStuNo(), tb_student.getStuName(), ssn2,
							address, fDate, tb_student.getAbsyn());
				}
				System.out.printf("총 학생 수: %d 명\n", list.size());
			}else if ("5".equals(input_num)) {
				System.out.println("수정할 학생의 학번을 입력하시오 =>");
			    String studentNos = scan.next();
			    List<String> studentNoList = Arrays.asList(studentNos.split(",")); 
			    SqlSession session = MySqlSessionFactory.getSession();
			    HashMap<String, Object> params = new HashMap<>();
			    params.put("studentNos", studentNoList); 
			    int updatedCount = service.update(params); 
			    System.out.printf("총 변경된 학생수: %d 명\n", updatedCount);
			}else if ("6".equals(input_num)) {
				int updatedCount = service.updateCapacity();
                System.out.printf("총 변경된 학생수: %d 명\n", updatedCount);
			}else if ("7".equals(input_num)) {
				System.out.print("학생의 학번을 입력하시오 =>");
                String studentNo = scan.next();
                List<StudentGradeDTO> grades = service.getStudentGrades(studentNo);
                System.out.println("============================================");
                System.out.println("학기 \t 학번 \t 이름 \t 과목명 \t 점수 \t 학점");
                System.out.println("--------------------------------------------");
                for (StudentGradeDTO grade : grades) {
                    System.out.printf("%s\t %s\t %s\t %s\t %.2f\t %s 학점\n", grade.getTermNo(), grade.getTermNo(), grade.getStudentName(),
                            grade.getClassName(), grade.getPoint(), grade.getGrade());
                }
			}else if ("8".equals(input_num)) {
			    System.out.println("페이지당 보여줄 레코드 갯수를 입력하시오 =>");
			    int pageSize = scan.nextInt();  
			    int currentPage = 1; 
			    List<StudentDTO> allStudents = service.findAll();  

			    int totalRecords = allStudents.size();  
			    int totalPages = (int) Math.ceil((double) totalRecords / pageSize);  

			    while (true) {
			        int startIndex = (currentPage - 1) * pageSize;
			        int endIndex = Math.min(startIndex + pageSize, totalRecords);
			        List<StudentDTO> currentPageStudents = allStudents.subList(startIndex, endIndex);

			        System.out.println("============================================");
			        System.out.println("학번 \t 이름 \t 주민번호 \t 주소 \t 입학년도 \t 휴학여부");
			        System.out.println("--------------------------------------------");
			        for (StudentDTO student : currentPageStudents) {
			            String ssn = String.valueOf(student.getStussn());
			            String ssn2 = ssn.substring(0, 8) + "******";
			            String address = student.getStuAddress();
			            if (address == null) {
			                address = "***주소 미상***";
			            } else if (address.length() > 10) {
			                address = address.substring(0, 10) + "...";
			            }
			            String entDateStr = student.getEntDate();
			            SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd");
			            java.util.Date entDate = null;
			            try {
			                entDate = sdfInput.parse(entDateStr);
			            } catch (ParseException e) {
			                e.printStackTrace();
			            }
			            String fDate = sdf.format(entDate);
			            System.out.printf("%s\t %s\t %s\t %s\t %s\t %c\t \n", student.getStuNo(), student.getStuName(), ssn2,
			                    address, fDate, student.getAbsyn());
			        }
			        System.out.printf("총 학생 수: %d 명\n", totalRecords);
			        System.out.printf("페이지 %d/%d\n", currentPage, totalPages);

			        System.out.println("N: 다음 페이지, B: 이전 페이지, Q: 메인 화면");
			        String navigationInput = scan.next();

			        if ("N".equalsIgnoreCase(navigationInput)) {
			            if (currentPage < totalPages) {
			                currentPage++;
			            } else {
			            }
			        } else if ("B".equalsIgnoreCase(navigationInput)) {
			            if (currentPage > 1) {
			                currentPage--;
			            } else {
			            }
			        } else if ("Q".equalsIgnoreCase(navigationInput)) {
			            break; 
			        } 
			    }
			} else {
				scan.close();
				System.out.println("프로그램 종료");
			}

		} // end while

	}// end main

}// end class
