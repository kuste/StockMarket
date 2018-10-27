import java.util.Observer;

public class DataGate implements Receiver {

	private String stockPrice;
	private String stockName;
	private String name;
	private GetStockPrice pr;

	public DataGate(GetStockPrice pr) {

		this.pr = pr;

		

	}

	public String getStockName() {
		return stockName;
	}

	public String getStockPrice() {
		return stockPrice;
	}

	@Override
	public void update(DataGate data) {
		this.stockName = pr.getStockName();
		this.stockPrice = pr.getStockPrice();
	}

	@Override
	public void display() {
		

	}

}
