package jacklaiu.utils;

public class ArrayUtils {
	
	public static void exchangeElem(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{0,1,2};
		ArrayUtils.exchangeElem(arr, 0, 2);
		for(int num: arr) {
			System.out.println(num);
		}
	}
	public static void printArray(int[] array) {  
        System.out.print("{");  
        for (int i = 0; i < array.length; i++) {  
            System.out.print(array[i]);  
            if (i < array.length - 1) {  
                System.out.print(", ");  
            }  
        }  
        System.out.println("}");  
    }

}
