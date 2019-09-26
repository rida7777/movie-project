package main.view;

import java.util.Scanner;

import main.domain.MovieController;
import main.utils.InputUtil;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);
	//��ɼ���
	public static int selectFunction() {
		try {
			System.out.println("\n## ���ϴ� ����� �����ϼ���.");
			System.out.println("1.��ȭ�����ȸ\n2.��ȭ�߰�\n3.�������߰�\n4.��ȭ����\n5.�����ٻ���\n6.����������ȸ\n7.��������ȸ\n8.����");
			System.out.print(" >> ");
			int selectFunctionNum = InputUtil.getInt();
			//MovieController.checkVaildFunctionNum(selectFunctionNum);
			return selectFunctionNum;
		} catch (IllegalArgumentException e) {
			System.out.println(" >> 1��~8�� �� �ϳ��� �����ϼ���.");
			return selectFunction();
		}
	}
	
	//1.��ȭ���� - ��ȭ����
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

	//1.��ȭ���� - ����������
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

	//2.����, 3.��������ȸ
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

}
