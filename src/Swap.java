/*
 * public static void swapPairs(int[] arr)

that takes a reference to an array of integers arr and swaps adjacent pairs of elements: arr[0] with arr[1], arr[2] with arr[3], etc. For example, consider this array:

int[] values = {0, 2, 4, 6, 8, 10};

After calling swapPairs(values), the contents of the values array should be {2, 0, 6, 4, 10, 8}. In an odd-length array, the last element should not be moved. If the parameter is null, the method should throw an IllegalArgumentException.
 * */

public class Swap {

	public static void swapPairs(int[] arr) {
		try {

			if (arr == null) {
				throw new IllegalArgumentException("This is illegality!");
			}

			for (int i = 0; i < arr.length; i += 2) {
				if (arr.length % 2 == 0) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				} else if (i != arr.length - 1) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}

			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + ",");
			}
			System.out.println();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		try {

			int[] values = { 0, 2, 4, 6, 8, 10 };
			int[] valuesOddLength = { 0, 2, 4, 6, 8, 10, 98 };
			int[] valuesNull = null;

			Swap.swapPairs(values);
			Swap.swapPairs(valuesOddLength);
			Swap.swapPairs(valuesNull);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}