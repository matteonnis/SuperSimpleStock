package it.jpmorgn.operation;

import it.jpmorgan.data.DataStore;
import it.jpmorgan.model.Stock;
import it.jpmorgan.model.Trade;
import it.jpmorgan.parser.ParseJsonData;
import it.jpmorgan.parser.ParseTrade;
import it.jpmorgan.utils.PrintData;
import java.util.List;
import java.util.Map;

/**
 * @author Matteo Onnis
 * @mail matteonnis@gmail.com
 * 
 */
public class TradeOperation {

	DataStore dataStore = new DataStore();

	public void aquiredJsonData() {
		ParseJsonData pd = new ParseJsonData();
		List<Map<String, Object>> myObjects = pd.ParserTradeData();

		for (int i = 0; i < myObjects.size(); i++) {
			Trade trade = ParseTrade
					.parseJsonData((Map<String, Object>) myObjects.get(i));
			int stockId = ParseTrade
					.parseStockId((Map<String, Object>) myObjects.get(i));
			trade.setId(DataStore.getInstance().getStocksList().get(stockId)
					.getTrades().size() + 1);
			if(stockId<=DataStore.getInstance().getStocksList().size()){
				DataStore.getInstance().getStocksList().get(stockId).getTrades()
						.add(trade);
			}
		}

		seeData();
	}

	public void aquiredManualyData(String stockId, String quantity,	String type, String price) {
		int id = DataStore.getInstance().getStocksList()
				.get(Integer.getInteger(stockId)-1).getTrades().size() + 1;
		Trade trade = ParseTrade.parseManualyData(id, quantity, type, price);
		DataStore.getInstance().getStocksList()
				.get(Integer.getInteger(stockId)-1).getTrades().add(trade);

		seeData();
	}

	public void seeData() {
		PrintData print = new PrintData();
		print.printDataTradekList(DataStore.getInstance().getStocksList());
	}

	public String getStockSymbolList() {
		String list = "";
		List<Stock> stockList = DataStore.getInstance().getStocksList();
		for (int i = 0; i < stockList.size(); i++) {
			list += stockList.get(i).getId() + ". "
					+ stockList.get(i).getStockSymbol();
		}
		return list;
	}
}
