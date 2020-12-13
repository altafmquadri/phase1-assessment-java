package application;

import business.logic.Menu;
import exceptions.InvalidInputException;

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
