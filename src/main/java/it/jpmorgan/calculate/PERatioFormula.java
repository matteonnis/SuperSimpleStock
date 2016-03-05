package it.jpmorgan.calculate;

import it.jpmorgan.common.Costants;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Matteo Onnis
 * @mail matteonnis@gmail.com
 * 
 */
public class PERatioFormula {

	public static BigDecimal execute(BigDecimal dividend,BigDecimal tickerPrice){
		BigDecimal resultPERatio= new BigDecimal(0);
		if (dividend.compareTo(BigDecimal.ZERO) > 0) {
			resultPERatio=tickerPrice.divide(dividend, Costants.DECIMAL_SCALE, RoundingMode.HALF_UP);
		}
		return resultPERatio;
	}
}
