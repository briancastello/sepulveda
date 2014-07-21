package watson.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
class WriteFile {
	//private File file;
	private FileWriter writer;
	
	WriteFile(File file) throws IOException{
		//this.file = file;
		writer = new FileWriter(file);
	}
	
	void writeByLine(ArrayList<String> lineList) throws IOException{
		try{
			BufferedWriter bw = new BufferedWriter(writer);
			for(String s:lineList){
				bw.append(s + "\n");
			}
			bw.flush();
			bw.close();
		}finally{
			writer.close();
		}
	}
	
	void writeAsIs(String toWrite) throws IOException{
		try{
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write(toWrite);
			bw.flush();
			bw.close();
		}finally{
			writer.close();
		}
	}
	
}
