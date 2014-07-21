package watson.files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Christopher Joseph Watson
 * 
 * @purpose
 * 
 * @contains Variables needed for proper operation:
 * 
 * @methodsTo
 */
public class Texter {
	public ArrayList<String> readByLine(File file) throws IOException {
		ReadFile rf = new ReadFile(file);
		return rf.readByLine();
	}
	
	public char[] readByCharArray(File file) throws IOException{
		ReadFile rf = new ReadFile(file);
		return rf.readByCharArray();
	}

	public void writeByLine(File file, ArrayList<String> lines) throws IOException {
		WriteFile wf = new WriteFile(file);
		wf.writeByLine(lines);
	}

	public void writeAsIs(File file, String toWrite) throws IOException {
		WriteFile wf = new WriteFile(file);
		wf.writeAsIs(toWrite);
	}
	
	
}
