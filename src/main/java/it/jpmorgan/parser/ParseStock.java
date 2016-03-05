package it.jpmorgan.parser;

import it.jpmorgan.common.Costants;
import it.jpmorgan.model.Stock;
import java.math.BigDecimal;
import java.util.Map;

/**
 * @author Matteo Onnis
 * @mail matteonnis@gmail.com
 */
public class ParseStock {

	public static Stock parseJsonData(int id, Map<String, Object> map) {
		Stock stock = new Stock();
		stock.setId(id);
		stock.setStockSymbol((String) map.get("StockSymbol"));
		stock.setType((String) map.get("Type"));
		stock.setLastDividend(new BigDecimal((String) map.get("Last Dividend")));
		String fixDiv = (String) map.get("Fixed Dividend");
		if (!"".equals(fixDiv)) {
			stock.setFixedDividend(new BigDecimal(fixDiv.replace("%", "")));
		}
		stock.setParValue(new BigDecimal((String) map.get("Par Value")));
		stock.setTickerPrice(new BigDecimal((String) map.get("TickerPrice")));
		return stock;
	}

	public static Stock parseManualyData(int id, String symbol, String type,String lastDividend, String fixedDividend, String parValue,
			String price) {
		Stock stock = new Stock();
		stock.setId(id);
		stock.setStockSymbol(symbol);
		stock.setType(Costants.STOCK_TYPE[Integer.parseInt(type) - 1]);
		stock.setLastDividend(new BigDecimal(lastDividend));
		if (!"".equals(fixedDividend)) {
			stock.setFixedDividend(new BigDecimal(fixedDividend
					.replace("%", "")));
		}
		stock.setParValue(new BigDecimal(parValue));
		stock.setTickerPrice(new BigDecimal(price));
		return stock;
	}
}
