package dsa.striverbinarysearchques;

// https://leetcode.com/problems/find-peak-element/
public class PeakElement {

    public static void main(String[] args) {
//        int [] array = {1,2,3,1}; // Output : 2

//        int [] array = {1,2,1,3,5,6,4}; // Output : 5 or 1

//        int [] array = {1, 8, 1, 5, 3}; // Output : 1 or 3

        int [] array = {1 ,2 ,1}; // Output : 1




        int index =  searchForPeakElement(array);
        System.out.println("Peak element index is "+ index);
    }

    /*
      Note : In case of multiple peak return any one of them

      Whenever we have a see saw like array that is with multiple peaks and consecutive ups and downs

      For length 1 : the element it self is peak element

      Seperately checking for first and last element to avoid IndexOutOfBoundsException

      So here there are three cases of the position of the middle index

      Case 1 : It is the peak index that can be check by comparing elements adjacent to it.

      Case 2 : It is on the increasing side which means discard the left and peak is on the right.

      Case 3 : Its is on the decreasing side which means discard the right and peak is on the left.

     */
    private static int searchForPeakElement(int[] array) {
        int start =0;
        int end = array.length -1;

        if(array.length ==1){
            return array[start];
        }else if(array[start] > array[start+1]){
            // If start element is peak element
            return array[start];
        }else if(array[end] > array[end-1]){
            // If last element is peak element
            return array[end];
        }

        start +=1;
        end -= 1;
        while (start <= end){
            int middle = (end-start)/2 + start;

            if(array[middle] >array[middle-1] && array[middle] > array[middle+1]){
//                Case 1 : It is the peak index that can be check by comparing elements adjacent to it.
                return middle;
            } else if (array[middle] > array[middle-1]) {
//                Case 2 : It is on the increasing side which means discard the left and peak is on the right.
                 start= middle+1;
            }else {
//                Case 3 : Its is on the decreasing side which means discard the right and peak is on the left.
                  end = middle -1;
            }
        }


        return -1;
    }

}
