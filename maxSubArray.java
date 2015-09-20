package AccountGenerator;
import java.math.*;
import java.util.*;

public class maxSubArray {
	public static void main(String[] args){
		int[] a = {1, -3, 5, -2, 9, -8, -6, 4};
		subArray s = new subArray();
		int[] subArray = s.maxSubArrayHelperFunction(a, 0, a.length-1);
		for(int i=0; i<subArray.length; i++){
			System.out.println(subArray[i]);
		}
	}
}

class subArray{
	public int[] maxSubArrayHelperFunction(int A[], int left, int right) {
	        if(right == left) return A;
	        int middle = (left+right)/2;
	        maxSubArrayHelperFunction(A, left, middle);
	        maxSubArrayHelperFunction(A, middle+1, right);
	        int leftmax = A[middle];
	        int rightmax = A[middle+1];
	        int lIndex = middle;
	        int rIndex = middle+1;
	        lIndex = leftIndex(A, middle, left, leftmax);       
	        rIndex = rightIndex(A, middle+1, right, rightmax);
	        System.out.println("LIndex"+lIndex);
	        System.out.println("RIndex"+rIndex);
	        return Arrays.copyOfRange(A, lIndex, rIndex+1);
	    }
	public int rightIndex(int[] a, int p, int q, int rMax){
		int temp = 0;
		int rIndex = p;
		for(int i=p; i<= q; i++){
			temp = temp+a[i];
			if(temp > rMax){
				rMax = temp;
				rIndex = i;
			}
		}
		return rIndex;
	}
	public int leftIndex(int[] a, int middle, int left, int lMax){
		int temp = 0;
		int lIndex = middle;
		for(int i = middle; i>=left; i--){
			temp = temp+a[i];
			if(temp>lMax){
				lMax = temp;
				lIndex = i;
			}
		}
		return lIndex;
	}
}
