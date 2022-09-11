package workshop.ws0805_car;

import java.io.Serializable;

/*
-carNum:int
-carName:String
+Car()
+Car(carNum:int,carName:String)
+getter & getter
+toString():String
*/

//기본생성자, 인자2개받는 생성자, getter&setter, toString() 추가
public class Car implements Serializable{
	private int carNum;
	private String carName;
	public Car() {
		super();
	}
	public Car(int carNum, String carName) {
		super();
		this.carNum = carNum;
		this.carName = carName;
	}
	public int getCarNum() {
		return carNum;
	}
	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	@Override
	public String toString() {
		return "Car [carNum=" + carNum + ", carName=" + carName + "]";
	}
	
}
