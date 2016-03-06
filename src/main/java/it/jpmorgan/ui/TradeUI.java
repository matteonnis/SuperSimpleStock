package it.jpmorgan.ui;

import it.jpmorgn.operation.TradeOperation;

import java.util.Scanner;

/**
 * @author Matteo Onnis
 * @mail matteonnis@gmail.com
 * 
 */
public class TradeUI extends UIScan {

	private static Integer option = 0;
	private static Integer optionBack = 0;
	TradeOperation tradeOp = new TradeOperation();

	public TradeUI(Scanner reader) {
		super(reader);
	}

	public void execute(String scanned, Scanner reader) {
		showMenuStock(scanned, reader);
		switch (option) {
		case 1:
			tradeOp.aquiredJsonData();

			break;
		case 2:
			 selectStock();
			break;
		case 3:
			tradeOp.seeData();
			break;
		case 4:
			GeneralUI.execute(scanned, reader);
			break;
		default:
			System.out.println("Insert a valid option");
			break;
		}
		executeBackMenu(scanned, reader);
	}
 
	public  void showMenuStock(String scanned, Scanner reader) {
		System.out.println("Please select a Stock option");
		System.out.println("  1. Aquire trade data to JSON ");
		System.out.println("  2. Aquire manualy trade data ");
		System.out.println("  3. See trade data ");
		System.out.println("  4. Retutn to previus menu ");
		System.out.println("\n");
		System.out.print(" Option : ");
		scanned = reader.nextLine();

		option = 0;
		try {
			option = Integer.valueOf(scanned);
		} catch (Exception e) {
			System.out.println("Please insert an option");
		}
	}

	public void executeBackMenu(String scanned, Scanner reader) {
		backMenu(scanned, reader);
		switch (optionBack) {
		case 1:
			execute(scanned, reader);
			break;
		case 2:
			System.out.println("Thanks for the test!");
			System.exit(1);
			break;
		default:
			System.out.println("Insert a valid option");
			break;
		}
	}

	/**
	 *
	 * @param scanned
	 * @param reader
	 */
	public static void backMenu(String scanned, Scanner reader) {
		System.out.println("\n");
		System.out.println("Please select an option");
		System.out.println("1. Return Previous menu");
		System.out.println("2. Exit");
		System.out.print(" Option : ");
		scanned = reader.nextLine();

		optionBack = 0;
		try {
			optionBack = Integer.valueOf(scanned);
		} catch (Exception e) {
			System.out.println("Please insert an option");
		}
	}
	
	public void selectStock() {
        System.out.println("Select stock:");
        String list=tradeOp.getStockSymbolList();
        if(!"".equals(list)){
	        System.out.println(list);
	        String stockId = reader.nextLine();
	        if(tradeOp.existStock(stockId)){
	        	insertNewTrade(stockId);
	        }else{
	        	System.out.println("Please select a valid option stock!");
	        	 selectStock();
	        }
        }else{
        	System.out.println("Stock list is empty, please aquired data first!");
        }
    }
	
	public void insertNewTrade(String stockId){
		
		System.out.println("Insert quantitu");
        String quantity = reader.nextLine();
        System.out.println("Insert trade type (1:buy|2:sell):");
        String type = reader.nextLine();
        System.out.println("Insert trade price :");
        String price= reader.nextLine();
        try {
        	tradeOp.aquiredManualyData(stockId, quantity, type, price); 
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
