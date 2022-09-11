package workshop.ws0805_car;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarManagerImpl implements CarManager {
	private static List<Car> list = new ArrayList<>();

	private static CarManager instance;

	public CarManagerImpl() {// 기본
		super();
	}

	public static CarManager getInstance() { // 인스턴스 생성
		if (instance == null) {
			instance = new CarManagerImpl();
		}
		return instance;
	}

	@Override
	public void add(Car car) throws SameNumberException {
		for (Car c : list) {
			if (c.getCarNum() == car.getCarNum()) {
				throw new SameNumberException("SameNumberException 발생" + c.getCarNum() + "은 이미 있음");
			}
		}
		list.add(car);
	}

	@Override
	public List<Car> search() {
		return list;
	}

	@Override
	public Car searchByNum(int carNum) throws NotFoundException {
		for (Car car : list) {
			if (car.getCarNum() == carNum) {
				return car;
			}
		}
		throw new NotFoundException("NotFoundException 발생" + carNum + "은 미등록차량");
	}

	// cat.txt로 저장
		@Override
		public void save() {
			ObjectOutputStream out=null;
			try {
				out=new ObjectOutputStream(new FileOutputStream("car.txt"));
				out.writeObject(list);
				out.flush();      //내보내고 버퍼 지우기
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					out.close();
				} catch (IOException e) {}
			}
		}

	@Override
	public List<Car> load() {
		File f = new File("car.txt");

		if (f.exists()) {
			ObjectInputStream in = null;
			try {
				in = new ObjectInputStream(new FileInputStream(f));
				list = (List<Car>) in.readObject();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
			return list;
		} else {
			return Collections.EMPTY_LIST;
		}
	}

}
