package debug.book_system.domain;

public class Magazine extends Book {
	private int year;
	private int month;

	public Magazine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Magazine(String isbn, String title, String juja, String cps, int price, String yo, int su, int year,
			int month) {
		super(isbn, title, juja, cps, price, yo, su);
		// TODO Auto-generated constructor stub
		this.year = year;
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return super.toString() + "Magazine [year=" + year + ", month=" + month + "]";
	}

}
