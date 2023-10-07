package dsa.binarysearchquestion;


// Need to check why this test case is failing

//Find the Rotation Count in Rotated Sorted array
// https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
public class RotationCount {


    public static void main(String[] args) {
//        int [] array = {15, 18, 2, 3, 6, 12};
        // Output : 2
        //Explaination : The original array would be {2,3,6,12,15,18} and it has to be rotated two times to reach the provided array

//        int [] array = {7, 9, 11, 12, 5}; // Output : 4

//        int [] array = {4,5,6,7,0,1,2}; // Output : 4

//        int [] array = {3,4,5,1,2}; // Output : 3

        int [] array = {1,2,3,4,5}; // Output : 0


        /*
          If you will notice in here the count is actually always the  index of the mminimum no in array
         */
        //LinearSearch
//        int rotatedCount = searchForRotationCountLS(array);

        // Binary search
         int  rotatedCount =  searchForRotationCountBS(array);
        System.out.println("It was roatated by "+ rotatedCount);

    }

    /*
      Linear search
     */
    private static int searchForRotationCountLS(int[] array) {
        int end = array.length -1;
        int count = 0;

        for(int i = 1; i <= end;i++){
            // Checking for the index with the  minimum element in  array
            if(array[i] < array[count]){
                count = i;
            }
        }
        return  count;
    }

    private static int searchForRotationCountBS(int[] array) {
        /*
         here we no that the minimum element would be lower than both of its corresponding element

         Case 1 : The array is not rotated i.e the rotated count is 0


         Case 2 : Assuming right side sorted means we are sure that the start index array[start] is the smallest in the right array comparing it with
                  current minimum and saving the minimum of the both and will move on to the left side of the array

          Case 3 : Assuming left side sorted means we are sure that the middle index array[middle] is the smallest in the right array comparing it with
                  current minimum and saving the minimum of the both and will move on to the right side of the array


         */
        int start = 0;
        int end = array.length -1;
        int count = 0;

//        Case 1 : The array is not rotated i.e the roatated count is 0
        if(array[start] <= array[end]){
            return start;
        }
        while (start <= end){
            int middle = (end - start)/2 + start;



            if(array[start] <= array[middle]) {
//             Case 2 : Assuming right side sorted means we are sure that the start index array[start] is the smallest in the right array comparing it with
//             current minimum and saving the minimum of the both and will move on to the left side of the array
                count = array[start] < array[count] ? start : count;
                start = middle + 1;
            }
            else {
//                Case 3 : Assuming left side sorted means we are sure that the middle index array[middle] is the smallest in the right array comparing it with
//                current minimum and saving the minimum of the both and will move on to the right side of the array
                count = array[middle] < array[count] ? middle : count;
                end = middle - 1;
            }
        }
        return  count;
    }
}
