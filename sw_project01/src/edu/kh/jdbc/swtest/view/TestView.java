package edu.kh.jdbc.swtest.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.jdbc.swmaster.vo.SwMaster;
import edu.kh.jdbc.swtest.service.TestService;
import edu.kh.jdbc.swtest.vo.SwTest;

public class TestView {

	private Scanner sc = new Scanner(System.in);

	private TestService service = new TestService();

	private int input = -1;

	private SwMaster loginMaster = null;

	public void testMenu(SwMaster loginMaster) {

		this.loginMaster = loginMaster;

		do {
			try {
				System.out.println("\n***** 심사 관리 *****\n");
				System.out.println("1. 심사 정보 조회(날짜 입력)");
				System.out.println("2. 띠 별 조회");
				System.out.println("3. 심사 참석 여부 조회");
				System.out.println("4. 심사 참석자 중 미납자 조회");
				System.out.println("5. 지난 심사 정보 조회");
				System.out.println("0. 메인 화면");
				System.out.println("99. 프로그램 종료");

				System.out.print("\n메뉴 선택 : ");
				input = sc.nextInt();
				sc.nextLine();

				System.out.println();
				switch (input) {
				case 1:
					selectTestInfo();
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
	 * 심사 정보 조회
	 */
	private void selectTestInfo() {
		System.out.println("[심사 정보 조회]");
		
		try {
			System.out.println("조회 원하는 날짜 입력(월까지만) : ");
			String testDate = sc.next();
			
			SwTest test = service.selectTestInfo(testDate);
			
			if(test != null) {
				System.out.println("심사 이름 : " + test.getTestName());
				System.out.println("심사 참석 인원수 : " + test.getTestCount());
			} else {
				System.out.println("\n[일치하는 심사 정보가 없습니다.]\n");
			}
	
		} catch (Exception e) {
			System.out.println("\n<<심사 정보 조회 중 예외 발생>>\n");
			e.printStackTrace();
		}
		
		
	}
}
