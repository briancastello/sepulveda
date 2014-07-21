package parsegarb;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * @author Watson
 * 
 * Still Under Super Heavy Construction. 
 *
 */
public class DifferentialSet {
	private ArrayList<Date> lst;
	private HashMap<Date, ConnectionSet> map;
	
	
	public DifferentialSet(ArrayList<ConnectionSet> connectionls) {
		
		for(ConnectionSet cs:connectionls){
			lst.add(cs.getDate());
			map.put(cs.getDate(), cs);
		}
	}
	
	
	
}
