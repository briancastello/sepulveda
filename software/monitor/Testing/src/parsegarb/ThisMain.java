package parsegarb;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Watson
 * 
 * Still Under Heavy Construction. 
 *
 */
public class ThisMain {

	public static void main(String[] args) {
		ArrayList<File> al = new ArrayList<File>();
		ArrayList<ConnectionSet> test = new ArrayList<ConnectionSet>();
		File logfld = new File(
				"C:\\Users\\assessor\\Desktop\\netstat_capt\\logs\\assessor");
		try {
			for (File f : logfld.listFiles()) {
				al.add(f);
			}
			for (File f : al) {
				if (f.isFile()) {
					String st = f.getName().substring(8).substring(0, 22);
					//System.out.println(st);
					Date d = new SimpleDateFormat("MM-dd-yyyy@HH-mm-ss.SS").parse(st);
					//System.out.println(d.toString());
					test.add(new ConnectionSet(f,d));
				}
			}
			
			System.out.println(test.get(0).compareTo(test.get(1)));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	
	
	
	

}
