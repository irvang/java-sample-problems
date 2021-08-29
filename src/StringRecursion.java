
public class StringRecursion {

	public static void printWithSpaces(String str) {
		if (str == null || str == "") {
			System.out.println();
			return;
		}
		System.out.print(str.charAt(0) + " ");
		if (str.length() > 1) {
			printWithSpaces(str.substring(1));
		} else {
			printWithSpaces("");
		}
	}

	public static String weave(String str1, String str2) throws IllegalArgumentException {
		if (str1 == null || str2 == null) {
			throw new IllegalArgumentException("++++ ILLEGAL NULL ARGUMENT");
		} else if (str1 == "") {
			return str2;
		} else if (str2 == "") {
			return str1;
		}

		String newWeave = str1.charAt(0) + "" + str2.charAt(0);
		String str1Sub = str1.substring(1);
		String str2Sub = str2.substring(1);
		int str1Length = str1.length();
		int str2Length = str2.length();

		if (str1Length > 1 && str2Length > 1) {
			return newWeave + weave(str1Sub, str2Sub);
		} else if (str1Length == 0 && str2Length > 1) {
			return newWeave + weave("", str2Sub);
		} else if (str1Length > 1 && str2Length == 1) {
			return newWeave + weave(str1Sub, "");
		} else {
			return newWeave + weave("", "");
		}
	}

	public static int indexOf(char ch, String str) {
		if (str == "" || str == null) {
			return -1;
		}

		// str = str
		// flip it, check if at end, flip again
		int length = str.length();

		System.out.println("length is " + length + ", " + str.charAt(length - 1));

		if (str.charAt(length - 1) == ch) {
			return length - 1;
		} else {
			System.out.println(str.substring(0, length - 1));
			return indexOf(ch, str.substring(0, length - 1));
		}
	}

	public static void main(String[] args) {
		// System.out.println();
		// StringRecursion.printWithSpaces("lonely");
		// StringRecursion.printWithSpaces("space");
		// StringRecursion.printWithSpaces(null);
		// StringRecursion.printWithSpaces("");
		// System.out.println();
		// System.out.println(weave("aaaa", "bbbb"));
		// System.out.println(weave("hello", "world"));
		// System.out.println(weave("recurse", "NOW"));
		// System.out.println(weave("hello", ""));
		// System.out.println(weave("", ""));
		// System.out.println(weave("hello", null));
		System.out.println(

				indexOf('b', "Rabbit")// should return 2
		);
		// indexOf('P', "Rabbit");// should return -1

	}

}
