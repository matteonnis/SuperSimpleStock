package it.jpm.exercize.mainTest;

import it.jpmorgan.data.DataStore;
import it.jpmorgn.operation.TradeOperation;
import junit.framework.TestCase;

public class TradeTest extends TestCase {

	
	TradeOperation tradeOp = new TradeOperation();
	StockTest stocktest = new  StockTest();
	
	    @Override
	    protected void setUp() throws Exception {
	        super.setUp();       
	    }
	    
	    @Override
	    protected void tearDown() throws Exception {
	        super.tearDown();
	    }
	    
	    public void addTestTrades(String stockId) throws Exception{
	    	tradeOp.aquiredManualyData(stockId, "45","1", "800");
	    	tradeOp.aquiredManualyData(stockId, "25","2", "40");
	    	tradeOp.aquiredManualyData(stockId, "12","1", "402");
	    	tradeOp.aquiredManualyData(stockId, "85","2", "150");
	    }

	    /**
	     * Test of recordTrade method, of class StockService.
	     */
	    public void testRecordTrade() throws Exception {
	    	stocktest.addAllStocks();
	        System.out.println("recordTrade");
	        int size=DataStore.getInstance().getStocksList().size();
	        for(int i=0; i<size;i++){
	        	addTestTrades(String.valueOf(i+1));
	  	        assertNotNull(DataStore.getInstance().getStocksList().get(i).getTrades());
	  	        assertEquals(4, DataStore.getInstance().getStocksList().get(i).getTrades().size());	
	        }
	        	
	    }

}
