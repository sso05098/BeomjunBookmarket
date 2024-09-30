package practice4;

import java.util.Scanner;

public class BeomjunBookmarket {
	public static void main(String[] args) {
		final int NUMBOOK = 4;
		int[] cartlist = {0, 0, 0};
		
		
		Startview();
		boolean quit1 = false;
		while(!quit1) {
			int menu = getmenu();
			switch(menu) {
			case 1: 
				menubooklist();
				break;
			case 2:
				menucartlist(cartlist);
				break;
			case 3:
				cartlist[addbook()] += 1;
				break;
			case 4:
				emptybook(cartlist);
				break;
			case 0:
				quit();
				quit1 = true;
				break;
			default:
				wrongnum(NUMBOOK);
			}
			
		}
		}
	
	
	// 첫 환영 메서드
	static void Startview() {
		String welcome = "------------------------------\n"
						+"| welcome Beomjun Bookmarket |\n"
						+"------------------------------";
		System.out.println(welcome);
	}
	
	// 메뉴판
	static int getmenu() {
		String menu = "=========================\n"
					 +"1. 도서목록 보기\n"
					 +"2. 장바구니 보기\n"
					 +"3. 장바구니에 도서 추가\n"
					 +"4. 장바구니 비우기\n"
					 +"0. 종료\n"
					 +"=========================";
		System.out.println(menu);
		System.out.print("메뉴선택 >>");
		Scanner sc = new Scanner(System.in);
		int menu1 = sc.nextInt();
		return menu1;
	}
	
	// 북리스트 이중배열
	static String[][] booklist() {
		String bookarr[][] = {
				{"ID1201", "쉽게배우는 자바", "김범준", "bj아카데미", "20,000원"},
				{"ID1202", "어렵게배우는 파이썬", "박세연", "sy출판사", "15,000원"},
				{"ID1203", "Do it jsp", "서영", "young출판사", "10,000원"}
		};
		return bookarr;
	}
	
	// 1. 도서목록 보기(북리스트를 이용)
	static void menubooklist() {
		System.out.println("-----------------------------------------------");
		for( int i = 0; i < booklist().length; i++ ) {
			for( int j = 0; j < booklist()[i].length; j++ ) {
				System.out.print(booklist()[i][j] + ", ");
			}
			System.out.println();
		}
		System.out.println("-----------------------------------------------");
	}
	
	// 2. 장바구니 보기
	static void menucartlist(int cartlist[]) {
		int N = 0;
		System.out.println(">> 장바구니 보기");
		System.out.println("-----------------------------------------------");
		for( int i = 0; i < cartlist.length; i++ ) {
			if( cartlist[i] > 0) {
			System.out.println(cartlist[i] + "권, " + booklist()[i][1] + ", " + booklist()[i][2] + ", " + booklist()[i][3] + ", " + booklist()[i][4]);
			N = 1;
			}
		}
		if( N == 0 ) {
			System.out.println(">> 장바구니가 비어있습니다.");	
		}
		System.out.println("-----------------------------------------------");
		
	}

	// 3. 장바구니 추가
	static int addbook() {
		int index = -1;
		
		while(true) {
		menubooklist();
		Scanner sc = new Scanner(System.in);
		System.out.print("추가할 책 ID를 입력하세요 : ");
		String bookid = sc.nextLine();
		for( int i = 0; i < booklist().length; i++ ) {
			if( booklist()[i][0].equals(bookid)) {
				index = i;
			}
		}
		if( index != -1) {
			System.out.println(">>> 장바구니 추가 : " + booklist()[index][1]);
			break;
		}else {
			System.out.println(">>> 유효하지않는 ID 입니다.");
		}
		}
		return index;
	}
	
	// 4. 장바구니 비우기
	static void emptybook(int[] cartlist) {
		for( int i = 0; i < cartlist.length; i++ ) {
			cartlist[i] = 0;
		}
		System.out.println(">>> 장바구니를 비었습니다.");
	}
	
	// 0. 종료
	static void quit() {
		System.out.println("프로그램을 종료합니다.");
	}
	
	static void wrongnum(int NUMBOOK) {
		System.out.println("유효하지 않는 번호입니다. 0번부터 " + NUMBOOK + "번 까지의 번호를 다시 넣어주세요.");
	}
}
