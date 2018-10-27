
public class App {

	public static void main(String[] args) {

		GetStockPrice stockPrice = new GetStockPrice();
		DataGate dg = new DataGate(stockPrice);
		ReceiverDevice device = new ReceiverDevice("Device 1");
		
		stockPrice.add(device);
		stockPrice.setStock();
		
		
;
		
	}
}
