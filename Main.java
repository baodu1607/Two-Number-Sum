import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int[] array = twoNumberSum3(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 13);
        if (array.length == 0) {
            System.out.println("No two numbers found.");
        }else{
            for (int j : array) {
                System.out.println(j);
            }
        }
    }
    /*Write a func that takes in a non-empty array of distinct integers and an integer representing
    a target sum. If any two numbers in the input array sum up to the target sum, the function should
    return them in an array, in any order. If no two numbers sum up to the target sum, the func
    should return an empty array.
    Note that the target sum has to be obtained by summing two different integers in the array;
    you can't add a single integer to itself in order to obtain the target sum.
    You can assume that there will be at most one pair of numbers summing up to the target sum.*/

    //O(n^2) time, O(1) space
    public static int[] twoNumberSum(int[] array, int targetSum) {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == targetSum) {
                    return new int[]{array[i], array[j]};
                }
            }
        }
        return new int[0];
    }

    // O(n) time, O(n) space
    public static int[] twoNumberSum2(int[] array, int targetSum) {
        HashSet<Integer> traversedElem = new HashSet<>();
        for (int j : array) {
            if (traversedElem.contains(targetSum - j)) {
                return new int[]{j, targetSum - j};
            } else {
                traversedElem.add(j);
            }
        }
        return new int[0];
    }

    //O(nlogn) time, O(1) space
    //it changes the origin array
    public static int[] twoNumberSum3(int[] array, int targetSum) {
        Arrays.sort(array); //dual-pivot quicksort
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int currentSum = array[left] + array[right];
            if(currentSum == targetSum){
                return new int[]{array[left], array[right]};
            }else if(currentSum < targetSum){
                left++;
            }else{
                right--;
            }
        }
        return new int[0];
    }
}