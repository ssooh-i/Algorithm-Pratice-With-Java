package debug.book_system.service;

public class ISBNNotFountException extends Exception{
	
	private String isbn;
	
	public ISBNNotFountException(String isbn) {
		super(isbn+"고유번호는 존재하지 않습니다");
		this.isbn = isbn;
	}
	
	public String getIsbn() {
		return isbn;
	}
}
