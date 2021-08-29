
/*
 * Date.java - a blueprint class for objects that represent
 * an individual date.
 */

public class Date {
	/* a class constant for the smallest allowed year */
	public static final int MIN_YEAR = 1583;

	private int month;
	private int day;
	private int year;

	public Date(int month, int day, int year) throws Exception {
		// try {

		if (year < Date.MIN_YEAR) {
			throw new Exception("The minimum year is 1583");
		} else if (month < 1 || month > 12) {
			throw new Exception(
				"Month error: month should be a number between 1 and 12");
		} else if (day < 1 || day > numDaysInMonth(month, year)) {
			throw new Exception(
				"Day should be a number greater than one... and less than the days on that month");
		}

		this.month = month;
		this.day = day;
		this.year = year;
		// } catch (Exception e) {
		// // e.printStackTrace();
		// System.out.println(e);
		// throw e;
		// }
	}

	// Accessor methods
	public int getMonth() {
		return this.month;
	}

	public int getDay() {
		return this.day;
	}

	public int getYear() {
		return this.year;
	}

	public String monthName() {
		return Date.MONTHS[this.month];
	}

	public String dayOfWeekName() {
		int numberDayOfWeek = Date.dayOfWeekNumber(this.month, this.day,
			this.year);
		return Date.DAYS_OF_WEEK[numberDayOfWeek];
	}

	public String toString() {
		return this.dayOfWeekName() + ", " + this.monthName() + " "
			+ this.getDay() + ", " + this.getYear();
	}

	public boolean equals(Date dateToCompare) {
		if (dateToCompare == null) {
			return false;
		}
		return this.toString().equals(dateToCompare.toString());
	}

	public boolean isBefore(Date dateToCompare) {
		if (dateToCompare == null || this.equals(dateToCompare)) {
			return false;
		}

		if (this.getYear() == dateToCompare.getYear()) {
			if (this.getMonth() == dateToCompare.getMonth()) {
				return this.getDay() < dateToCompare.getDay();
			}
			return this.getMonth() < dateToCompare.getMonth();
		}
		return this.getYear() < dateToCompare.getYear();
	}

	public boolean isAfter(Date dateToCompare) {
		if (dateToCompare == null || this.equals(dateToCompare)) {
			return false;
		}

		if (this.getYear() == dateToCompare.getYear()) {
			if (this.getMonth() == dateToCompare.getMonth()) {
				return this.getDay() > dateToCompare.getDay();
			}
			return this.getMonth() > dateToCompare.getMonth();
		}
		return this.getYear() > dateToCompare.getYear();
	}

	/*
	 * A class-constant array containing the names of the months. The positions
	 * of the names in the array correspond to the numbers of the months. For
	 * example, "January" is at position 1 in the array because its month number
	 * is 1, and "December" is in position 12 because its month number is 12.
	 * The string "none" appears in position 0, because there is no month that
	 * corresponds to the number 0.
	 */
	public static final String[] MONTHS = { "none", "January", "February",
		"March", "April", "May", "June", "July", "August", "September",
		"October", "November", "December" };

	/*
	 * A class-constant array containing the number of days in each month. Here
	 * again, the positions of the values correspond to the numbers of the
	 * months. For example, NUM_DAYS[1] is 31, because January (month 1) has 31
	 * days, and NUM_DAYS[2] is 28, because February usually has 28 days. -1
	 * appears in position 0, because there is no month that corresponds to the
	 * number 0.
	 */
	public static final int[] NUM_DAYS = { -1, 31, 28, 31, 30, 31, 30, 31, 31,
		30, 31, 30, 31 };

	/*
	 * A class-constant array containing the names of the days of the week.
	 */
	public static final String[] DAYS_OF_WEEK = { "Sunday", "Monday", "Tuesday",
		"Wednesday", "Thursday", "Friday", "Saturday" };

	/*
	 * dayOfWeekNumber - a static helper method that takes a month number, day
	 * number, and year as parameters, and returns the *number* of the day of
	 * the week on which the corresponding date falls: 0 for Sunday, 1 for
	 * Monday, 2 for Tuesday, etc. The algorithm for computing the appropriate
	 * number comes from Robert Sedgewick and Kevin Wayne.
	 */
	public static int dayOfWeekNumber(int month, int day, int year) {
		int y0 = year - (14 - month) / 12;
		int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
		int m0 = month + 12 * ((14 - month) / 12) - 2;

		return (day + x + (31 * m0) / 12) % 7;
	}

	/*
	 * Implement the rest of the class below, as specified in the assignment.
	 */

	public static boolean isLeapYear(int year) {
		boolean divisibleBy4 = year % 4 == 0;
		boolean divisibleBy100 = year % 100 == 0; // true
		boolean divisibleBy400 = year % 400 == 0; // false

		return divisibleBy4 && !(divisibleBy100 && !divisibleBy400);
		// if (divisibleBy4) {
		// return !(divisibleBy100 && !divisibleBy400);
		// // if (divisibleBy100 && !divisibleBy400 ) { return false; }
		// // return true;
		// }
		// return false;
	}

	public static int numDaysInMonth(int month, int year) {
		// if it is a leap year and the month is 2, return 29
		// otherwise return the days in the month
		boolean isLeapYear = Date.isLeapYear(year);
		if (isLeapYear && month == 2) {
			return 29;
		}
		return Date.NUM_DAYS[month];
	}

	public static void main(String[] args) throws Exception {

		Date myDate = new Date(10, 9, 1953);
		Date mySecondDate = new Date(10, 9, 1953);

		System.out.println("");
		System.out.println(myDate.isBefore(mySecondDate));
	}
}
