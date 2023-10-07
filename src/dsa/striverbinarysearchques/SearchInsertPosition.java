package dsa.striverbinarysearchques;


import java.lang.reflect.GenericDeclaration;

/*
 Search for insert position
 Case 1 : Element found in array retur the index of the element
 Case 2 : Element not found return the index such that if the number would have been present it would be at that index
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
//        int [] array = {1,3,5,6};
//        int targetEl = 5; // Output 2;

//        int [] array = {1 ,2, 4 ,7};
//        int targetEl = 9; // Output 4;
//
//        int [] array = {2, 5, 7};
//        int targetEl = 1; // Output 0;


        int [] array = {1 ,2, 4 ,7};
        int targetEl = 2; // Output 1;

        int index = searchInsertPosition(array,targetEl);
        System.out.println("Insert position index is at "+ index);
    }

    private static int searchInsertPosition(int[] array, int targetEl) {
        int start = 0;
        int end = array.length -1;
        // If element is smaller or equal to  start element than return 0
        if(targetEl <= array[start]) return start;
            // If element is biggerbor equal than end element than return end
        else if(targetEl >= array[end]) return end;

        while (start <= end){
            int mid = (end-start/2) + start;

            // If target == mid return mid
            if((array[mid] == targetEl) ){
                return mid;
            }else if(targetEl < array[mid]){
                // if target is lesser than mid that means we have to discard the right side of the array as all those elements would be greater
                // than that.
                end = mid -1;
            }else {
                // if target is bigger than mid that means we have to discard the left side of the array as all those elements would be lower
                // than that.
                start = mid +1;
            }
        }

        // this will give us the index of the just immediate greater than than the element which becomes the inserting index
        return start;
    }
}
