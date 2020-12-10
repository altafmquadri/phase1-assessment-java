package phase.end.assessment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileClass {

	public static List<String> fileList = new ArrayList<>();
	
	public void showFileList() {
		if (fileList.isEmpty()) System.out.println("The current directory does not contain any files");
		Collections.sort(fileList, String.CASE_INSENSITIVE_ORDER);
		fileList.forEach(f -> System.out.println(f));
	}
	
	public void hardCodeText() { //capital affects it
		fileList.add("taxes.txt");
		fileList.add("employee.txt");
		fileList.add("students.txt");
		fileList.add("friends.txt");
		fileList.add("Students.txt");
	}
	
	public void add() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the name of the file you would like to add");
		String fileName = scan.nextLine();
		fileList.add(fileName);
		System.out.println("The " +fileName + " file has successfully been added");
		
	}
	
	public void remove() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter the name of the file you would like to delete");
		
		String fileName = scan.nextLine();
		
		if (fileList.contains(fileName)) {
			fileList.remove(fileName);
			System.out.println("The " + fileName + " was deleted!");
		} else {
			System.out.println("That file name was not found");
		}
	}

	public static List<String> getFileList() {
		return fileList;
	}

	
	
	
}
