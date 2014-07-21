package watson.string;

import java.util.ArrayList;

public class Concat {
	public static String arrConcat(ArrayList<String> arr){
		String res = "";
		int i = 0;
		for(String s:arr){
			i++;
			if(i < arr.size()) res = res.concat(s + "\n");
			else res = res.concat(s);
		}
		return res;
	}

}
