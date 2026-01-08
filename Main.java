import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int[] array = twoNumberSum2(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10);
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

    public static int[] twoNumberSum(int[] array, int targetSum) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == targetSum) {
                    return new int[]{array[i], array[j]};
                }
            }
        }
        return new int[0];
    }

    public static int[] twoNumberSum2(int[] array, int targetSum) {
        HashSet<Integer> traversedElem = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if(traversedElem.contains(targetSum - array[i])){
                return new int[]{array[i], targetSum - array[i]};
            }else{
                traversedElem.add(array[i]);
            }
        }
        return new int[0];
    }
}