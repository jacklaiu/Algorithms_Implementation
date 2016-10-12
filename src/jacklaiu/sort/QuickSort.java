package jacklaiu.sort;

import jacklaiu.utils.ArrayUtils;

public class QuickSort {
	
	public static void main(String[] args) {
		int[] arr = {9,8,12,0,3,4,8,11,132,45,21,7};
		quickSort(arr);
		for(int num:  arr) {
			System.out.println(num);
		}
	}
	
	private static void quickSort(int[] arr) {
		subQuickSort(arr, 0, arr.length - 1);
	}
	
	private static void subQuickSort(int[] arr, int start, int end) {
		if(arr == null || (end - start + 1) < 2) {
			return;
		}
		int part = partition(arr, start, end);
		if(start + 1 == part) {
			subQuickSort(arr, part + 1, end);
		}else if(end - 1 == part) {
			subQuickSort(arr, start, part - 1);
		}else {
			subQuickSort(arr, start, part - 1);
			subQuickSort(arr, part + 1, end);
		}
	}

	private static int partition(int[] arr, int start, int end) {
		int index = start - 1;
		int flag = arr[end];
		for(int i = start; i < end; i++) {
			if(arr[i] < flag) {
				index++;
				if(index != i) {
					ArrayUtils.exchangeElem(arr, index, i);
				}
			}
		}
		if(index + 1 != end) {
			ArrayUtils.exchangeElem(arr, index + 1, end);
		}
		return index + 1;
	}
	
	
}
