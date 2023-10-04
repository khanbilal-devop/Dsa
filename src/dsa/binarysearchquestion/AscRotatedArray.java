package dsa.binarysearchquestion;


// https://leetcode.com/problems/search-in-rotated-sorted-array/
/*
   Here we have a sorted rotated array in which we hace to find the index of the targetEl
 */
public class AscRotatedArray {

    public static void main(String[] args) {
        int[] array = {4, 5, 6, 7, 0, 1, 2};
        int targetEl = 0; //Output : 4
//
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


//        int[] array = {2,5,6,0,0,1,2};
//        int targetEl = 0; //Output : 3 or 4


//        int[] array = { 10, 20,30, 40, 50,};
//        int targetEl = 10; //Output : 0


        int index = searchForElement(array,targetEl);
        System.out.println("==================================================");
        System.out.println("The index of the element is "+ index);
    }


    private static int searchForElement(int[] array,int targetEl){
        int index = -1;
        int start = 0;
        int end = array.length -1;
        while (start <= end){
            int middle = start + (end - start)/2 ;
            if(array[middle] == targetEl){
                return middle;
            }else if(array[start] < array[middle]){
                if((array[start] <= targetEl && targetEl<= array[middle])) {
                    end = middle - 1;
                }else{
                    start = middle +1;
                }
            }else if(array[middle] < array[end] ){
                if((array[middle] <= targetEl && targetEl<= array[end])) {
                    start = middle + 1;
                }else {
                    end = middle -1;
                }
            }
        }
        return index;
    }


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
