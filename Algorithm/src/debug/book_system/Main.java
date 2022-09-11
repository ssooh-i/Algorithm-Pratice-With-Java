package debug.book_system;

import java.util.Arrays;

import debug.book_system.domain.Book;
import debug.book_system.domain.Magazine;
import debug.book_system.service.BookManager;
import debug.book_system.service.ISBNNotFountException;
import debug.book_system.service.QuantityException;


public class Main {
	public static void main(String[] args){
		// 1.싱글톤 패턴 생성
		BookManager bookManager = BookManager.getBookManager();

		// 2.add 만들기
		bookManager.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법", 10));
		bookManager.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용", 20));
		bookManager.add(new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링", 30));
		bookManager.add(new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 2021, 1, 40));

//		for (int i = 0; i < bookManager.bList.size(); i++) {//bList 값 출력
//			System.out.println(bookManager.bList.get(i));
//		}

		// 3.모든 책을 list형태말과 배열형태로 반환
		System.out.println("****모든 책 배열로 출력****");
		System.out.println(Arrays.toString(bookManager.getList()));

		// 4.고유번호로 책검색(완전일치, equals)
		System.out.println("****책 번호 21424 검색****");
		Book b = bookManager.search("21424");
		if (b != null) {
			System.out.println(b);
		}

		// 5.고유번호 기준으로 책 삭제
		Book b2 = bookManager.delete("21424");
		System.out.println("****책 번호 21424 삭제후 책 배열 출력****");
		System.out.println(Arrays.toString(bookManager.getList()));

		// 6.잡지가 아닌 책만 배열 반환
		System.out.println("****잡지없이 책 배열 출력****");
		System.out.println(Arrays.toString(bookManager.getBooks()));

		// 7.잡지만 배열형태로 반환
		System.out.println("****잡지 배열 출력****");
		System.out.println(Arrays.toString(bookManager.getMagazine()));
		
		// 8.책이름을 기준으로 책검색(중복가능)contains
		System.out.println("****java를 기준으로 조회****");
		System.out.println(Arrays.toString(bookManager.getTitle("Java")));
		
		// 9.전체 가격 출력
		System.out.println("총 도서가격 : "+bookManager.getTotal());
		
		// 10.평균 가격 출력
		System.out.println("총 도서 평균 가격 : "+bookManager.getAvg());
	
		// 11.책 판매 기능
		System.out.println("****책 21425번, 수량 5권 판매****");
		try {
			System.out.println(bookManager.getSell("21425",5));
		} catch (QuantityException | ISBNNotFountException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(bookManager.getSell("21425",10));
		} catch (QuantityException | ISBNNotFountException e) {
			e.printStackTrace();
		}
		
		// 12.책 구매 기능
		System.out.println("****책 21425번, 수량 5권 구매****");
		try {
			System.out.println(bookManager.getBuy("21425",5));
		} catch (ISBNNotFountException e) {
			e.printStackTrace();
		}
	
	}

}
