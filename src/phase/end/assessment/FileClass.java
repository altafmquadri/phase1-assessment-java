package phase.end.assessment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileClass {

	public static List<String> fileList = new ArrayList<>();

	public void syncLists() {
		List<String> pathnames = new ArrayList<>();
		File f = new File("./");
		pathnames = Arrays.asList(f.list());
		pathnames = pathnames.stream().filter(p -> p.endsWith(".txt")).collect(Collectors.toList());
		fileList.clear();
		fileList.addAll(pathnames);
	}

	public void showFileList() {
		System.out.println("*******************************************************************");
		System.out.println("*******************************************************************");
		System.out.println("*******************************************************************");
		syncLists();
		if (fileList.isEmpty())
			System.out.println("The current directory does not contain any files");
		Collections.sort(fileList, String.CASE_INSENSITIVE_ORDER);
		System.out.println("###################################################################");
		System.out.println("Your files:");
		System.out.println("-------------------------------------------------------------------");
		fileList.forEach(file -> System.out.println(file));
		System.out.println("###################################################################");
	}

	public void add() throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("*******************************************************************");
		System.out.println("*******************************************************************");
		System.out.println("*******************************************************************");
		System.out.println("\nPlease enter the name of the file you would like to add:");
		String fileName = scan.nextLine();
		File myFile = new File(fileName);
		if (myFile.createNewFile()) {
			fileList.add(fileName);
			System.out.println("The " + fileName + " file has successfully been added");
		} else {
			System.out.println("This file already exists");
		}
		System.out.println("*******************************************************************");
		System.out.println("*******************************************************************");
		System.out.println("*******************************************************************");

	}

	public void remove() {
		System.out.println("*******************************************************************");
		System.out.println("*******************************************************************");
		System.out.println("*******************************************************************");
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the name of the file you would like to delete");

		String fileName = scan.nextLine();
		File myFile = new File(fileName);

		if (myFile.delete()) {
			syncLists();
			System.out.println("The " + fileName + " was deleted!");

		} else {
			System.out.println("That file name was not found");
		}
	System.out.println("*******************************************************************");
	System.out.println("*******************************************************************");
	System.out.println("*******************************************************************");
	}
}
