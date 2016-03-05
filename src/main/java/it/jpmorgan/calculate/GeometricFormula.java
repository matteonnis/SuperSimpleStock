package it.jpmorgan.calculate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import it.jpmorgan.common.Costants;
import it.jpmorgan.data.DataStore;

/**
 * @author Matteo Onnis
 * @mail matteonnis@gmail.com
 * 
 */
public class GeometricFormula {
	
	public static BigDecimal execute() {
		BigDecimal result= new BigDecimal(0);
		BigDecimal aPricesMultiplication = BigDecimal.ZERO;
        BigDecimal one = BigDecimal.ONE;
        int listSize=DataStore.getInstance().getStocksList().size();
        for (int i = 0; i < listSize; i++) {
        	if (i == 0) {
        		aPricesMultiplication = DataStore.getInstance().getStocksList().get(i).getStockPrice();
        	 } else {
                 aPricesMultiplication = 
                		 aPricesMultiplication.multiply(DataStore.getInstance().getStocksList().get(i).getStockPrice());
             }
        }
        if (listSize > 0) {
        	double pow = Math.pow(aPricesMultiplication.doubleValue(), one.divide(new BigDecimal(listSize), Costants.DECIMAL_SCALE, RoundingMode.HALF_UP).doubleValue());
        	result= BigDecimal.valueOf(pow).setScale(Costants.DECIMAL_SCALE, RoundingMode.HALF_UP);
        	
        }
        return result;
    }
}
