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
	    	 System.out.println("-->"+DataStore.getInstance().getStocksList().size());
	    	tradeOp.aquiredManualyData(stockId, "45","1", "800");
	    	tradeOp.aquiredManualyData(stockId, "25","2", "40");
	    	tradeOp.aquiredManualyData(stockId, "12","1", "402");
	    	tradeOp.aquiredManualyData(stockId, "85","2", "150");
	    }

	    /**
	     * Test of recordTrade method, of class StockService.
	     */
	    public void testRecordTrade() throws Exception {
	    	stocktest.addTeaStock();
	        System.out.println("recordTrade");
	        String stockId = "1";
	        addTestTrades(stockId);
	         assertNotNull(DataStore.getInstance().getStocksList().get(Integer.valueOf(stockId)).getTrades());
	        assertEquals(4, DataStore.getInstance().getStocksList().get(Integer.valueOf(stockId)).getTrades().size());
	      }

}
