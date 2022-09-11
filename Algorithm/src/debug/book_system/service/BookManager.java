package debug.book_system.service;

import java.util.ArrayList;
import java.util.List;

import debug.book_system.domain.Book;
import debug.book_system.domain.Magazine;



public class BookManager {
	private static BookManager bookManager = new BookManager();
	public List<Book> bList = new ArrayList<>();

	private BookManager() {
	}

	public static BookManager getBookManager() {
		return bookManager;
	}

	public void add(Book book) {
		bList.add(book);
	}

	public Book[] getList() {
		Book[] books = new Book[bList.size()];
		for (int i = 0; i < bList.size(); i++) {
			books[i] = bList.get(i);
		}
		return books;
	}

	public Book search(String n) {
		for (int i = 0; i < bList.size(); i++) {
			if (bList.get(i).getIsbn().equals(n)) {
				return bList.get(i);
			}
		}
		return null;
	}

	public Book delete(String n) {
		for (int i = 0; i < bList.size(); i++) {
			if (bList.get(i).getIsbn().equals(n)) {
				bList.remove(i);
			}
		}
		return null;
	}

	public Book[] getBooks() {
		// 배열 만들어 두고 책인지 확인하고 배열에 저장
		ArrayList<Book> t = new ArrayList<Book>();
		Book[] result = new Book[t.size()]; // 조회 결과를 담은 컬렉션의 크기를 활용하여 배열 생성
		for (Book book : bList) {
			if (!(book instanceof Magazine)) {
				t.add(book);
			}
		}
		return t.toArray(result);
	}

	public Book[] getMagazine() {
		ArrayList<Book> t = new ArrayList<Book>();
		Book[] result = new Book[t.size()];
		for (Book book : bList) {
			if (book instanceof Magazine) {
				t.add(book);
			}
		}
		return t.toArray(result);
	}

	public Book[] getTitle(String s) {
		ArrayList<Book> t = new ArrayList<Book>();
		Book[] result = new Book[t.size()];
		for (Book book : bList) {
			if (book.getTitle().contains(s)) {
				t.add(book);
			}
		}
		return t.toArray(result);
	}

	public int getTotal() {
		int sum = 0;
		for (int i = 0; i < bList.size(); i++) {
			sum += bList.get(i).getPrice();
		}
		return sum;
	}

	public double getAvg() {
		int sum = 0;
		for (int i = 0; i < bList.size(); i++) {
			sum += bList.get(i).getPrice();
		}
		return sum / bList.size();
	}

	public String getSell(String n, int c) throws QuantityException, ISBNNotFountException {
		Book book = search(n);
		int a = 0;
		if (search(n) != null) {
			if (book.getSu() < c) {
				throw new QuantityException();
			}
			a = book.getSu() - c;
			book.setSu(a);//다시 정의 set
		} else {
			throw new ISBNNotFountException(n);
		}

		return n + "번 책의 수량은 " + a + "권 남음";
	}
	
	public String getBuy(String n, int c) throws ISBNNotFountException {
		Book book = search(n);
		int a = 0;
		if (search(n) != null) {
			a = book.getSu() + c;
			book.setSu(a);//다시 정의 set
		} else {
			throw new ISBNNotFountException(n);
		}

		return n + "번 책의 수량은 " + a + "권 남음";
	}
}
