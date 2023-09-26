package dsa.binarysearchquestion;


/*
 Find the element in a mountain array and return its index
 */
public class SearchInMountainArray {

    public static void main(String[] args) {
//        int [] array = {1,2,3,4,5,3,1};
//        int targetEL = 3; // Output : 2

        int [] array = {0,1,2,4,2,1};
        int targetEL = 3; // Output : -1

        int peakIndex =  findPeakIndex(array);
        if(array[peakIndex] != targetEL) {
            int index = orderAgnosticBinarySearch(array, 0, peakIndex - 1,targetEL);
            if(index == -1){
                index = orderAgnosticBinarySearch(array,peakIndex+1,array.length -1,targetEL);
            }
            System.out.println("Index of maximum element is : " + index);
        }else{
            System.out.println("Index of target element : "+peakIndex);
        }
    }

    private static int orderAgnosticBinarySearch(int[] array, int start, int end,int targetEl) {

        boolean isAsc = array[start] < array[end];
        while (start <= end){
            int middleIndex = start + ((end- start)/2);

            if(array[middleIndex] == targetEl) {
                return middleIndex;
            }


            if(isAsc){
                if(targetEl < array[middleIndex]){
                    end = middleIndex - 1;
                }else {
                    start = middleIndex + 1;
                }
            }else {
                if(targetEl < array[middleIndex]){
                    start = middleIndex +1;
                }else {
                    end = middleIndex - 1;
                }
            }
        }
        return -1;
    }

    private static int findPeakIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int middleIndex = start + ((end- start)/2);

            if(arr[middleIndex] > arr[middleIndex-1] && arr[middleIndex] > arr[middleIndex+1]){
                // Peak element will be greater than it's both adjacent elements
                return middleIndex;
            }else if(arr[middleIndex] < arr[middleIndex +1]){
                start = middleIndex + 1;
            }else {
                end = middleIndex - 1;
            }
        }
        return -1;
    }
}
