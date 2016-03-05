package it.jpmorgan.data;

import it.jpmorgan.model.Stock;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Matteo Onnis
 * @mail matteonnis@gmail.com
 */
public class DataStore {

	List<Stock> stocksList = new ArrayList<Stock>();

	private static DataStore instance;
	
	public static DataStore getInstance() {
		if (instance == null) {
			synchronized (DataStore.class) {
				if (instance == null) {
					instance = new DataStore();
				}
			}
		}
		return instance;
	}

	public List<Stock> getStocksList() {
		return stocksList;
	}

	public void setStocksList(List<Stock> stocksList) {
		this.stocksList = stocksList;
	}
}
