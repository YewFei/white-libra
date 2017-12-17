package stockMarket;

import java.time.LocalDate;

public class Record {
	protected String stock_id;
	protected LocalDate date = LocalDate.parse("1900-01-01");
	protected double opening, highest, lowest, closing;
	
	public Record(String s, String d, double o, double h, double l, double c) {
		//d -> date
		stock_id = s;
		String[] dateStr = d.split("/");
		date = LocalDate.of(Integer.parseInt(dateStr[0]), Integer.parseInt(dateStr[1]), Integer.parseInt(dateStr[2]));
		opening = o;
		highest = h;
		lowest = l;
		closing = c;
	}
	
	public String getId() {
		return stock_id;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public double getOpening() {
		return opening;
	}
	
	public double getHighest() {
		return highest;
	}
	
	public double getLowest() {
		return lowest;
	}
	
	public double getClosing() {
		return closing;
	}
	
	public String toString() {
		return "Stock ID:" + this.getId() + "\n"
				+ "Date:" + this.getDate() + "\n"
				+ "Opening price:" + this.getOpening() + "\n"
				+ "Closing price:" + this.getClosing() + "\n"
				+ "Highest price:" + this.getHighest() + "\n"
				+ "Lowest price:" + this.getLowest() + "\n";
	}
}
