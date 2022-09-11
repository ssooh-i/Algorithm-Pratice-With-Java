package debug.book_system.service;

public class QuantityException extends Exception{
	public QuantityException() {
		super("수량이 부족합니다");
		//super("수량 부족!");
	}

}
