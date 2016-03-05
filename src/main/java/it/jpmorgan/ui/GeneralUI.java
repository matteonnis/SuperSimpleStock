package it.jpmorgan.ui;

import java.util.Scanner;

/**
 * @author Matteo Onnis
 * @mail matteonnis@gmail.com
 * 
 */

public class GeneralUI {

	private static Integer option = 0;

	public static void execute(String scanned, Scanner reader) {
		showMenu(scanned, reader);
		switch (option) {
			case 1:
				StockUI stockUi = new StockUI(reader);
				stockUi.execute(scanned, reader);
				break;
			case 2:
				TradeUI tradeUi = new TradeUI(reader);
				tradeUi.execute(scanned, reader);
				break;
			case 3:
				GbceUI  gbceUI = new GbceUI(reader);
				gbceUI.showAllShareIndex(scanned, reader);
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
	public static void showMenu(String scanned, Scanner reader) {
		System.out.println("Please select an option");
		System.out.println("1. Stock");
		System.out.println("2. Trade");
		System.out.println("3. Calculate GBCE All Share Index");
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

}
