import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Application {

	public static void main(String[] args) {
		
		List<Car> model3Cars = new ArrayList<>();
		List<Car> modelSCars = new ArrayList<>();
		List<Car> modelXCars = new ArrayList<>();
		FileService fileService = new FileService();
		CarServices carService = new CarServices();
		DateTimeFormatter inputformat = DateTimeFormatter.ofPattern("MMM-yy");
		
		model3Cars = fileService.readFromFile("model3.csv");
		modelSCars = fileService.readFromFile("modelS.csv");
		modelXCars = fileService.readFromFile("modelX.csv");
		
		
		
		System.out.println("Model 3 Yearly Sales Report\n-----------------------");
		int[] collectionOfSalesForModel3 = {0,0,0};
		collectionOfSalesForModel3[0] = carService.findSumForYear(model3Cars, "17");
		collectionOfSalesForModel3[1] = carService.findSumForYear(model3Cars, "18");
		collectionOfSalesForModel3[2] = carService.findSumForYear(model3Cars, "19");
		int currentYear = 2017;
		for(int sum: collectionOfSalesForModel3) {
			System.out.println(currentYear + " -> $" + sum);
			currentYear++;
		}
		int maxValue = carService.findMaxValue(model3Cars);
		int minValue = carService.findMinValue(model3Cars);
		String carDate = carService.findCarDate(model3Cars, maxValue);
		System.out.println("The best month for Model 3 was: " + YearMonth.parse(carDate, inputformat));
		carDate = carService.findCarDate(model3Cars, minValue);
		System.out.println("The worst month for Model 3 was: " + YearMonth.parse(carDate, inputformat));
		
		
		
		
		System.out.println("\nModel S Yearly Sales Report\n-----------------------");
		int[] collectionOfSalesForModelS = {0,0,0,0};
		collectionOfSalesForModelS[0] = carService.findSumForYear(modelSCars, "16");
		collectionOfSalesForModelS[1] = carService.findSumForYear(modelSCars, "17");
		collectionOfSalesForModelS[2] = carService.findSumForYear(modelSCars, "18");
		collectionOfSalesForModelS[3] = carService.findSumForYear(modelSCars, "19");
		currentYear = 2016;
		for(int sum: collectionOfSalesForModelS) {
			System.out.println(currentYear + " -> $" + sum);
			currentYear++;
		}
		int maxValueS = carService.findMaxValue(modelSCars);
		int minValueS = carService.findMinValue(modelSCars);
		String carDateS = carService.findCarDate(modelSCars, maxValueS);
		System.out.println("The best month for Model S was: " + YearMonth.parse(carDateS, inputformat));
		carDateS = carService.findCarDate(modelSCars, minValueS);
		System.out.println("The worst month for Model S was: " + YearMonth.parse(carDateS, inputformat));
		
		
		
		System.out.println("\nModel X Yearly Sales Report\n-----------------------");
		int[] collectionOfSalesForModelX = {0,0,0,0};
		collectionOfSalesForModelX[0] = carService.findSumForYear(modelXCars, "16");
		collectionOfSalesForModelX[1] = carService.findSumForYear(modelXCars, "17");
		collectionOfSalesForModelX[2] = carService.findSumForYear(modelXCars, "18");
		collectionOfSalesForModelX[3] = carService.findSumForYear(modelXCars, "19");
		currentYear = 2016;
		for(int sum: collectionOfSalesForModelX) {
			System.out.println(currentYear + "-> $" + sum);
			currentYear++;
		}
		int maxValueX = carService.findMaxValue(modelXCars);
		int minValueX = carService.findMinValue(modelXCars);
		String carDateX = carService.findCarDate(modelXCars, maxValueX);
		System.out.println("The best month for Model X was: " + YearMonth.parse(carDateX, inputformat));
		carDateX = carService.findCarDate(modelXCars, minValueX);
		String minDateOne = carDateX.substring(0,6);
		String minDateTwo = carDateX.substring(6,12);
		System.out.println("The worst month for Model X was: " + YearMonth.parse(minDateOne, inputformat)
		+ " and " + YearMonth.parse(minDateTwo, inputformat));
	}

}
