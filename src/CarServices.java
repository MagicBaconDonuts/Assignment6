import java.util.List;
import java.util.stream.Collectors;

public class CarServices {
	Car createCar(String[] info) {
		Car car = new Car();
		car.setDate(info[0]);
		car.setSale(Integer.parseInt(info[1]));
		return car;
		
	}
	public int findSumForYear(List<Car> list, String year) {
		return list.stream()
			.filter(y -> y.getDate().contains(year))
			.map(sales -> sales.getSale())
			.mapToInt(Integer::valueOf)
			.sum();
		
	}
	public int findMaxValue(List<Car> carList) {
		return carList.stream()
		 .map(sales -> sales.getSale())
		 .max(Integer::compare)
		 .get();
	}
	public int findMinValue(List<Car> carList) {
		return carList.stream()
					  .map(sales -> sales.getSale())
					  .min(Integer::compare)
					  .get();
	}
	public String findCarDate(List<Car> model3Cars, int saleValue) {
		return model3Cars.stream()
						 .filter(price -> price.getSale().equals(saleValue))
						 .map(date -> date.getDate())
						 .collect(Collectors.joining());
	}
}
