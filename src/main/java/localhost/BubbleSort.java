package localhost;

import java.util.Arrays;

public class BubbleSort {

	private static final boolean DEBUG = false;

	/**
	 * Bubble sort.
	 * <p>
	 * Time complexity: O(n2)
	 * <p>
	 * Good:
	 * - Space efficient.
	 * <p>
	 * Bad:
	 * - High cpu time.
	 * - Moderate number of writes.
	 * - A stable sort -- equal elements are not re-arranged.
	 * - Uses O(1) extra space for temp storage.
	 * - Adaptive -- stops early if the array is sorted before iterations are complete.
	 *
	 * @param array The array to sort.
	 * @return The same array, sorted.
	 */
	public static int[] sort(int[] array) {
		// Iterate {array.length} times.
		// Stop sorting early if the array is sorted before we're done.
		for (int i = 0; i < array.length; i++) {
			boolean swapped = false;

			if (DEBUG) System.out.println("Position: " + i);

			// Check all adjacent pairs of elements, from right to left.
			// Skip sorted elements on the left side of the array.
			for (int j = array.length - 1; j > i; j--) {
				if (array[j] < array[j - 1]) {
					swapElements(array, j, j - 1);
					swapped = true;

					if (DEBUG) printArray(array);
				}
			}

			// If no elements have been swapped, sorting is complete!
			if (!swapped) {
				if (DEBUG) System.out.println("No swaps. Stopping early.");
				break;
			}
		}

		return array;
	}

	/**
	 * Swap the position of two elements in an array, in-place.
	 *
	 * @param array The array.
	 * @param i     The first element's position index.
	 * @param j     The second element's position index.
	 * @return The same array given. We return a value for unit testing.
	 */
	protected static int[] swapElements(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;

		return array;
	}

	/**
	 * Print the contents of an array.
	 *
	 * @param array The array to print.
	 * @return The printed string. We return a value for unit testing.
	 */
	protected static String printArray(int[] array) {
		String message = "During: " + Arrays.toString(array);
		System.out.println(message);

		return message;
	}

}
