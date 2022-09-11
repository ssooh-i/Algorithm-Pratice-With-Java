package workshop.ws0805_car;

import java.util.List;

public interface CarManager {
	void add(Car car) throws SameNumberException;
	List<Car> search();
	Car searchByNum(int carNum) throws NotFoundException;
	void save();
	List<Car> load();
}
