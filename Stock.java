package stockMarket;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Stock {
	protected String stockName;
	protected List<Record> records = new ArrayList<Record>();
	
	public Stock(String n) {
		stockName = n;
	}
	
	public String getName() {
		return stockName;
	}
	
	public void add(Record r) {
		records.add(r);
	}
	
	public int size() {
		return records.size();
	}
	
	public Record search(String d) {
		LocalDate date = LocalDate.parse("1900-01-01");
		String[] dateStr = d.split("/");
		date = LocalDate.of(Integer.parseInt(dateStr[0]), Integer.parseInt(dateStr[1]), Integer.parseInt(dateStr[2]));
		for(Record r:records) {
			if(date.equals(r.getDate())) {
				return r;
			}
		}
		return null;
	}
	
	public List<Record> search_customed(int n, double percentage) {
		double cumulatedPercentage = 0;
		List<Record> results = new ArrayList<Record>();
		for (int i = 1; i <= records.size() - n; i++) {
			for (int j = i; j <= i + n - 1; j++) {
				cumulatedPercentage += (records.get(j).getClosing() - records.get(j-1).getClosing()) / records.get(j-1).getClosing();
			}
			if (cumulatedPercentage * 100 >= percentage) {
				results.add(records.get(i-1));
			}
			cumulatedPercentage = 0;
		}
		return results;

	}
}
