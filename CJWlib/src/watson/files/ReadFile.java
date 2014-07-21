package watson.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Christopher Joseph Watson
 *
 * @purpose
 * 
 * @contains
 * Variables needed for proper operation:
 *
 * @methodsTo
 */
class ReadFile {
	private File file;
	private FileReader reader;
	
	ReadFile(File file) throws FileNotFoundException{
		this.file = file;
		reader = new FileReader(file);
	}
	
	ArrayList<String> readByLine() throws IOException{
		try{
		  BufferedReader br = new BufferedReader(reader);
		  ArrayList<String> al = new ArrayList<String>();
		  String strLine;
		  while ((strLine = br.readLine()) != null){
			  al.add(strLine);
		  }
		  br.close();
		  return al;
		}finally{
			reader.close();
		}
	}
	
	char[] readByCharArray() throws IOException{
		try{
		 BufferedReader br = new BufferedReader(reader);
		  char[] charArray = new char[(int) file.length()];
		  br.read(charArray);
		  br.close();
		  return charArray;
		} finally{
			reader.close();
		}
	}
}
