package workshop.ws0805_car;

/*
-price:int
+Taxi()
+Taxi(carNum:int, carName:String,price:int)
*/
//Car를 상속 받아서 인자 3개받는 생성자 추가

public class Taxi extends Car{
	private int price;

	public Taxi() {
		super();
	}

	public Taxi(int price) {
		super();
		this.price = price;
	}
	 
	public Taxi(int carNum, String carName, int price) {
		super(carNum, carName);
		this.price = price;
	}

	@Override
	public String toString() {
		return "Taxi [price=" + price + "]";
	}
}
