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

				System.out.print("\n메뉴 선택 >> ");
				input = sc.nextInt();
				sc.nextLine();

				System.out.println();
				switch (input) {
				case 1: insertStudent();
					break;

				case 2: selectAll();
					break;

				case 3: selectName();
					break;

				case 4: updateStudent();
					break;

				case 5: secession();
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
				System.out.println("원생 번호 | 이름 | 성별 | 주민등록번호 | 입관일자 | 띠 ");
				System.out.println("-------------------------------------------------");
				for( Student student : studentList ) {
					System.out.printf("%d | %s | %s | %s | %s | %s \n", 
							student.getStudentId(),
							student.getStudentName(),
							student.getStudentGender(),
							student.getStudentNo(),
							student.getStartDate(),
							student.getStudentBelt());
				}
				System.out.println();
			}
	
		} catch (Exception e) {
			System.out.println("\n<<원생 목록 조회 중 예외 발생>>\n");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 이름이 일치하는 원생 조회
	 */
	private void selectName() {
		System.out.println("\n[이름이 일치하는 원생 조회]\n");
		
		try {
			System.out.print("원생 이름 입력 : ");
			String studentName = sc.next();
			
			Student student = service.selectName(studentName);
			
			if(student != null) {
				System.out.println("원생 번호 : " + student.getStudentId());
				System.out.println("원생 이름 : " + student.getStudentName());
				System.out.println("성별 : " + student.getStudentGender());
				System.out.println("주민등록번호 : " + student.getStudentNo());
				System.out.println("입관 일자 : " + student.getStartDate());
				System.out.println("띠 : " + student.getStudentBelt());
			} else {
				System.out.println("\n[일치하는 원생이 없습니다.]\n");
			}
			
		} catch (Exception e) {
			System.out.println("\n<<이름이 일치하는 원생 조회 중 예외 발생>>\n");
			e.printStackTrace();
		}

		
	}
	
	
	/**
	 * 원생 정보 수정(이름, 띠)
	 */
	private void updateStudent() {
		System.out.println("\n[원생 정보 수정]\n");
		
		try {
			System.out.print("수정할 원생 이름 입력 : ");
			String studentName = sc.next();
			
			System.out.print("변경할 번호 : ");
			int studentId = sc.nextInt();
			
			System.out.print("변경할 띠 : ");
			String studentBelt = sc.next();
			
			Student student = new Student();
			student.setStudentName(studentName);
			student.setStudentId(studentId);
			student.setStudentBelt(studentBelt);
			
			int result = service.updateStudent(student);
			
			if(result > 0) {
				System.out.println("\n[원생 정보가 수정되었습니다.]\n");
			} else {
				System.out.println("\n[수정 실패]\n");
			}
			
			
		} catch (Exception e) {
			System.out.println("\n<<원생 정보 수정 중 예외가 발생했습니다.>>\n");
		}
	}
	
	
	/**
	 * 원생 퇴원
	 */
	private void secession() {
		System.out.println("\n[원생 퇴원]\n");
		
		try {
			System.out.print("탈퇴할 회원 이름 입력 : ");
			String studentName = sc.next();
			
			while(true) {
				System.out.print("정말 탈퇴하시겠습니까?(Y/N) : ");
				char ch = sc.next().toUpperCase().charAt(0);
				
				if(ch == 'Y') {
					int result = service.secession(studentName);
					
					if(result > 0) {
						System.out.println("\n[탈퇴되었습니다.]\n");
						
						input = 0;
					} else {
						System.out.println("\n[실패하였습니다.]\n");
					}
					break;
				} else if(ch == 'N') {
					System.out.println("\n[취소되었습니다.]\n");
					break;
				} else {
					System.out.println("\n[Y 또는 N을 입력해주세요.]\n");
				}
			}
			
		} catch (Exception e) {
			System.out.println("\n<<회원 탈퇴 중 예외 발생>>\n");
			e.printStackTrace();
		}
		
		
	}
}
