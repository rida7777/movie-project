package main.view;

import java.util.Scanner;

import main.controller.MovieController;
import main.utils.InputUtil;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);
	
	public static int selectFunction() {
		try {
			System.out.println("\n## ���ϴ� ����� �����ϼ���.");
			System.out.println("1.��ȭ�����ȸ\n2.��ȭ�߰�\n3.�������߰�\n4.��ȭ����\n5.�����ٻ���\n6.��ȭ�� ��������ȸ\n7.��ȭ����\n8.�������\n9.�����ٺ� ����������ȸ\n10.����");
			System.out.print(" >> ");
			int selectFunctionNum = InputUtil.getInt();
			//MovieController.checkVaildFunctionNum(selectFunctionNum);
			return selectFunctionNum;
		} catch (IllegalArgumentException e) {
			System.out.println(" >> 1��~8�� �� �ϳ��� �����ϼ���.");
			return selectFunction();
		}
	}
	
	public static String createMovie() {
		try {
			System.out.println("## ��ȭ������ �Է��ϼ���. (ID NAME PRICE)");
			String movieInfo = scanner.nextLine();
			MovieController.checkVaildMovieInfo(movieInfo);
			return movieInfo;
		} catch (Exception e) {
			System.out.println(" >> ���Ŀ� �°� �Է��ϼ���.");
			return createMovie();
		}
	}

	public static String createSchedule() {
		try {
			System.out.println("## ��ȭ�������� �Է��ϼ���. (yyyy-mm-dd 00:00_���డ���ο�)");
			String scheduleInfo = scanner.nextLine();
			MovieController.checkVaildScheduleInfo(scheduleInfo);
			return scheduleInfo;
		} catch (IllegalArgumentException e) {
			System.out.println(" >> ���Ŀ� �°� �Է��ϼ���.");
			return createSchedule();
		} 		
	}

	public static int getMovieId() {
		try {
			System.out.println("## ��ȭID�� �Է��ϼ���.");
			int movieId = InputUtil.getInt();
			MovieController.checkExistMovie(movieId);
			return movieId;
		} catch (Exception e) {
			System.out.println(" >> ��ȭ��Ͽ� ���� ID�Դϴ�.");
			return getMovieId();
		}
	}

	public static int getScheduleIndex() {
		System.out.println("## �������� �����ϼ���. (ù��° �󿵽ð��� 1��)");
		int removeScheduleIndex = InputUtil.getInt();
		return removeScheduleIndex;
	}

	public static String createCustomer() {
		try {
			System.out.println("## ���������� �Է��ϼ���. (ID �̸�)");
			String customerInfo = scanner.nextLine();
			return customerInfo;
		} catch (Exception e) {
			System.out.println(" >> ���Ŀ� �°� �Է��ϼ���.");
			return createCustomer();
		}
	}

	public static int getCustomerIndex() {
		System.out.println("## ������ ������ �����ϼ���. (ù��° ������ 1��)");
		int customerIndex = InputUtil.getInt();
		return customerIndex;
	}
}
