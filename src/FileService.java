import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {

	public List<Car> readFromFile(String fileName) {
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(fileName));
			CarServices car = new CarServices();
			List<Car> carList = new ArrayList<>();
			String headLine = reader.readLine();
			String line;
			while((line = reader.readLine())!= null) {
				carList.add(car.createCar(line.split(",")));
			}
			return carList;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
