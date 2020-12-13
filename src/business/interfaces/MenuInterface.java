package business.interfaces;

import exceptions.InvalidInputException;

public interface MenuInterface {
	
	public void showMainMenu() throws InvalidInputException;
	public void showSubMenu();
}
