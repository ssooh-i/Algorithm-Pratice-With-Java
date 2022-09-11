package workshop.ws0805_compare;
//기본생성자, 인지 3개 받는 필드생성
public class Car implements Comparable<Car>{
	private int carNum;
	private String carName;
	private String maker;
	
	public Car() { //기본생성자
		super();
	}
	
	public Car(int carNum, String carName, String maker) {
		super();
		this.carNum = carNum;
		this.carName = carName;
		this.maker = maker;
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

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	@Override
	public String toString() { //안하면 주소값나옴
		return carNum+"\t"+carName+"\t"+maker;
	}

	@Override
	public int compareTo(Car o) {
		return this.getCarNum() - o.getCarNum();
		//return o.getCarNum() - this.getCarNum();    // 음수(내림차순)
	}
	

}
