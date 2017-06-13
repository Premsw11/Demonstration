package Pack1;

import java.util.HashSet;
import java.util.HashMap;

/************************************************************************************************************************
 * *********************************Dummy program is made to verify fwd/rvs entitlement API using HashMap ***************
*****************************************input is taken from output of ES and given into API*************************** */

public class HashMapExample {

	public static void main(String[] args) {
		HashMap<String,HashSet<String>> ES_MDF = new HashMap<String,HashSet<String>>();
		HashMap<String,HashSet<String>> ES_IfMDF = new HashMap<String,HashSet<String>>();
		
		String itmfamid ;
		String invitmid ;
		
		// while loop to iterate through all the records in response
		itmfamid = "101";
		invitmid = "1";
		String str = itmfamid + ";" + invitmid;
		ES_MDF.put("101,2",new HashSet<String>());
		ES_MDF.get("101,2").add("2");
		ES_MDF.get("101,2").add("2");
		
		if(ES_MDF.get(str) == null) {
			ES_MDF.put(str, new HashSet<String>());
			// while loop to get all the mdf values of a record
			ES_MDF.get(str).add("10");
			ES_MDF.get(str).add("11");
			ES_MDF.get(str).add("15");
			ES_MDF.get(str).add("15");
			ES_MDF.get(str).add("10");
		}
		else {
			// while loop to get all the mdf values of a record
			ES_MDF.get(str).add("20");
			ES_MDF.get(str).add("19");
			ES_MDF.get(str).add("2");
		}
		System.out.println("ES_MDF is :"+ES_MDF);
		System.out.println("ES_IfMDF HashMap  :"+ES_IfMDF);
		
		//Before it verify Login API 
		//for loop of mdf map to run in fwd and rvs API 
		
		for(String st : ES_MDF.keySet()) {
			System.out.println("value in each key :"+st+"  is  :"+ES_MDF.get(st));
			for(String s : ES_MDF.get(st)) {
				System.out.println("Each value in key  :"+st+ " is :"+s);
				// Here call API endpoint to verify
			}
		}
	
	}
	
}
