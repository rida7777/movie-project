package main.utils;

import java.util.Scanner;

public class InputUtil {
	private final static Scanner SCANNER = new Scanner(System.in);
	
	public static int getInt() {
		try {
			return Integer.parseInt(SCANNER.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("���ڸ� �Է��ϼ���.");
			return getInt();
		}
	}
}
