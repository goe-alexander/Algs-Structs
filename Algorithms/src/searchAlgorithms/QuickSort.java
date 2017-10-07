package searchAlgorithms;

public class QuickSort {
	private int[] numbers;
	private int length;

	public void sort(int[] values) {
		if (values == null || values.length == 0)
			return;

		this.numbers = values;
		length = values.length;
		quickSort(0, length - 1);
	}

	public void quickSort(int low, int high) {
		int i = low, j = high;
		// Find the pivot fromt he middle
		int pivot = numbers[low + (high - low) / 2];

		// partition
		while (i <= j) {
			/*
			 * Starting from both ends we check to see if coresponding values
			 * are bigger or lesser If standard rule applies we increment left
			 * and decrement right
			 */
			while (numbers[i] < pivot) {
				i++;
			}
			while (numbers[j] > pivot) {
				j--;
			}

			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
			// we do the same for smaller datasets that we create using the
			// pivot
			if (low < j)
				quickSort(low, j);
			if (i < high)
				quickSort(i, high);

		}
	}

	private void exchange(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	public static void main(String[] args) {
		// Testing the quick SORT
		int[] original = { 123, 21, 2312, 23, 123, 123, -2123, 1, 0, 12, 3, 2, 512, };
		for(int curr : original){
			System.out.print(curr + ", ");
		}
		
		System.out.println("Sorted Array");
		QuickSort sortThis = new QuickSort();
		sortThis.sort(original);
		for(int curr : original){
			System.out.print(curr + ", ");
		}
		
		
		
	}
}
