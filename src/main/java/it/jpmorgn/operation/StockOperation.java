package it.jpmorgn.operation;

import it.jpmorgan.calculate.DividendYeldFormula;
import it.jpmorgan.calculate.PERatioFormula;
import it.jpmorgan.calculate.StockPriceFormula;
import it.jpmorgan.data.DataStore;
import it.jpmorgan.model.Stock;
import it.jpmorgan.parser.ParseJsonData;
import it.jpmorgan.parser.ParseStock;
import it.jpmorgan.utils.PrintData;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author Matteo Onnis
 * @mail matteonnis@gmail.com
 * 
 */
public class StockOperation {

	public void aquiredJsonData() {
		ParseJsonData pd = new ParseJsonData();
		List<Map<String, Object>> myObjects = pd.ParserStockData();
		int initialSize = DataStore.getInstance().getStocksList().size() + 1;
		for (int i = 0; i < myObjects.size(); i++) {
			Stock stock = ParseStock.parseJsonData(i + initialSize,
					(Map<String, Object>) myObjects.get(i));
			DataStore.getInstance().getStocksList().add(calculateData(stock));
		}
		seeData();
	}

	public void aquiredManualyData(String symbol, String type,String lastDividend, String fixedDividend, 
			String parValue,String price) {
		int id = DataStore.getInstance().getStocksList().size() + 1;
		Stock stock = ParseStock.parseManualyData(id, symbol, type,
				lastDividend, fixedDividend, parValue, price);
		DataStore.getInstance().getStocksList().add(calculateData(stock));
		seeData();
	}
	
	public void seeData() {
		PrintData print = new PrintData();
		print.printDataStockList(DataStore.getInstance().getStocksList());
	}
	
	public void calculatePrice(){
		  for (int i = 0; i < DataStore.getInstance().getStocksList().size(); i++) {
				BigDecimal stockPrice= StockPriceFormula.execute(DataStore.getInstance().getStocksList().get(i));
				if(stockPrice!=null){
					DataStore.getInstance().getStocksList().get(i).setStockPrice(stockPrice);
				}
			}
		  seeData();
	}
	
	private Stock calculateData(Stock stock){
		if(!"".equals(stock.getTickerPrice())){
			stock.setDividendYield(DividendYeldFormula.execute(stock.getType(),
					stock.getLastDividend(), stock.getTickerPrice(),
					stock.getFixedDividend(), stock.getParValue()));
			stock.setPeRatio(PERatioFormula.execute(
					stock.getDividendYield(), stock.getTickerPrice()));
		}
		return stock;
	}
}
