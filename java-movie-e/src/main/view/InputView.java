package main.view;

import java.util.Scanner;

import main.controller.MovieController;
import main.utils.InputUtil;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);
	
	public static int selectFunction() {
		try {
			System.out.println("\n## 원하는 기능을 선택하세요.");
			System.out.println("1.영화목록조회\n2.영화추가\n3.스케줄추가\n4.영화삭제\n5.스케줄삭제\n6.영화별 관객수조회\n7.영화예매\n8.예매취소\n9.스케줄별 관객정보조회\n10.종료");
			System.out.print(" >> ");
			int selectFunctionNum = InputUtil.getInt();
			//MovieController.checkVaildFunctionNum(selectFunctionNum);
			return selectFunctionNum;
		} catch (IllegalArgumentException e) {
			System.out.println(" >> 1번~8번 중 하나를 선택하세요.");
			return selectFunction();
		}
	}
	
	public static String createMovie() {
		try {
			System.out.println("## 영화정보를 입력하세요. (ID NAME PRICE)");
			String movieInfo = scanner.nextLine();
			MovieController.checkVaildMovieInfo(movieInfo);
			return movieInfo;
		} catch (Exception e) {
			System.out.println(" >> 형식에 맞게 입력하세요.");
			return createMovie();
		}
	}

	public static String createSchedule() {
		try {
			System.out.println("## 영화스케줄을 입력하세요. (yyyy-mm-dd 00:00_예약가능인원)");
			String scheduleInfo = scanner.nextLine();
			MovieController.checkVaildScheduleInfo(scheduleInfo);
			return scheduleInfo;
		} catch (IllegalArgumentException e) {
			System.out.println(" >> 형식에 맞게 입력하세요.");
			return createSchedule();
		} 		
	}

	public static int getMovieId() {
		try {
			System.out.println("## 영화ID를 입력하세요.");
			int movieId = InputUtil.getInt();
			MovieController.checkExistMovie(movieId);
			return movieId;
		} catch (Exception e) {
			System.out.println(" >> 영화목록에 없는 ID입니다.");
			return getMovieId();
		}
	}

	public static int getScheduleIndex() {
		System.out.println("## 스케줄을 선택하세요. (첫번째 상영시간이 1번)");
		int removeScheduleIndex = InputUtil.getInt();
		return removeScheduleIndex;
	}

	public static String createCustomer() {
		try {
			System.out.println("## 관객정보를 입력하세요. (ID 이름)");
			String customerInfo = scanner.nextLine();
			return customerInfo;
		} catch (Exception e) {
			System.out.println(" >> 형식에 맞게 입력하세요.");
			return createCustomer();
		}
	}

	public static int getCustomerIndex() {
		System.out.println("## 삭제할 관객을 선택하세요. (첫번째 관객이 1번)");
		int customerIndex = InputUtil.getInt();
		return customerIndex;
	}
}
