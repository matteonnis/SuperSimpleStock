package it.jpmorgan.ui;

import it.jpmorgan.calculate.GeometricFormula;
import it.jpmorgan.ui.UIScan;

import java.util.Scanner;

/**
 * @author Matteo Onnis
 * @mail matteonnis@gmail.com
 * 
 */
public class GbceUI extends UIScan {

	private static Integer optionBack = 0;
		
	public GbceUI(Scanner reader) {
		super(reader);
	}

	public void showAllShareIndex(String scanned, Scanner reader) {
		System.out.println("GBCE All Share index : " +  GeometricFormula.execute());
		executeBackMenu(scanned, reader);
	}
	
	public static void executeBackMenu(String scanned, Scanner reader) {
		backMenu(scanned, reader);
		switch (optionBack) {
		case 1:
			GeneralUI.execute(scanned, reader);
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
}
