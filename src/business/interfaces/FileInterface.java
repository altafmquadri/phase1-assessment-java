package business.interfaces;

import java.io.IOException;

import exceptions.DuplicateFileException;
import exceptions.FileNotInDirectoryException;

public interface FileInterface {
	public void showFileList();
	public void remove() throws FileNotInDirectoryException;
	public void add() throws DuplicateFileException, IOException;
}
