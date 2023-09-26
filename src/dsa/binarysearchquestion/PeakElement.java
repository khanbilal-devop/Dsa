package dsa.binarysearchquestion;

/*
  Finding peak element in a mountain array also known as bitonic array .
   A mountain array is an array in which the value increase with index and after peaking out it starts to decrease with index
   eg : [1,5,7,8,13,9,3,1]
 */
public class PeakElement {

    public static void main(String[] args) {
        int [] arr = {0,1,0}; //Output = 1

//        int [] arr = {0,2,1,0}; //Output = 1

//        int[] arr = {0, 10, 5, 2}; //Output = 1

//        int[] arr = {10, 20, 30, 20, 10}; //Output = 2

        int index = findPeakIndex(arr);
        System.out.println("Peak index is : "+index);
    }

    private static int findPeakIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int middleIndex = start + ((end- start)/2);
            if(arr[middleIndex] > arr[middleIndex-1] && arr[middleIndex] > arr[middleIndex+1]){
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
