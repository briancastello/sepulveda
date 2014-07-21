package parsegarb;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import watson.files.Texter;

/**
 * @author Watson
 * 
 * Still Under Heavy Construction. 
 *
 */
public class ConnectionSet implements Comparable<ConnectionSet> {
	private ArrayList<ConnectionHolder> ch;
	private Date d;

	public ConnectionSet(Date date) throws ParseException {
		this.ch = new ArrayList<ConnectionHolder>();
		this.d = date;
	}

	public ConnectionSet(File file, Date date) throws IOException, ParseException {
		this.ch = parsereturn(file);
		this.d = date;
	}

	public static ArrayList<ConnectionHolder> parsereturn(File f)
			throws IOException {
		Texter tx = new Texter();
		ArrayList<String> al = tx.readByLine(f);
		ArrayList<ConnectionHolder> cl = new ArrayList<ConnectionHolder>();
		if (f.getName().contains("ntst")) {
			for (String s : al) {
				// System.out.println(s);
				if (s.contains("TCP") || s.contains("UDP")) {
					// System.out.println(s);
					ArrayList<String> arr = new ArrayList<String>();
					arr.addAll(Arrays.asList(s.trim().split("\\s+")));
					ConnectionHolder cn = new ConnectionHolder();
					cn.setProtocol(arr.get(0));
					String[] localadd = splitAddPrt(arr.get(1));
					cn.setLocalAddress(localadd[0]);
					cn.setLocalPort(localadd[1]);
					String[] foreignadd = splitAddPrt(arr.get(2));
					cn.setForeignAddress(foreignadd[0]);
					cn.setForeignPort(foreignadd[1]);
					if (!cn.getProtocol().equals("UDP")) {
						cn.setState(arr.get(3));
						cn.setPID(arr.get(4));
					} else {
						cn.setPID(arr.get(3));
					}
					//System.out.println(cn.toString());
					cl.add(cn);
				}
			}
		}
		return cl;

	}

	private static String[] splitAddPrt(String Address) {
		int thing = Address.lastIndexOf(':');
		String[] result = new String[2];
		result[0] = Address.substring(0, thing);
		result[1] = Address.substring(thing + 1);
		return result;
	}

	/** 
	 * 0 is equal, Positive means main value is greater, Negative means second value is greater.
	 */
	@Override
	public int compareTo(ConnectionSet o) {
		ArrayList<ConnectionHolder> copy = new ArrayList<ConnectionHolder>();
		ArrayList<ConnectionHolder> test= new ArrayList<ConnectionHolder>();
		
		for(ConnectionHolder h:o.getCh()){
			copy.add(h);
		}
		for(ConnectionHolder h:ch){
			boolean flag = false;
			for(int a = 0, b = test.size();a<copy.size()||test.size()!=b;a++ ){
				if(copy.get(a).equals(h)) {
					copy.remove(a);
					a = copy.size();
					flag = true;
				}
			}
			if(!flag){
				test.add(h);
			}	
		}
		return test.size()-copy.size();
	}
	
	

	public void add(ConnectionHolder con) {
		ch.add(con);
	}

	public ArrayList<ConnectionHolder> getCh() {
		return ch;
	}

	public void Clear() {
		ch.clear();
	}
	
	public int size(){
		return ch.size();
	}

	public Date getDate() {
		return d;
	}

	public void setDate(Date date) {
		this.d = date;
	}
	
	

}
