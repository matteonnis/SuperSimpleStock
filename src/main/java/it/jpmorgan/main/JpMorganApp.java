package it.jpmorgan.main;

import it.jpmorgan.ui.GeneralUI;

import java.util.Scanner;

/**
 * @author Matteo Onnis
 * @mail matteonnis@gmail.com
 * JPMorgan Application Example
 *
 */
public class JpMorganApp {
    public static void main(String[] args) {
        System.out.println("Welcome to J&P Morgan portfolio:");
        Scanner reader = new Scanner(System.in);
        String scanned = reader.nextLine();
        GeneralUI.execute(scanned,reader);
    }
}
