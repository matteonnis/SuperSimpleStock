package it.jpmorgan.ui;

import it.jpmorgan.ui.UIScan;
import it.jpmorgn.operation.StockOperation;

import java.util.Scanner;

/**
 * @author Matteo Onnis
 * @mail matteonnis@gmail.com
 * 
 */
public class StockUI extends UIScan {

	private static Integer option = 0;
	private static Integer optionBack = 0;
	StockOperation stockOp = new StockOperation();

	
	public StockUI(Scanner reader) {
		super(reader);
	}

	public void execute(String scanned, Scanner reader) {
		showMenuStock(scanned, reader);
		switch (option) {
		case 1:
			stockOp.aquiredJsonData();
			break;
		case 2:
			insertNewStock();
			break;
		case 3:
			stockOp.calculatePrice();
			break;
		case 4:
			stockOp.seeData();
			break;
		case 5:
			GeneralUI.execute(scanned, reader);
			break;
		default:
			System.out.println("Insert a valid option");
			break;
		}
		executeBackMenu(scanned, reader);
	}

	public void showMenuStock(String scanned, Scanner reader) {
		System.out.println("Please select a Stock option");
		System.out.println("  1. Aquire stock data to JSON ");
		System.out.println("  2. Aquire manualy stock data ");
		System.out.println("  3. Calculate Stock Price ");
		System.out.println("  4. See stock data ");
		System.out.println("  5. Retutn to previus menu ");
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

	public void insertNewStock() {
		System.out.println("Insert stock symbol:");
		String symbol = reader.nextLine();
		System.out.println("Insert stock type (1:common|2:preferred):");
		String type = reader.nextLine();
		System.out.println("Insert stock last dividend:");
		String lastDividend = reader.nextLine();
		System.out.println("Insert stock fixed dividend :");
		String fixedDividend = reader.nextLine();
		System.out.println("Insert stock par value:");
		String parValue = reader.nextLine();
		System.out.println("Insert stock Ticker price:");
		String price = reader.nextLine();
		try {
			stockOp.aquiredManualyData(symbol, type, lastDividend,
					fixedDividend, parValue, price);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
