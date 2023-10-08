package dsa.striverbinarysearchques;

import java.util.Arrays;


// Find the Floor and ceiling of a number
public class FloorAndCeiling {

    public static void main(String[] args) {
//        int [] array = {1,3,5,6};
//        int targetEl = 4; // Output {1,2};

//        int [] array = {1 ,2, 4 ,7};
//        int targetEl = 4; // Output {2,2};

//        int [] array = {2, 5, 7};
//        int targetEl = 1; // Output {-1,0};

//        int [] array = {1 ,2, 4 ,7};
//        int targetEl = 2; // Output {1,1};


//        int [] array = {3, 4, 4, 7, 8, 10};
//        int targetEl = 8; // Output {4,4};

//        int [] array = {3, 4, 4, 7, 8, 10};
//        int targetEl = 2; // Output {-1,0};

        int [] array = {3, 4, 4, 7, 8, 10};
        int targetEl = 11; // Output {5,-1};

        int[] positions = searchFloorAndCeilingIndex(array,targetEl);
        System.out.println("Insert position index is at "+ Arrays.toString(positions));
    }

    private static int[] searchFloorAndCeilingIndex(int[] array, int targetEl) {
        int start = 0;
        int end = array.length -1;

        // Covering base case that is if the target element is bigger or smaller than the given array range

        // If element is smaller or equal to start element than it means it has no floor and start index is its ceiling
        if(targetEl < array[start])  {
            return new int []{-1,start};
        }
        // If element is bigger or equal to end element than it means it has no ceilng and end index is its floor
        else if(targetEl > array[end]){
            return new int []{end,-1};
        }

        while (start <= end){
            int mid = (end-start/2) + start;

            // If target == mid return {mid,mid}
            if((array[mid] == targetEl) ){
                return new int[]{mid,mid};
            }else if(targetEl < array[mid]){
                // if target is lesser than mid that means we have to discard the right side of the array as all those elements would be greater
                // than that. Here we are trying to find the target element and if we dont find it our start index would be representing the index of the number
                // just immediate greater to target element
                end = mid -1;
            }else {
                // if target is bigger than mid that means we have to discard the left side of the array as all those elements would be lower
                // than that.Here we are trying to find the target element and if we dont find it our start index would be representing the index
                // of the number just immediate greater to target element
                start = mid +1;
            }
        }

        // this will give us the index of the floor and celing index of the target element
        return new int[] {start-1,start};
    }
}
