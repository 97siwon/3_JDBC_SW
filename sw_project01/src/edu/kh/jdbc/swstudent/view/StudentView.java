package edu.kh.jdbc.swstudent.view;

import java.util.InputMismatchException;
import java.util.Scanner;

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
				case 1:
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

}
