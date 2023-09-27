package dsa.binarysearchquestion;


// https://leetcode.com/problems/search-in-rotated-sorted-array/
/*
   Here we have a sorted rotated array in which we hace to find the index of the targetEl
 */
public class AscRotatedArray {

    public static void main(String[] args) {
//        int[] array = {4, 5, 6, 7, 0, 1, 2};
//        int targetEl = 0; //Output : 4

//        int[] array = {5, 6, 7, 8, 9, 10, 1, 2, 3};
//        int targetEl = 3; //Output : 8

//        int[] array = {4,5,6,7,0,1,2};
//        int targetEl = 5; //Output : 1


//        int[] array = {2,4,1};
//        int targetEl = 3; //Output : -1

//        int[] array = {1};
//        int targetEl = 0; //Output : -1

//        int[] array = {5, 6, 7, 8, 9, 10, 1, 2, 3};
//        int targetEl = 30; //Output : -1

//        int[] array = {30, 40, 50, 10, 20};
//        int targetEl = 10; //Output : 3


        int[] array = { 10, 20,30, 40, 50,};
        int targetEl = 10; //Output : 0



        int index = serachForEl(array, targetEl);
        System.out.println("==================================================");
        System.out.println("The index of the element is "+ index);
    }

    private static int serachForEl(int[] array, int targetEl) {
        // First we will search for the pivot i.e the point after which again a ascending sorted array starts with a different sequence
        int pivotIndex =  findPivot(array);

        if(pivotIndex == -1){
            // If there is no pivot index present that means the array is not rotated
            System.out.println("==================================================");
            System.out.println("No pivot index found applying binary search on entire array");
            return binarySearch(array,0,array.length-1,targetEl);
        }
        System.out.println("==================================================");
        System.out.println("Pivot Index found : "+ pivotIndex);
        System.out.println("Hence it is a rotated sorted array so applying binary search on both arrays");


        //Checking wheter the pivotIndex element matches with the target element
        // Identifying the pivotIndex help us to identify the start and end of both sorted arrays
        if(array[pivotIndex] == targetEl){
            return pivotIndex;
        }

        // checking wheter the target element is smallest than the starting element of both ascending sorted array
        if(targetEl < array[0] && targetEl < array[pivotIndex+1] || targetEl > array[pivotIndex]){
            System.out.println("==================================================");
            System.out.println("The target element is smaller then the starting element of both array or it maybe bigger than the largest element in the array ");
            return  -1;
        }else if(targetEl < array[0]){
            //Searching in the second array
            System.out.println("==================================================");
            System.out.println("Searched in second array");
            return binarySearch(array,pivotIndex+1,array.length -1,targetEl);
        }else{
            //Searching in the first array
            System.out.println("==================================================");
            System.out.println("Searched in first array");
            return binarySearch(array,0,pivotIndex -1,targetEl);
        }

    }

    /*
    This method gives us the index of the biggest element in the array
     */
    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int pivotIndex = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((arr[mid] > arr[start] && arr[mid] > arr[end]) || (pivotIndex != -1 && arr[mid] >= arr[pivotIndex]) ) {
                pivotIndex = mid;
                start = mid+1;
            }else if(arr[mid] <= arr[start] && arr[mid] <= arr[end]) {
              end = mid -1;
            }else{
                return pivotIndex;
            }
        }
        return pivotIndex;
    }
//    private static int findPivot(int[] array) {
//        int start = 0;
//        int end = array.length -1;
//
//        while (start <= end){
//            int middleIndex = start + ((end -start)/2);
//            if(array[middleIndex] > array[middleIndex + 1]){
//                return middleIndex;
//            }else if(array[middleIndex] < array[middleIndex-1]) {
//                return middleIndex -1;
//            }else if(array[start] > array[middleIndex]){
//                end = middleIndex -1;
//            }else{
//                start = middleIndex +1;
//            }
//        }
//
//
//        return -1;
//    }

    /*
      This mehthod applies binary search assuming the array provided is ascennding order sorted within the start and end rage provided
     */
    private static int binarySearch(int[] array, int start, int end, int targetEl) {

        if(targetEl < array[start]){
            return  -1;
        }

        while (start <= end){
            int middleIndex =( start + end ) /2 ;
            if(array[middleIndex] == targetEl){
                return middleIndex;
            }else if(array[middleIndex] < targetEl){
                start = middleIndex + 1;
            }else{
                end = middleIndex -1;
            }
        }
        return -1;
    }

}
