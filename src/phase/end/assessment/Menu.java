package phase.end.assessment;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

	public void showMainMenu() throws IOException {
		Scanner scan = new Scanner(System.in);
		
		
		System.out.println("\n\n*******************************************************************");
		System.out.println("\tWelcome to Company Locker Pvt Ltd...\n\n");

		System.out.println("\tThis program will allow you to safely store your documents"
				+ "\n\twhich you can later retrieve from anywhere.  Any documents\n"
				+ "\tthat have outlived their purpose can be deleted.\n\n");

		System.out.println("\tWould you like to enter the application y/n?");
		System.out.println("*******************************************************************");
		System.out.println("\t\t\t\t\tdeveloped by Altaf Quadri");
		System.out.println("\nYour selection:\t");
		
		 
		String enter = scan.nextLine().toLowerCase();
		if (enter.equals("y")) {
			showSubMenu();			
		} else {
			System.out.println("Thanks for visiting Company Locker Pvt Ltd...");
		}
	}

	public void showSubMenu() throws IOException {
		Scanner scan = new Scanner(System.in);
		int counter = 0;
		while (counter ==0) {
			System.out.println("*******************************************************************");
			System.out.println("*******************************************************************");
			System.out.println("\n\tPlease press (1) to show files for the system");
			System.out.println("\tPlease press (2) to add a file");
			System.out.println("\tPlease press (3) to delete a file");
			System.out.println("\tPlease press (4) to return to main menu\n");
			System.out.println("*******************************************************************");
			System.out.println("*******************************************************************");
			System.out.println("\nYour entry:\t");
			int choice = Integer.parseInt(scan.nextLine());
			
			if (choice == 1) {
				FileClass myFile = new FileClass();
				myFile.showFileList();
			}

			if (choice == 2) {
				FileClass myFile = new FileClass();
				myFile.add();
			}

			if (choice == 3) {
				FileClass myFile = new FileClass();
				myFile.remove();
			}
			
			if (choice == 4) {
				counter++;
			}
		}
		showMainMenu();
	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		try {
			menu.showMainMenu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	
	
