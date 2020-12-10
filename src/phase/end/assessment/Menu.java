package phase.end.assessment;

import java.util.Scanner;

public class Menu {

	public void showMenu() {
		System.out.println("Welcome to Company Locker Pvt Ltd...\n\n");
		System.out.println("developed by Altaf Quadri");
		
		System.out.println("This program will allow you to safely store your documents"
				+ "\nwhich you can later retrieve from anywhere.  Any documents that have\n"
				+ "outlived their purpose can be deleted.");
	}
	
	public int showChoices() {
		Scanner scan = new Scanner(System.in);
		int choice;
		System.out.println("\n\nPlease press 1 to show files for the system");
		System.out.println("Please press 2 to add a file");
		System.out.println("Please press 3 to add a file");
		
		choice = Integer.parseInt(scan.nextLine());
		
		
		return choice;
	}
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		int selection;
		menu.showMenu();
		
		selection = menu.showChoices();
		System.out.println(selection);
		
		if (selection == 1) {
			FileClass myFile = new FileClass();
			myFile.hardCodeText();
			myFile.showFileList();
		}
		
		if (selection == 2 ) {
			FileClass myFile = new FileClass();
			myFile.hardCodeText();
			myFile.add();
			myFile.showFileList();
		}
		
		if (selection == 3) {
			FileClass myFile = new FileClass();
			myFile.hardCodeText();
			myFile.remove();
			myFile.showFileList();
		}
	}
}
