package me.werewolf2;

import java.util.Scanner;

public class Skipper {
	
	@SuppressWarnings({ "resource", "unused" })
	public static void skip() {
		
		Scanner s = new Scanner(System.in);
		String msg = s.next();
		Run.countdown = 3;
		
	}

}
