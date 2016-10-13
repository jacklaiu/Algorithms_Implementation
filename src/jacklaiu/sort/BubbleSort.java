package jacklaiu.sort;

import jacklaiu.utils.ArrayUtils;

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] arr = {9,8,12,0,3,4,8,11,132,45,21,7};
		bubbleSort(arr);
		for(int n: arr) {
			System.out.println(n);
		}
	}
	
	public static void bubbleSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 1; j < arr.length - i; j++) {
				if(arr[j-1] > arr[j]) {
					ArrayUtils.exchangeElem(arr, j-1, j);
				}
			}
		}
	}

}
