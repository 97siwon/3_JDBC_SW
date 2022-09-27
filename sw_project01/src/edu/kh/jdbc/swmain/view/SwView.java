package edu.kh.jdbc.swmain.view;

import java.util.Scanner;

import edu.kh.jdbc.swmain.service.SwService;
import edu.kh.jdbc.swmaster.view.MasterView;
import edu.kh.jdbc.swmaster.vo.SwMaster;
import edu.kh.jdbc.swstudent.view.StudentView;
import edu.kh.jdbc.swtest.view.TestView;

public class SwView {

	private Scanner sc = new Scanner(System.in);

	private SwService service = new SwService();

	public static SwMaster loginMaster = null;
	// 로그인 X == null
	// 로그인 O != null

	private StudentView studentview = new StudentView();
	private MasterView masterView = new MasterView(); 
	private TestView testView = new TestView();

	public void mainMenu() {

		int input = -1;

		do {

			try {
				// 로그인 X 화면
				if (loginMaster == null) {
					System.out.println("\n----- 도장 관리 프로그램 -----\n");
					System.out.println("1. 로그인");
					System.out.println("2. 회원 가입");
					System.out.println("0. 프로그램 종료");

					System.out.print("메뉴 선택 : ");

					input = sc.nextInt();
					sc.nextLine();
					System.out.println();

					switch (input) {
					case 1:
						login();
						break; // 로그인
					case 2:
						signUp();
						break;
					case 0:
						System.out.println("프로그램 종료");
						break;
					default:
						System.out.println("메뉴에 작성된 번호만 입력해주세요.");

					}

				} else {
					System.out.println("1. 원생 관리");
					System.out.println("2. 심사 관리");
					System.out.println("3. 회원 기능");
					System.out.println("0. 로그아웃");
					System.out.println("99. 프로그램 종료");

					System.out.print("메뉴 선택 >> ");
					input = sc.nextInt();

					System.out.println();

					switch (input) {
					case 1:
						studentview.studentMenu();
						break;
					case 2: testView.testMenu(loginMaster);
						break;
					case 3:
						masterView.masterMenu(loginMaster);
						break;
					case 0:
						loginMaster = null;
						System.out.println("\n[로그아웃 되었습니다.]\n");
						
						input = -1;
						break;
					case 99:
						System.out.println("프로그램 종료");
						input = 0;
						break;
					default:
						System.out.println("메뉴에 작성된 번호만 입력해주세요.");

					}
				}

			} catch (Exception e) {
				System.out.println("\n<<입력 형식이 올바르지 않습니다.>>\n");
				sc.nextLine();
			}

		} while (input != 0);
	}

	private void signUp() {
		System.out.println("[회원 가입]");

		String masterId = null;

		String masterPw1 = null;
		String masterPw2 = null;

		String gymName = null;
		String masterName = null;

		int studentCount = 0;

		try {
			// 아이디 입력 -> 중복 아닐 때까지 반복
			while (true) {
				System.out.print("아이디 입력 : ");
				masterId = sc.next();

				// 입력 받은 아이디를 매개변수로 전달하여 중복 여부 검사 호출 후 결과 반환
				int result = service.idDupCheck(masterId);

				// 중복이 아닌 경우
				if (result == 0) {
					System.out.println("[사용 가능한 아이디 입니다.]");
					break;
				} else { // 중복인 경우
					System.out.println("[이미 사용 중인 아이디 입니다.]");
				}
				System.out.println();

			}

			// 비번 입력
			// 비번/비번 확인이 일치 할 때까지 무한 반복
			while (true) {
				System.out.print("비밀번호 : ");
				masterPw1 = sc.next();

				System.out.print("비밀번호 확인 : ");
				masterPw2 = sc.next();

				System.out.println();
				if (masterPw1.equals(masterPw2)) {
					System.out.println("[일치합니다.]");
					break;
				} else {
					System.out.println("[비밀번호가 일치하지 않습니다. 다시 입력해주세요.]");
				}
				System.out.println();
			}

			// 이름 입력
			System.out.print("체육관 이름 입력 : ");
			gymName = sc.next();

			System.out.print("관장 이름 입력 : ");
			masterName = sc.next();

			System.out.print("원생 수 입력 : ");
			studentCount = sc.nextInt();

			SwMaster master = new SwMaster(masterId, masterPw2, gymName, masterName, studentCount);

			int result = service.signUp(master);

			System.out.println();
			if (result > 0) {
				System.out.println("***** 회원 가입 성공 *****");
			} else {
				System.out.println("<<회원 가입 실패>>");
			}

		} catch (Exception e) {
			System.out.println("<<회원 가입 중 예외 발생>>");
			e.printStackTrace();
		}

	}

	private void login() {
		System.out.println("[로그인]");

		System.out.print("아이디 : ");
		String masterId = sc.next();

		System.out.print("비밀번호 : ");
		String masterPw = sc.next();

		try {
			loginMaster = service.login(masterId, masterPw);

			System.out.println();
			if (loginMaster != null) { // 로그인 시
				System.out.println(loginMaster.getMasterName() + " 관장님 환영합니다.");

			} else { // 로그인 실패시
				System.out.println("[아이디 또는 비밀번호가 일치하지 않습니다.]");
			}

			System.out.println();

		} catch (Exception e) {
			System.out.println("\n<<로그인 중 예외 발생>>\n");
		}

	}

}
