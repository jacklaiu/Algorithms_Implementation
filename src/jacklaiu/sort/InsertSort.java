package jacklaiu.sort;

import jacklaiu.utils.ArrayUtils;

public class InsertSort {
	public static void insertSort(int[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		for (int i = 1; i < array.length; i++) {
			int currentValue = array[i];
			int position = i;
			for (int j = i - 1; j >= 0; j--) {
				if (array[j] > currentValue) {
					array[j + 1] = array[j];//Right Move
					position -= 1;
				} else {
					break;
				}
			}
			array[position] = currentValue;
		}
	}

	public static void main(String[] args) {
		int[] array = { 5,4,3,2,1,0 };
		ArrayUtils.printArray(array);
		insertSort(array);
		ArrayUtils.printArray(array);
	}
}