package AccountGenerator;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
/**
 * Given an array, write a function to identify the sub-array with the
 * maximum sum. The function should accept an array of integers as input
 * and return an array of integers as the output.
 * For example if the input is [1, -3, 5, -2, 9, -8, -6, 4] the
 * output would be [5, -2, 9]
 * Input: [1, -3, 5, -2, 9, -8, -6, 4]
 * Output: [5, -2, 9]
 */

public class test {
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java 8.");

    for (String string : strings) {
      System.out.println(string);
    }
    
    int[] a = {1, -3, 5, -2, 9, -8, -6, 4};
    maxSubArrayProblem m = new maxSubArrayProblem();
    int[] b = m.findSum(a, 0, a.length-1);
    System.out.println();
    System.out.print("[");
    for(int i=0; i<b.length; i++){
      System.out.print(b[i]+", ");
    }
    System.out.print("]");
  }
}

class maxSubArrayProblem{
  public int[] findSum(int[] a, int left, int right){
    /*This is the maximum sub array problem.
    One way of solving this is by following divide and conqure approach.
    
    Approach would be as follows:
    
    1. Split the array into two subarrays.
    2. Call the sub arrays recursively.
    3. Find the maximum suffix sum on left array and maximum prefix sum on the right
      array.    
    */
    if(left == right) return a;
    
    int mid = (left+right)/2;
    
    findSum(a, left, mid);
    findSum(a, mid+1, right);
    
    int leftMax = a[mid];
    int leftIndex = mid;
    
    int rightMax = a[mid+1];
    int rightIndex = mid+1;
    
    leftIndex = leftIndex(a, mid, left, leftMax);
    rightIndex = rightIndex(a, mid, right, rightMax);
    
    return Arrays.copyOfRange(a, leftIndex, rightIndex+1);
    
  }
  
  public int leftIndex(int[] a, int mid, int left, int leftMax){
    
    int temp = 0;
    int lIndex = mid;
    
    for(int i=mid; i>=left; i--){
      
      temp = temp+a[i];
      
      if(temp > leftMax){
        leftMax = temp;
        lIndex = i;
      }
      
    }
    
    return lIndex;
  }
  
  public int rightIndex(int[] a, int mid, int right, int rightMax){
    int temp = 0;
    int rIndex = mid;
    
    for(int i=mid; i<=right; i++){
      
      temp = temp+a[i];
      
      if(temp > rightMax){
        rightMax = temp;
        rIndex = i;
      }
      
    }
    
    return rIndex;
  }
  
}