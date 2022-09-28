package edu.kh.jdbc.swcommunity.view;

import java.util.Scanner;

public class CommunityView {

	private Scanner sc = new Scanner(System.in);
	
	private int input = -1;

	public void communityMenu() {
		
		do {
			try {
				System.out.println("\n***** 커뮤니티 *****\n");
				System.out.println("1. 게시물 목록 조회");
				System.out.println("2. 게시물 상세 조회(+댓글 기능)");
				System.out.println("3. 게시물 작성");
				System.out.println("4. 게시물 검색");
				System.out.println("0. 메인 메뉴");
				
				System.out.println("\n메뉴 선택\n");
				input = sc.nextInt();
				sc.nextLine();
				
				System.out.println();
				
				switch(input) {
				case 1: selectAllboard();
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 0:
					break;
				default :
				}
	
			} catch (Exception e) {
				System.out.println("<<입력 형식이 올바르지 않습니다.>>");
				e.printStackTrace();
			}
			
		} while(input != 0);
	
	}

	private void selectAllboard() {
		System.out.println("\n[게시물 목록 조회]\n");

		try {
			
			
			
			
		} catch (Exception e) {
			System.out.println("\n<<게시글 목록 조회 중 예외 발생>>\n");
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
}
