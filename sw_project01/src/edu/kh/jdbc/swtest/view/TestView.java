package edu.kh.jdbc.swtest.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.swmaster.vo.SwMaster;
import edu.kh.jdbc.swstudent.vo.Student;
import edu.kh.jdbc.swtest.service.TestService;
import edu.kh.jdbc.swtest.vo.SwTest;

public class TestView {

	private Scanner sc = new Scanner(System.in);

	private TestService service = new TestService();

	private int input = -1;
	
	public void testMenu() {

		do {
			try {
				System.out.println("\n***** 심사 관리 *****\n");
				System.out.println("1. 심사 이름별 원생 조회");
				System.out.println("2. 심사비 납부");
				System.out.println("3. 심사비 미납자 목록 조회");
				System.out.println("0. 메인 화면");
				System.out.println("99. 프로그램 종료");

				System.out.print("\n메뉴 선택 : ");
				input = sc.nextInt();
				sc.nextLine();

				System.out.println();
				switch (input) {
				case 1:
					selectBelt();
					break;

				case 2: 
					testPay();
					break;

				case 3:
					testNoPay();
					break;

				case 0:
					System.out.println("[메인 메뉴로 이동합니다.]");
					break;

				case 99:
					System.out.println("[프로그램을 종료합니다.]");
					input = 0;
					break;
				default: System.out.println("메뉴에 작성된 번호만 입력해주세요.");
				}
				
				System.out.println();

			} catch (InputMismatchException e) {
				System.out.println("\n<<입력 형식이 올바르지 않습니다.>>\n");
				sc.nextLine();
			}

		} while (input != 0);

	}	



	/**
	 * 심사 이름별 원생 목록 조회
	 */
	private void selectBelt() {
		System.out.println("[심사 이름별 원생 목록 조회]");
		
		try {
			System.out.print("심사 이름 입력 : ");
			String testName = sc.next();
			
			List<SwTest> testList = service.selectName(testName);
			
			if(testList.isEmpty()) {
				System.out.println("일치하는 원생이 없습니다.");
			} else {
				System.out.println("심사 이름 | 심사 날짜 | 원생 이름 | 원생 띠 | 입관 일자 | 퇴원 여부");
				System.out.println("----------------------------------------------------------");
				
				for(SwTest test : testList) {
					System.out.printf("%s | %s | %s | %s | %s | %s \n",
									test.getTestName(),
									test.getTestDate(),
									test.getStudentName(),
									test.getStudentBelt(),
									test.getStartDate(),
									test.getStudentSecession());
				}
				System.out.println();
			}

		} catch (Exception e) {
			System.out.println("<<심사 이름별 원생 목록 조회 중 예외 발생>>");
			e.printStackTrace();
		}
		
	}
	
	
	
	/**
	 * 심사비 납부
	 */
	private void testPay() {
		System.out.println("\n[심사비 납부]\n");
		
		try {
			System.out.print("원생 번호 입력 : ");
			int studentNo = sc.nextInt();
			
			System.out.print("심사 이름 입력 : ");
			String testName = sc.next();
			
			int result = service.testPay(studentNo, testName);
			
			if(result > 0) {
				System.out.println("***** 심사비 납부 완료 *****");
			} else {
				System.out.println("***** 심사비 납부 실패 *****");
			}

		} catch (Exception e) {
			System.out.println("\n<<심사비 납부 중 예외 발생>>\n");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 심사비 미납자 목록 조회
	 */
	private void testNoPay() {
		System.out.println("\n[심사비 미납자 목록 조회]\n");
		
		try {
			System.out.print("심사 이름 입력 : ");
			String testName = sc.next();
			
			List<SwTest> testList2 = service.testNoPay(testName);
			
			if(testList2.isEmpty()) {
				System.out.println("미납자가 없습니다.");
			} else {
				System.out.println("심사 이름 | 심사 날짜 | 원생 이름 |");
				System.out.println("--------------------------------");
				
				for(SwTest test : testList2) {
					System.out.printf("%s | %s | %s  \n",
									test.getTestName(),
									test.getTestDate(),
									test.getStudentName());
				}
				System.out.println();
			}

		} catch (Exception e) {
			System.out.println("<<심사비 미납자 목록 조회 중 예외 발생>>");
			e.printStackTrace();
		}

	}
	
	
}
