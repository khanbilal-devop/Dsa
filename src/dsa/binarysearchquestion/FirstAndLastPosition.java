package dsa.binarysearchquestion;

import java.util.Arrays;

//Need to find the first and the last index position  of an element in an array
public class FirstAndLastPosition {

    public static void main(String[] args) {
//        int[] nums = {5, 7, 7, 8, 8, 10};
//        int target = 8; //  Output: [3,4]

//    int[] nums = {5,7,7,8,8,10};
//    int target = 6; // Output: [-1,-1]

//            int[] nums = {1};
//    int target = 1; // Output: [0,0]

    int[] nums = {};
    int target = 0; // Output: [-1,-1]


        int[] result = searchForFirstAndLast(nums, target);

        System.out.println(Arrays.toString(result));
    }

   /*
     Here we will search for the leftest position of the element in array in first B.S
     And then in the second B.S we will search for the rightest position in array
     Time complexity : log(n) + log(n) = 2 * log(n) (i.e log(n) since constants are ignored in calculating time complexity)
    */
    private static int[] searchForFirstAndLast(int[] nums, int target) {
        int [] result = {-1,-1};
        if(nums.length == 0){
            return  result;
        }

        //Searching for the leftest index
        int start = 0;
        int end = nums.length -1;
        while (start <= end){
            int middle = (start + end)/2;

            if(nums[middle] == target){
                result[0] = middle;
                end = middle -1;
            }else if(target > nums[middle]){
                start = middle + 1;
            }else {
                end = middle -1;
            }
        }

        //Searching for the rightest index
         start = 0;
         end = nums.length -1;

        while (start <= end){
            int middle = (start + end)/2;

            if(nums[middle] == target){
                result[1] = middle;
                start = middle + 1;
            }else if(target > nums[middle]){
                start = middle + 1;
            }else {
                end = middle -1;
            }
        }

        return result;
    }

}





