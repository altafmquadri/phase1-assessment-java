package business.logic;

import java.io.IOException;
import java.util.Scanner;

import business.interfaces.*;
import exceptions.DuplicateFileException;
import exceptions.FileNotInDirectoryException;
import exceptions.InvalidInputException;

public class Menu implements MenuInterface {

	public void showMainMenu() throws InvalidInputException {
		Scanner scan = new Scanner(System.in);

		System.out.println("\n\n*******************************************************************");
		System.out.println("\tWelcome to Company Locker Pvt Ltd...\n\n");

		System.out.println("\tThis program allows you to safely store your text documents."
				+ "\n\tYou'll be able to list out your files in alphabetical order,\n"
				+ "\tand delete any text files that are no longer needed...\n\n");

		System.out.println("\tWould you like to enter the application Y/N?");
		System.out.println("*******************************************************************");
		System.out.println("\t\t\t\t\t--developed by Altaf Quadri");
		System.out.println("\n Please enter your selection:\t");

		String enter = scan.nextLine().toLowerCase();

		try {
			if (enter.equals("y")) {
				showSubMenu();
			} else if (enter.equals("n")) {
				System.out.println("Thanks for visiting Company Locker Pvt Ltd...");
			} else {
				throw new InvalidInputException("Please a select valid choice!");
			}
		} catch (InvalidInputException e) {
			System.err.println(e.getMessage());
			showMainMenu();
		}
	}

	public void showSubMenu() {
		Scanner scan = new Scanner(System.in);
		int counter = 0;
		while (counter == 0) {
			System.out.println("*******************************************************************");
			System.out.println("*******************************************************************");
			System.out.println("\n\tPlease press (1) to show files for the system\n");
			System.out.println("\tPlease press (2) to add a file\n");
			System.out.println("\tPlease press (3) to delete a file\n");
			System.out.println("\tPlease press (4) to return to main menu\n");
			System.out.println("*******************************************************************");
			System.out.println("*******************************************************************");
			System.out.println("\nPlease provide your entry:\t");
			String choice = scan.nextLine();
			FileClass myFile = new FileClass();

			try {

				if (choice.equals("1")) {
					myFile.showFileList();
				}

				else if (choice.equals("2")) {
					try {
						myFile.add();
					} catch (DuplicateFileException e) {
						System.err.println(e.getMessage());
					} catch (IOException e) {
						System.err.println("You need to input a filename!");
					}
				}

				else if (choice.equals("3")) {
					try {
						myFile.remove();
					} catch (FileNotInDirectoryException e) {
						System.err.println(e.getMessage());
					}
				}

				else if (choice.equals("4")) {
					counter++;
				} else {
					throw new InvalidInputException("Please select a valid option from 1-4");
				}
			} catch (InvalidInputException e) {
				System.err.println(e.getMessage());
			}

		} // end while
		try {
			showMainMenu();
		} catch (InvalidInputException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
