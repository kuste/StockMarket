
public class ReceiverDevice implements Receiver {

	private String stockPrice;
	private static String stockName;
	private String name;
	private DataGate dataGate;
	private Transmitter tr;

	public ReceiverDevice(String name) {

		this.name = name;

	}

	@Override
	public void update(DataGate data) {
		stockName = data.getStockName();
		stockPrice = data.getStockPrice();

		display();
	}

	@Override
	public void display() {

		System.out.println();
		System.out.println("\rStock name: " + stockName + " --> Price: " + stockPrice);

	}
}
