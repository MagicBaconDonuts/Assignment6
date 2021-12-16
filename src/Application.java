import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {

	public static void main(String[] args) {
		
		List<Car> model3Cars = new ArrayList<>();
		List<Car> modelSCars = new ArrayList<>();
		List<Car> modelXCars = new ArrayList<>();
		FileService fileService = new FileService();
		DateTimeFormatter inputformat = DateTimeFormatter.ofPattern("MMM-yy");
		Comparator<Integer> compareTwoNum = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			} 
		};
		
		
		model3Cars = fileService.readFromFile("model3.csv");
		modelSCars = fileService.readFromFile("modelS.csv");
		modelXCars = fileService.readFromFile("modelX.csv");
		
		
		System.out.println("Model 3 Yearly Sales Report\n-----------------------");
		int[] collectionOfSalesForModel3 = {0,0,0};
		collectionOfSalesForModel3[0] = model3Cars.stream()
				  					 			  .filter(year -> year.getDate().contains("17"))
				  					 			  .map(x -> x.getSale())
				  					 			  .mapToInt(Integer::valueOf)
				  					 			  .sum();
		collectionOfSalesForModel3[1] = model3Cars.stream()
												  .filter(year -> year.getDate().contains("18"))
												  .map(x -> x.getSale())
												  .mapToInt(Integer::valueOf)
												  .sum();
		collectionOfSalesForModel3[2] = model3Cars.stream()
				  								  .filter(year -> year.getDate().contains("19"))
				  								  .map(x -> x.getSale())
				  								  .mapToInt(Integer::valueOf)
				  								  .sum();
		System.out.println("2017 -> $" + collectionOfSalesForModel3[0]);
		System.out.println("2018 -> $" + collectionOfSalesForModel3[1]);
		System.out.println("2019 -> $" + collectionOfSalesForModel3[2]);
		Map<String, List<Car>> rates = model3Cars.stream()
				  								 .collect(Collectors.groupingBy(Car -> Car.getDate()));
		int maxValue = rates.entrySet()
							.stream()
							.map(entry -> entry.getValue())
							.flatMap(y -> y.stream())
							.map(sale -> sale.getSale())
							.max(compareTwoNum)
							.get();
		int minValue = rates.entrySet()
				 			.stream()
				 			.map(entry -> entry.getValue())
				 			.flatMap(y -> y.stream())
				 			.map(sale -> sale.getSale())
				 			.min(compareTwoNum)
				 			.get();
		
		String carDate = model3Cars.stream()
				  				   .filter(price -> price.getSale().equals(maxValue))
				  				   .map(x -> x.getDate())
				  				   .collect(Collectors.joining());
		System.out.println("The best month for Model 3 was: " + YearMonth.parse(carDate, inputformat));
		carDate = model3Cars.stream()
							.filter(price -> price.getSale().equals(minValue))
							.map(x -> x.getDate())
							.collect(Collectors.joining());
		System.out.println("The worst month for Model 3 was: " + YearMonth.parse(carDate, inputformat));
		
		
		
		System.out.println("\nModel S Yearly Sales Report\n-----------------------");
		int[] collectionOfSalesForModelS = {0,0,0,0};
		collectionOfSalesForModelS[0] = modelSCars.stream()
				  								  .filter(year -> year.getDate().contains("16"))
				  								  .mapToInt(x -> x.getSale())
				  								  .sum();
		collectionOfSalesForModelS[1] = modelSCars.stream()
												  .filter(year -> year.getDate().contains("17"))
												  .mapToInt(x -> x.getSale())
												  .sum();
		collectionOfSalesForModelS[2] = modelSCars.stream()
				  								  .filter(year -> year.getDate().contains("18"))
				  								  .mapToInt(x -> x.getSale())
				  								  .sum();
		collectionOfSalesForModelS[3] = modelSCars.stream()
												  .filter(year -> year.getDate().contains("19"))
												  .mapToInt(x -> x.getSale())
												  .sum();
		System.out.println("2016 -> $" + collectionOfSalesForModelS[0]);
		System.out.println("2017 -> $" + collectionOfSalesForModelS[1]);
		System.out.println("2018 -> $" + collectionOfSalesForModelS[2]);
		System.out.println("2019 -> $" + collectionOfSalesForModelS[3]);
		Map<Object, List<Car>> ratesS = modelSCars.stream()
						  .collect(Collectors.groupingBy(car -> car.getDate()));
		int maxValueS = ratesS.entrySet()
						.stream()
						.map(x -> x.getValue())
						.flatMap(y -> y.stream())
						.map(sale -> sale.getSale())
						.max(compareTwoNum)
						.get();
		int minValueS = ratesS.entrySet()
				.stream()
				.map(x -> x.getValue())
				.flatMap(y -> y.stream())
				.map(sale -> sale.getSale())
				.min(compareTwoNum)
				.get();
		String carDateS = modelSCars.stream()
									.filter(price -> price.getSale().equals(maxValueS))
									.map(x -> x.getDate())
									.collect(Collectors.joining());
		System.out.println("The best month for Model S was: " + YearMonth.parse(carDateS, inputformat));
		carDateS = modelSCars.stream()
				.filter(price -> price.getSale().equals(minValueS))
				.map(x -> x.getDate())
				.collect(Collectors.joining());
		System.out.println("The worst month for Model S was: " + YearMonth.parse(carDateS, inputformat));
		System.out.println("\nModel X Yearly Sales Report\n-----------------------");
		int[] collectionOfSalesForModelX = {0,0,0,0};
		collectionOfSalesForModelX[0] = modelXCars.stream()
												  .filter(year -> year.getDate().contains("16"))
												  .mapToInt(x -> x.getSale())
												  .sum();
		collectionOfSalesForModelX[1] = modelXCars.stream()
				  								  .filter(year -> year.getDate().contains("17"))
				  								  .mapToInt(x -> x.getSale())
				  								  .sum();
		collectionOfSalesForModelX[2] = modelXCars.stream()
												  .filter(year -> year.getDate().contains("18"))
												  .mapToInt(x -> x.getSale())
												  .sum();
		collectionOfSalesForModelX[3] = modelXCars.stream()
												  .filter(year -> year.getDate().contains("19"))
												  .mapToInt(x -> x.getSale())
												  .sum();
		int year = 2016;
		for(int sum: collectionOfSalesForModelX) {
			System.out.println(year + "-> $" + sum);
			year++;
		}
		Map<Object, List<Car>> ratesX = modelXCars.stream()
						   .collect(Collectors.groupingBy(carx -> carx.getDate()));
		int maxValueX = ratesX.entrySet()
							  .stream()
							  .map(x -> x.getValue())
							  .flatMap(entry -> entry.stream())
							  .map(value -> value.getSale())
							  .max(compareTwoNum)
							  .get();
		int minValueX = ratesX.entrySet()
				  .stream()
				  .map(x -> x.getValue())
				  .flatMap(entry -> entry.stream())
				  .map(value -> value.getSale())
				  .min(compareTwoNum)
				  .get();
		String carDateX = modelXCars.stream()
				  .filter(x -> x.getSale().equals(maxValueX))
				  .map(date -> date.getDate())
				  .collect(Collectors.joining());
		System.out.println("The best month for Model X was: " + YearMonth.parse(carDateX, inputformat));
		carDateX = modelXCars.stream()
							 .filter(x -> x.getSale().equals(minValueX))
							 .map(date -> date.getDate())
							 .collect(Collectors.joining());
	String minDateOne = carDateX.substring(0,6);
	String minDateTwo = carDateX.substring(6,12);
		System.out.println("The worst month for Model X was: " + YearMonth.parse(minDateOne, inputformat)
		+ " and " + YearMonth.parse(minDateTwo, inputformat));
	}

}
