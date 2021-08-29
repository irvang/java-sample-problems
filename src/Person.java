public class Person {

	private String name;
	private Date dob;

	public Person(String name, Date dob) {
		try {
			if (name == null) {
				throw new Exception("Name cannot be null");
			} else if (dob == null) {
				throw new Exception("DOB cannot be null");
			}
			this.name = name;
			this.dob = dob;
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public String getName() {
		return this.name;
	}

	public Date getDOB() {
		return this.dob;
	}

	public Date getBirthdayIn(int year) {
		try {

			return new Date(this.dob.getMonth(), this.dob.getDay(), year);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.dob;
	}

	public int getAgeOn(Date date) {
		try {

			if (date.isBefore(this.dob)) {
				throw new Exception(
					"The date cannot be a time before the person's DOB");
			}

			Date birthdayOnYear = new Date(this.dob.getMonth(),
				this.dob.getDay(), date.getYear());

			// 10/5/2013
			// if date is before than birthdayOnYear, date.getYear() - this.dob
			// .getYear() -
			// 1
			if (date.isBefore(birthdayOnYear)) {
				return date.getYear() - this.dob.getYear() - 1;
			} else {
				return date.getYear() - this.dob.getYear();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	public String toString() {
		return this.name + " (born on " + this.dob.toString() + ")";
	}

	public static void main(String[] args) {
		try {

			Date july4 = new Date(7, 4, 2013);
			Date birthday = new Date(10, 5, 2013);
			Date thanksgiving = new Date(11, 28, 2013);
			Person kate = new Person("Kate Winslet", new Date(10, 5, 1975));

			System.out.println(kate.getAgeOn(july4));
			System.out.println(kate.getAgeOn(birthday));
			System.out.println(kate.getAgeOn(thanksgiving));
			System.out.println(kate.toString());
		} catch (Exception e) {
			System.out.println(e);

		}

	}
}
