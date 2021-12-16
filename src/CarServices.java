
public class CarServices {
	Car createCar(String[] info) {
		Car car = new Car();
		car.setDate(info[0]);
		car.setSale(Integer.parseInt(info[1]));
		return car;
		
	}
}
