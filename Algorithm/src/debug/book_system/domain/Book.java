package debug.book_system.domain;

public class Book {
	private String isbn;
	private String title;
	private String juja;
	private String cps;
	private int price;
	private String yo;
	private int su;
	
	public Book() {}

	public Book(String isbn, String title, String juja, String cps, int price, String yo, int su) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.juja = juja;
		this.cps = cps;
		this.price = price;
		this.yo = yo;
		this.su = su;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getJuja() {
		return juja;
	}

	public void setJuja(String juja) {
		this.juja = juja;
	}

	public String getCps() {
		return cps;
	}

	public void setCps(String cps) {
		this.cps = cps;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getYo() {
		return yo;
	}

	public void setYo(String yo) {
		this.yo = yo;
	}

	public int getSu() {
		return su;
	}

	public void setSu(int su) {
		this.su = su;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", juja=" + juja + ", cps=" + cps + ", price=" + price
				+ ", yo=" + yo + ", su=" + su + "]";
	}

}
