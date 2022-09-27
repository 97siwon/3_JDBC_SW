package edu.kh.jdbc.swmaster.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.jdbc.swmain.view.SwView;
import edu.kh.jdbc.swmaster.service.MasterService;
import edu.kh.jdbc.swmaster.vo.SwMaster;

public class MasterView {

	private Scanner sc = new Scanner(System.in);

	private MasterService service = new MasterService();

	private SwMaster loginMaster = null;

	private int input = -1;

	public void masterMenu(SwMaster loginMaster) {
		this.loginMaster = loginMaster;

		do {
			try {
				System.out.println("\n***** 회원 기능 *****\n");
				System.out.println("1. 내 정보 조회");
				System.out.println("2. 내 정보 수정(체육관 이름, 원생 수)");
				System.out.println("3. 비밀번호 변경");
				System.out.println("4. 회원 탈퇴");
				System.out.println("0. 메인 메뉴로 이동");

				System.out.print("메뉴 선택 : ");
				input = sc.nextInt();
				sc.nextLine();

				System.out.println();
				switch (input) {
				case 1:
					selectMyInfo();
					break;
				case 2:
					updateMaster();
					break;
				case 3:
					updatePw();
					break;
				case 4:
					secession();
					break;
				case 0:
					System.out.println("[메인 메뉴로 이동합니다.]");
					break;
				default:
					System.out.println("메뉴에 작성된 번호만 입력해주세요.");
				}

			} catch (InputMismatchException e) {
				System.out.println("\n<<입력 형식이 올바르지 않습니다.>>\n");
				sc.nextLine();
			}
		} while (input != 0);

	}


	/**
	 * 내 정보 조회
	 */
	private void selectMyInfo() {
		System.out.println("[내 정보 조회]\n");

		System.out.println("회원 아이디 : " + loginMaster.getMasterId());
		System.out.println("체육관 이름 : " + loginMaster.getGymName());
		System.out.println("회원 이름 : " + loginMaster.getMasterName());
		System.out.println("원생 수 : " + loginMaster.getStudentCount());
		System.out.println("가입일 : " + loginMaster.getEnrollDate());

	}

	/**
	 * 내 정보 수정
	 */
	private void updateMaster() {
		System.out.println("\n[내 정보 수정]\n");

		try {
			System.out.println("변경할 체육관 이름 : ");
			String gymName = sc.next();

			System.out.println("변경할 원생 수 : ");
			int studentCount = sc.nextInt();

			SwMaster master = new SwMaster();
			master.setMasterId(loginMaster.getMasterId());
			master.setGymName(gymName);
			master.setStudentCount(studentCount);

			int result = service.updateMaster(master);

			if (result > 0) {
				loginMaster.setGymName(gymName);
				loginMaster.setStudentCount(studentCount);

				System.out.println("\n회원 정보가 수정되었습니다.\n");
			} else {
				System.out.println("\n[수정 실패]\n");
			}

		} catch (Exception e) {
			System.out.println("\n<<회원 정보 수정 중 예외 발생>>\n");
			e.printStackTrace();
		}

	}

	/**
	 * 비밀번호 변경
	 */
	private void updatePw() {
		System.out.println("\n[비밀번호 변경]\n");

		try {
			System.out.print("현재 비밀번호 : ");
			String currentPw = sc.next();

			String newPw1 = null;
			String newPw2 = null;

			while (true) {
				System.out.println("새 비밀번호 : ");
				newPw1 = sc.next();

				System.out.println("새 비밀번호 확인 : ");
				newPw2 = sc.next();

				if (newPw1.equals(newPw2)) {
					break;
				} else {
					System.out.println("\n새 비밀번호가 일치하지 않습니다. 다시 입력해주세요.\n");
				}
			}

			int result = service.updatePw(currentPw, newPw1, loginMaster.getMasterId());

			if (result > 0) {
				System.out.println("\n비밀번호가 변경되었습니다.\n");
			} else {
				System.out.println("\n현재 비밀번호가 일치하지 않습니다.\n");
			}

		} catch (Exception e) {
			System.out.println("\n<<비밀번호 변경 중 예외 발생>>\n");
			e.printStackTrace();
		}

	}
	

	/**
	 * 회원 탈퇴
	 */
	private void secession() {
		System.out.println("\n[회원 탈퇴]\n");
		
		try {
			System.out.print("현재 비밀번호 입력 : ");
			String masterPw = sc.next();
			
			while(true) {
				System.out.print("정말 탈퇴하시겠습니까?(Y/N) : ");
				char ch = sc.next().toUpperCase().charAt(0);
				
				if(ch == 'Y') {
					int result = service.secession(masterPw, loginMaster.getMasterName());
					
					if(result > 0) {
						System.out.println("\n[탈퇴되었습니다.]\n");
						
						input = 0;
						SwView.loginMaster = null;
						
					} else {
						System.out.println("\n[비밀번호가 일치하지 않습니다.]\n");
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
			
		}
	
	}

}
