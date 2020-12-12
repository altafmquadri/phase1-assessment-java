package phase.end.interfaces;

import java.io.IOException;

import phase.end.exceptions.DuplicateFileException;
import phase.end.exceptions.FileNotInDirectoryException;

public interface FileInterface {
	public void showFileList();
	public void remove() throws FileNotInDirectoryException;
	public void add() throws DuplicateFileException, IOException;
}
