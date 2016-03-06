package it.jpm.exercize.mainTest;


import java.math.BigDecimal;



import it.jpmorgan.common.Costants;
import it.jpmorgan.data.DataStore;
import it.jpmorgn.operation.StockOperation;
import junit.framework.TestCase;

public class StockTest extends TestCase {

	  private StockOperation  stockOp=new StockOperation();
	
	  @Override
	    protected void setUp() throws Exception {
	        super.setUp();
	        
	    }
	    
	    @Override
	    protected void tearDown() throws Exception {
	        super.tearDown();
	    }
	   
	   
	    public void addTeaStock() throws Exception{
	        String symbol = "TEA";
	        String type = "1";
	        String lastDividend = "50";
	        String fixedDividend = "0";
	        String parValue = "100";
	        String tickerPrice = "110";
	        stockOp.aquiredManualyData(symbol, type, lastDividend, fixedDividend, parValue, tickerPrice);   
	    }
	    
	    public void addPopStock() throws Exception{
	        String symbol = "POP";
	        String type = "1";
	        String lastDividend = "8";
	        String fixedDividend = "0";
	        String parValue = "100";
	        String tickerPrice = "115";
	        stockOp.aquiredManualyData(symbol, type, lastDividend, fixedDividend, parValue, tickerPrice);  
	    }
	    
	    public void addAleStock() throws Exception{
	        String symbol = "ALE";
	        String type = "1";
	        String lastDividend = "23";
	        String fixedDividend = "0";
	        String parValue = "60";
	        String tickerPrice = "90";
	        stockOp.aquiredManualyData(symbol, type, lastDividend, fixedDividend, parValue, tickerPrice); 
	    }
	    
	    public void addGinStock() throws Exception{
	        String symbol = "GIN";
	        String type = "2";
	        String lastDividend = "8";
	        String fixedDividend = "2";
	        String parValue = "100";
	        String tickerPrice = "80";
	        stockOp.aquiredManualyData(symbol, type, lastDividend, fixedDividend, parValue, tickerPrice);  
	    }
	    
	    public void addJoeStock() throws Exception{
	        String symbol = "JOE";
	        String type = "1";
	        String lastDividend = "13";
	        String parValue = "250";
	        String tickerPrice = "300";
	        String fixedDividend = "0";
	        stockOp.aquiredManualyData(symbol, type, lastDividend, fixedDividend, parValue, tickerPrice);   
	    }
	    
	    public void addAllStocks() throws Exception{
	        addAleStock();
	        addGinStock();
	        addJoeStock();
	        addPopStock();
	        addTeaStock();
	    }

	    
	    public void testAddAllStocks() throws Exception{
	        addAllStocks();
	        assertEquals(5,DataStore.getInstance().getStocksList().size());
	    }
	    /**
	     * Test of newStock method, of class PortfolioService.
	     */
	    
	    public void testNewStockBasic() throws Exception {
	        System.out.println("newStock");
	        String symbol = "TEA";
	        String type = "1";
	        String lastDividend = "0";
	        String fixedDividend = "0";
	        String parValue = "100";
	        String tickerPrice = "110";
	        stockOp.aquiredManualyData(symbol, type, lastDividend, fixedDividend, parValue, tickerPrice);   
	        int lastindex=DataStore.getInstance().getStocksList().size()-1;
	        assertNotNull(DataStore.getInstance().getStocksList().get(lastindex));
	        assertEquals(new BigDecimal(lastDividend), DataStore.getInstance().getStocksList().get(lastindex).getLastDividend());
	        assertEquals(new BigDecimal(parValue), DataStore.getInstance().getStocksList().get(lastindex).getParValue());
	        assertEquals(new BigDecimal(tickerPrice), DataStore.getInstance().getStocksList().get(lastindex).getTickerPrice());
	        assertEquals(new BigDecimal(fixedDividend), DataStore.getInstance().getStocksList().get(lastindex).getFixedDividend());
	        assertEquals(Costants.STOCK_TYPE[Integer.parseInt(type)-1], DataStore.getInstance().getStocksList().get(lastindex).getType());
	        
	    }
}
