
public class Car {
	private String date;
	private Integer sale;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getSale() {
		return sale;
	}
	public void setSale(Integer sale) {
		this.sale = sale;
	}
	@Override
	public String toString() {
		return "Car [date=" + date + ", sale=" + sale + "]";
	}
	
}
