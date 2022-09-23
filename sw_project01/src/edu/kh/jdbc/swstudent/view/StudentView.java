package edu.kh.jdbc.swstudent.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.swstudent.dao.StudentDAO;
import edu.kh.jdbc.swstudent.service.StudentService;
import edu.kh.jdbc.swstudent.vo.Student;

public class StudentView {

	private Scanner sc = new Scanner(System.in);
	
	private StudentService service = new StudentService();

	private int input = -1;

	public void studentMenu() {

		do {

			try {
				System.out.println("\n***** 원생 관리 *****\n");
				System.out.println("1. 새로운 원생 추가");
				System.out.println("2. 원생 목록 전체 조회");
				System.out.println("3. 원생 조회(이름 입력)");
				System.out.println("4. 원생 정보 수정");
				System.out.println("5. 원생 퇴원");
				System.out.println("0. 메인 화면");
				System.out.println("99. 프로그램 종료");

				System.out.print("\n메뉴 선택 >> \n");
				input = sc.nextInt();
				sc.nextLine();

				System.out.println();
				switch (input) {
				case 1: insertStudent();
					break;

				case 2: selectAll();
					break;

				case 3:
					break;

				case 4:
					break;

				case 5:
					break;

				case 0:
					System.out.println("[메인 메뉴로 이동합니다.]");
					break;

				case 99:
					System.out.println("프로그램을 종료합니다.");
					input = 0;
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("\n<<입력 형식이 올바르지 않습니다.>>\n");
				sc.nextLine();
			}

		} while (input != 0);

	}

	/**
	 * 새로운 원생 추가
	 */
	private void insertStudent() {
		System.out.println("\n[새로운 원생 추가]\n");
		
		try {
			System.out.print("원생 번호 >> ");
			int studentId = sc.nextInt();
			
			System.out.print("원생 이름 >> ");
			String studentName = sc.next();
			
			String studentGender;
			while(true) {
				System.out.print("원생 성별(M/F) >> ");
				studentGender = sc.next().toUpperCase();
				
				if(studentGender.equals("M") || studentGender.equals("F")) {
					break;
				} else {
					System.out.println("[M 또는 F만 입력해 주세요.]");
				}
			}
			
			System.out.print("원생 주민등록번호 >> ");
			String studentNo = sc.next();

			System.out.print("입관 일자 >> ");
			String startDate = sc.next();
			
			System.out.print("원생 띠 >> ");
			String studentBelt = sc.next();
			
			Student student = new Student(studentId, studentName, studentGender, studentNo,
					startDate, studentBelt);
			
			int result = service.insertStudent(student);
			
			// 서비스 처리 결과에 따른 출력 화면 제어
			System.out.println();
			if(result > 0) {
				System.out.println("<<원생 등록 완료>>");
			} else {
				System.out.println("<<원생 등록 실패>>");
			}
			System.out.println();
		} catch (Exception e) {
			System.out.println("\n<<원생 등록 중 예외 발생>>\n");
			e.printStackTrace();
		}	
	}

	/**
	 * 원생 목록 전체 조회
	 */
	private void selectAll() {
		System.out.println("\n[원생 목록 전체 조회]\n");
		
		try {
			List<Student> studentList = service.selectAll();
			
			if(studentList.isEmpty()) {
				System.out.println("\n[조회 결과가 없습니다.]\n");
			} else {
				System.out.println("원생 번호 | 이름 | 성별 | 주민등록번호 | 입관일자 | 띠");
				System.out.println("-------------------------------------------------");
				for( Student student : studentList ) {
					System.out.printf("%d | %s | %s | %s | %s | %s", 
							student.getStudentId(),
							student.getStudentName(),
							student.getStudentGender(),
							student.getStudentNo(),
							student.getStartDate(),
							student.getStudentBelt());
				}
			}
	
		} catch (Exception e) {
			System.out.println("\n<<원생 목록 조회 중 예외 발생>>\n");
			e.printStackTrace();
		}
	}
	
	
}
