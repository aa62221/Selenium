package AutomationFramework;

import java.util.Arrays;

public class Class2 {
	
	public static void main(String[] args) {
		
		   int[] arr = {8, 5, 2, 4, 9, 6, 3, 1, 7};
	       int[] result = new int[arr.length];
	       int index = 0;
	        // Step 1: Copy evens in order
	        for (int num : arr) {
	            if (num % 2 == 0) {
	                result[index++] = num;
	            }
	        }
	        System.out.println(index);
	        // Step 2: Copy odds in order
	        for (int num : arr) {
	            if (num % 2 != 0) {
	                result[index++] = num;
	            }
	        }
	        System.out.println(Arrays.toString(result));
}
	
}
