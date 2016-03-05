package it.jpmorgan.calculate;

import it.jpmorgan.common.Costants;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Matteo Onnis
 * @mail matteonnis@gmail.com
 * 
 */
public class DividendYeldFormula {

	public static BigDecimal execute(String type, BigDecimal lastDividend,BigDecimal tickerPrice, BigDecimal fixedDividend,
			BigDecimal parValue) {
		BigDecimal result = new BigDecimal(0);
		if (type.equals(Costants.STOCK_TYPE[0])) {
			result = calcCommon(tickerPrice, lastDividend);
		} else if (type.equals(Costants.STOCK_TYPE[1])) {
			result = calcPrefered(tickerPrice, fixedDividend, parValue);
		}
		return result;
	}

	private static BigDecimal calcCommon(BigDecimal tickerPrice,BigDecimal lastDividend) {
		BigDecimal dividend = new BigDecimal(0).setScale(5);
		if (tickerPrice.compareTo(BigDecimal.ZERO) > 0) {
			dividend = lastDividend.divide(tickerPrice, Costants.DECIMAL_SCALE,
					RoundingMode.HALF_UP);
		}
		return dividend;
	}

	private static BigDecimal calcPrefered(BigDecimal tickerPrice,BigDecimal fixedDividend, BigDecimal parValue) {
		BigDecimal dividend = new BigDecimal(0).setScale(5);
		if (tickerPrice.compareTo(BigDecimal.ZERO) > 0) {
			dividend = (fixedDividend.multiply(parValue)).divide(tickerPrice,
					Costants.DECIMAL_SCALE, RoundingMode.HALF_UP);
		}
		return dividend;
	}

}
