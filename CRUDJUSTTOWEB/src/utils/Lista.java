package utils;

import java.util.ArrayList;
import java.util.List;

public class Lista {
	private static List<String> ufs = new ArrayList<>(  
			  List.of("AC","AL","AM","AP","BA","CE","DF","ES","GO","MA","MG","MS","MT","PA","PB","PE","PI",
			"PR","RJ","RN","RO","RR","RS","SC","SE","SP","TO"));

	public static List<String> getUfs() {
		return ufs;
	}
	
}
