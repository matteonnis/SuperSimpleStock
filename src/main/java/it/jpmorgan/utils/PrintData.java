/**
 * Class only for see the data
 */
package it.jpmorgan.utils;

import it.jpmorgan.common.Costants;
import it.jpmorgan.model.Stock;
import it.jpmorgan.model.Trade;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author Matteo Onnis
 * @mail matteonnis@gmail.com
 *
 */
public class PrintData {

	public void printDataStockList(List<Stock>  stocklist){
		DecimalFormat df = new DecimalFormat("#,###.#####");
		if(stocklist.size()>0){
			System.out.println("");
			System.out.println("Stocks : ");
			String leftAlignFormat = "| %-3d | %-8s | %-9s | %-9s | %-8s | %-7s | %-9s | %-8s | %-11s |%-12s | %-9s |    %n";
		
			System.out.format("+-----+----------+-----------+-----------+----------+---------+-----------+----------+-------------+-------------+-----------+%n");
			System.out.format("|     |          |           |   Last    |  Fixed   |   Par   |  Ticker   | Dividend |             |             |   Stock   |%n");
			System.out.format("|ID   | Symbol   |   Type    | Dividend  | Dividend |  Value  |   Price   |   yield  | P/ERatio    |    Trades   |   price   |%n");
			System.out.format("+-----+----------+-----------+-----------+----------+---------+-----------+----------+-------------+-------------+-----------+%n");
			for (int i = 0; i < stocklist.size(); i++) {
				Stock stock=stocklist.get(i);
				String fixDiv="";
				if(stock.getFixedDividend()!= null && !"".equals(stock.getFixedDividend())){
					fixDiv=(df.format(stock.getFixedDividend()))+"%";
				}
				
			    System.out.format(leftAlignFormat, 
			    		stock.getId(),
			    		stock.getStockSymbol(),
			    		stock.getType(), 
			    		df.format(stock.getLastDividend()),
			    		fixDiv,
			    		df.format(stock.getParValue()),
			    		df.format(stock.getTickerPrice()),
			    		df.format(stock.getDividendYield()),
			    		df.format(stock.getPeRatio()),
			    		stock.getTrades().size(),
			    		df.format(stock.getStockPrice())
			    		);
			}
			System.out.format("+-----+----------+-----------+-----------+----------+---------+-----------+----------+-------------+-------------+-----------+%n");
		}else{
			System.out.println("Stock list is empty, please aquired data first!");
		}
	}
	
	public void printDataTradekList(List<Stock>  stocklist){
		DecimalFormat df = new DecimalFormat("#,###.#####");
		 SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy HH:mm");
         
		if(stocklist.size()>0){
			System.out.println("");
			System.out.println("Stocks : ");
			String leftAlignFormat = "| %-3d | %-8s | %-9s | %-9s | %-8s | %-15s |%n";
		
			System.out.format("+-----+----------+-----------+-----------+----------+------------------+%n");
			System.out.format("|ID   |  Stock   |   Type    | Quantity  |  Price   |      Time        |%n");
			System.out.format("+-----+----------+-----------+-----------+----------+------------------+%n");
			for (int i = 0; i < stocklist.size(); i++) {
				Stock stock=stocklist.get(i);
				List<Trade>  tradelist =stock.getTrades();
				for (int z = 0; z < tradelist.size(); z++) {
				
					Trade trade=tradelist.get(z);
					System.out.format(leftAlignFormat, 
							trade.getId(),
							stock.getStockSymbol(),
							Costants.TRADE_TYPE[(trade.getType()-1)],
							df.format(trade.getQuantity()),
				    		df.format(trade.getPrice()),
				    		formater.format(trade.getTime()).toString()
				    		);
				}
				if(tradelist.size()>0){
					System.out.format("+-----+----------+-----------+-----------+----------+------------------+%n");
				}
			}
		}else{
			System.out.println("Trade list is empty, please aquired data first!");
		}
	}
	
}
