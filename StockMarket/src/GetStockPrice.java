import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class GetStockPrice implements Transmitter {

	private ArrayList<Receiver> receivers;

	private static Vector<String> stockNameList;
	private Vector<String> stockPriceList;
	private Document doc;

	private static String stockName;
	private String stockPrice;
	private Transmitter tr;
	private int startTime;

	public GetStockPrice() {

		stockNameList = new Vector<>();
		stockPriceList = new Vector<>();
		receivers = new ArrayList<>();

	}

	public void setStock() {
		getData();
		for (int i = 0; i < stockNameList.size(); i++) {
			this.stockName = stockNameList.get(i).toString();
			this.stockPrice = stockPriceList.get(i).toString();
			notifyRec();
		}

	}

	@Override
	public void add(Receiver newReceiver) {
		receivers.add(newReceiver);

	}

	@Override
	public void remove(Receiver r) {
		int indexOfRec = receivers.indexOf(r);
		System.out.println("Receiver " + (indexOfRec + 1) + " removed!");

		receivers.remove(indexOfRec);
	}

	@Override
	public void notifyRec() {
		DataGate data = new DataGate(this);
		data.update(data);
				
		for (Receiver r : receivers) {
			r.update(data);
		}

	}

	public void getData() {
		try {

			System.out.println("connecting...");
			doc = Jsoup.connect("https://money.cnn.com/data/markets/").get();

			String title = doc.title();
			System.out.println(title);
			Elements stockN = doc.select(".stock-name");
			Elements stockP = doc.select(".stock-price");
			for (int i = 0; i < stockN.size(); i++) {
				stockNameList.add(stockN.get(i).text());
			}
			for (int i = 0; i < stockP.size(); i++) {
				stockPriceList.add(stockP.get(i).text());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("done!");
	}

	public String getStockName() {
		return stockName;
	}

	public String getStockPrice() {
		return stockPrice;
	}


	


	



	

}
