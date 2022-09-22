package edu.kh.jdbc.swstudent.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.jdbc.swstudent.vo.Student;

public class StudentView {

	private Scanner sc = new Scanner(System.in);

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

				case 2:
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
		
		System.out.print("원생 번호 >> ");
		int studentId = sc.nextInt();
		
		System.out.print("원생 이름 >> ");
		String studentName = sc.next();
		
		String studentGender;
		while(true) {
			System.out.print("원생 성별(M/F) >> ");
			studentGender = sc.next().toUpperCase();
			
			System.out.println();
			if(studentGender.equals("M") || studentGender.equals("F")) {
				break;
			} else {
				System.out.println("[M 또는 F만 입력해 주세요.]");
			}
			System.out.println();
		}
		
		System.out.print("원생 주민등록번호 >> ");
		String studentNo = sc.next();

		System.out.print("입관 일자 >> ");
		String startDate = sc.next();
		
		System.out.print("원생 띠 >> ");
		String studentBelt = sc.next();
		
		Student student = new Student(studentId, studentName, studentGender, studentNo,
				startDate, studentBelt);
		
		int result = dao.insertStudent(student);
		
		if(result > 0) {
			System.out.println("<<원생 등록 완료>>");
		} else {
			System.out.println("<<원생 등록 실패>>");
		}
		
		
		
	}

}
