package phase.end.assessment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import phase.end.exceptions.DuplicateFileException;
import phase.end.exceptions.FileNotInDirectoryException;
import phase.end.exceptions.InvalidInputException;
import phase.end.interfaces.*;

public class FileClass implements FileInterface {

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
		if (!fileList.isEmpty()) System.out.println("Your files:");
		System.out.println("-------------------------------------------------------------------");
		fileList.forEach(file -> System.out.println(file));
		System.out.println("###################################################################");
	}

	public void add() throws DuplicateFileException, IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("*******************************************************************");
		System.out.println("*******************************************************************");
		System.out.println("*******************************************************************");
		System.out.println("\nPlease enter the name of the text file you would like to add:");
		
		
		String fileName = scan.nextLine();
		
		String regex = ".*\\.txt$";
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(fileName);
		boolean found = matcher.matches();
		
		try {
			if (!found) {
				throw new InvalidInputException("File names must end in .txt");
			} 
		} catch (InvalidInputException e) {
			System.err.println(e.getMessage());
			while (!found) {
				System.out.println("Please enter a file ending with (.txt)!");
				fileName = scan.nextLine();
				matcher = p.matcher(fileName);
				found = matcher.matches();
			}
		}
		
		File myFile = new File(fileName);
		//catch
		if (myFile.createNewFile()) {
			fileList.add(fileName);
			System.out.println("The " + fileName + " file has successfully been added");
		} else {
			throw new DuplicateFileException("This file already exists!");
		}
		System.out.println("*******************************************************************");
		System.out.println("*******************************************************************");
		System.out.println("*******************************************************************");
	}

	public void remove() throws FileNotInDirectoryException {
		System.out.println("*******************************************************************");
		System.out.println("*******************************************************************");
		System.out.println("*******************************************************************");
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the name of the text file you would like to delete:");

		String fileName = scan.nextLine();
		
		String regex = ".*\\.txt$";
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(fileName);
		boolean found = matcher.matches();
		
		try {
			if (!found) {
				throw new InvalidInputException("File names must end in .txt");
			} 
		} catch (InvalidInputException e) {
			System.err.println(e.getMessage());
			while (!found) {
				System.out.println("Please enter a file ending with.txt");
				fileName = scan.nextLine();
				matcher = p.matcher(fileName);
				found = matcher.matches();
			}
		}
		
		File myFile = new File(fileName);

		if (myFile.delete()) {
			syncLists();
			System.out.println("The " + fileName + " was deleted!");

		} else {
			throw new FileNotInDirectoryException("The file does not exist in the current directory!");
		}
		System.out.println("*******************************************************************");
		System.out.println("*******************************************************************");
		System.out.println("*******************************************************************");
	}
}
