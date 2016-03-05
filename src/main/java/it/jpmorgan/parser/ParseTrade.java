package it.jpmorgan.parser;

import it.jpmorgan.model.Trade;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * @author Matteo Onnis
 * @mail matteonnis@gmail.com
 * 
 */
public class ParseTrade {

	public static Trade parseJsonData(Map<String, Object> map) {
		Trade trade = new Trade();
		Date date = new Date();
		trade.setQuantity(new BigDecimal((String) map.get("Quantity")));
		trade.setType(Integer.parseInt((String) map.get("Type")));
		trade.setPrice((new BigDecimal((String) map.get("Price"))));
		trade.setTime(date.getTime());
		return trade;
	}

	public static Trade parseManualyData(int id, String quantity, String type,
			String price) {
		Trade trade = new Trade();
		Date date = new Date();
		trade.setId(id);
		trade.setQuantity(new BigDecimal((String) quantity));
		trade.setType(Integer.getInteger((String) type));
		trade.setPrice((new BigDecimal(price)));
		trade.setTime(date.getTime());
		return trade;
	}

	public static int parseStockId(Map<String, Object> map) {
		return Integer.parseInt((String) map.get("Stock"))-1;
	}
}
