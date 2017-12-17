package stockMarket;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

	public static void main(String[] args) {

		String csvFile = "";
		String line = "";
		String csvSplitBy = ",";
		List<Stock> stockCollection = new ArrayList<Stock>();
		
		File dir = new File("E:\\stock_market_project\\sz50");
		for (File file : dir.listFiles()) {
			System.out.println(file.getPath());
			csvFile = file.getPath();
			try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
				line = br.readLine();
				String[] first_line = line.split(" ");
				stockCollection.add(new Stock(first_line[0]));
				line = br.readLine();
				while ((line = br.readLine()) != null && line.contains("/")) {
					String[] record_temp = line.split(csvSplitBy);
					stockCollection.get(stockCollection.size()-1).add(new Record(first_line[0], record_temp[0], Double.parseDouble(record_temp[1]), Double.parseDouble(record_temp[2]), Double.parseDouble(record_temp[3]), Double.parseDouble(record_temp[4])));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		List<Record> res2 = stockCollection.get(5).search_customed(4, 20);
		System.out.println(res2);
	}

}
