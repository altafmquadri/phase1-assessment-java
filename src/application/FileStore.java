package application;

import phase.end.assessment.Menu;
import phase.end.exceptions.InvalidInputException;

public class FileStore {
	public static void main(String[] args) {
		Menu menu = new Menu();
		try {
			menu.showMainMenu();
		} catch (InvalidInputException e) {
			System.err.println(e.getMessage());
		}
	}
}
