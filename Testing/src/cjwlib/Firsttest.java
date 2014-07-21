package cjwlib;

import java.util.ArrayList;

import watson.string.Concat;

public class Firsttest {

	public static void main(String[] args) {
		ArrayList<String> results = new ArrayList<String>();
		results.add(Concat_arrConcat() + "==Concat.arrConcat");
		
		

		
		for(String s: results){
			System.out.println(s);
		}
	}
	
	private static String Concat_arrConcat(){
		String res = "";
		String cor = "1\n2\n3\n12\n2\n3\n4\n2\n3\n5\n2\n3";
		ArrayList<String> test = new ArrayList<String>();
		test.add("1");
		test.add("2");
		test.add("3");
		test.add("12");
		test.add("2");
		test.add("3");
		test.add("4");
		test.add("2");
		test.add("3");
		test.add("5");
		test.add("2");
		test.add("3");
		String s = Concat.arrConcat(test);
		if (s.equals(cor)){
			res = "Check!";
		}else{
			res = "ERROR!!!";
		}
		return res;
	}

}
