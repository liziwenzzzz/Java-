package one;
import java.util.Calendar;
import java.util.Scanner;

public class rili {
	static int year, month, day;
	static final String[] weeks = { "sun", "mon", "tue", "wed", "tus", "fri", "sat" };
	static final String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
			"Dec" };

	public static int getWeek(int year, int month, int day) {
		Calendar first = Calendar.getInstance();
		first.set(year, month - 1, day);
		int w = first.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0) {
			w = 0;
		}
		return w;
	}

	public static void PrintCalendar(int year) {
		Calendar cal = Calendar.getInstance();
		for (int i = 0; i < 12; i++) {
			System.out.println("\t" + months[i]);
			System.out.println(" sun " + "mon " + "tue " + "wed " + "tus " + "fri " + "sat ");
			int space = getWeek(year, i + 1, 1);
			int wrap = 0;
			for (int j = 0; j < space; j++) {
				wrap++;
				System.out.print("    ");
			}
			cal.set(year, i, 1);
			int daysEveryMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			for (int j = 1; j <= daysEveryMonth; j++) {
				wrap++;
				System.out.printf("%4d", j);
				if (wrap % 7 == 0) {
					System.out.println();
				}
			}
			System.out.println();
		}

	}

	/**
	 * 得到指定月的天数 http://blog.csdn.net/hpf911/article/details/5909963
	 */
	public static int getMonthLastDay(int year, int month) {
		Calendar a = Calendar.getInstance();
		a.set(Calendar.YEAR, year);
		a.set(Calendar.MONTH, month - 1);
		a.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		a.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("1.输入年份,得到日历 *** 2.输入日期，得到星期***3.exit");

		int flag = input.nextInt();
		while (flag != 3) {
			if (flag == 1) {
				System.out.println("please input year:");
				year = input.nextInt();
				System.out.println("the " + year + " year's calendar as follow:");
				PrintCalendar(year);
			} else if (flag == 2) {
				System.out.println("input year:");
				year = input.nextInt();

				System.out.println("input month(1--12):");
				do {
					month = input.nextInt();
					if (month > 12 || month < 1) {
						System.out.println("WRONG! the month is (1--12).Again:");
					} else {
						break;
					}
				} while (true);

				System.out.println("input day(1--" + getMonthLastDay(year, month) + "):");
				do {
					day = input.nextInt();
					if (day < 1 || day > getMonthLastDay(year, month)) {
						System.out.println("WRONG! the day is (1--" + getMonthLastDay(year, month) + ").Again:");
					} else
						break;
				} while (true);

				int w = getWeek(year, month, day);
				System.out.printf("%d年%d月%d日是%s\n", year, month, day, weeks[w]);
			}
			System.out.println();
			System.out.println("1.输入年份 *** 2.输入日期***3.exit");

			flag = input.nextInt();
		}
		System.out.println("exit successfully");
	}

}
