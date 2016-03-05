package it.jpmorgan.calculate;

import it.jpmorgan.common.Costants;
import it.jpmorgan.model.Stock;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

/**
 * @author Matteo Onnis
 * @mail matteonnis@gmail.com
 * 
 */
public class StockPriceFormula {
	
	/**
	 * 
	 * 
	 */
	public static BigDecimal execute(Stock stock) {
		BigDecimal sumOfTmpTrades = BigDecimal.ZERO;
		BigDecimal sumOfShares = BigDecimal.ZERO;
		boolean newPrice = false;
		for (int i = 0; i < stock.getTrades().size(); i++) {
			if (isInRange(stock.getTrades().get(i).getTime())) {

				newPrice = true;
				BigDecimal tmpNumShares = stock.getTrades().get(i)
						.getQuantity();
				BigDecimal tmpTrade = stock.getTrades().get(i).getPrice()
						.multiply(tmpNumShares);
				sumOfTmpTrades = sumOfTmpTrades.add(tmpTrade);
				sumOfShares = sumOfShares.add(tmpNumShares);
			}
		}
		if (newPrice) {
			return sumOfTmpTrades.divide(sumOfShares, Costants.DECIMAL_SCALE,
					RoundingMode.HALF_UP);
		} else {
			return null;
		}
	}
	
	private static boolean isInRange(long timeTrade) {
		long minuteRange = Costants.STOCK_CALC_TIME * 60 * 1000;
		Date date = new Date();
		if (timeTrade >= (date.getTime() - minuteRange)) {
			return true;
		} else {
			return false;
		}
	}
}
