package me.werewolf2;

import java.util.Comparator;
import java.util.HashMap;

public class valueComparator implements Comparator<String> {
	HashMap<String, Integer> map = new HashMap<String,Integer>();
	
	public valueComparator(HashMap<String, Integer> map) {
		this.map.putAll(map);
	}

	public int compare(String arg0, String arg1) {
		if(map.get(arg0) >= map.get(arg1)) {
			return -1;
		}else{
			return 1;
		}
	}
	
	

}
