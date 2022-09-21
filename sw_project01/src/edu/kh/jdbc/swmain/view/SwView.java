package edu.kh.jdbc.swmain.view;

import java.util.Scanner;

public class SwView {

	private Scanner sc = new Scanner(System.in);

	public void mainMenu() {

		int input = -1;

		do {

			try {
				System.out.println("----- 도장 관리 프로그램 -----");
				System.out.println("1. 원생 관리");
				System.out.println("2. 심사 관리");
				System.out.println("0. 프로그램 종료");

				System.out.print("메뉴 선택 >> ");
				input = sc.nextInt();

				System.out.println();

				switch (input) {
				case 1: studentView.studentMenu();
					break;
				case 2:
					break;
				case 0:
					System.out.println("프로그램 종료");
					input = 0;
					break;
				default:
					System.out.println("메뉴에 작성된 번호만 입력해주세요.");
				}

			} catch (Exception e) {
				System.out.println("\n<<입력 형식이 올바르지 않습니다.>>\n");
				sc.nextLine();
			}

		} while (input != 0);

	}

}
