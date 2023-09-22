package dsa.binarysearchquestion;

public class Floor {

    public static void main(String[] args) {
                int[] arr = {3, 6, 7, 9, 12, 16};
//        int[] arr = {13,12,11,9,8,4};
//        int[] arr = {};
//        int[] arr = {5};
//        int[] arr = {5,5,5,5,5};
        int targetEl = 15;
        int floorNo = searchForFloor(arr,targetEl);
        System.out.println(floorNo);
    }

    private static int searchForFloor(int[] arr, int targetEl) {

        // If the number is less than the smallest number in the array
        if(targetEl < arr[0]){
            return  -1;
        }
        int start = 0;
        int end = arr.length -1;

        //Applying binary search
        while (start <= end){
            int middleIndex =( start + end ) /2 ;
            if(arr[middleIndex] == targetEl){
                return targetEl;
            }else if(arr[middleIndex] < targetEl){
                start = middleIndex + 1;
            }else{
                end = middleIndex -1;
            }
        }

        /**
         *  Till the end if not able to find a equal number that means that the number just before the last middleindex
         *   was the answer and thus return end value
         */
        return arr[end];
    }
}
