package dsa.binarysearchquestion;

public class AscRotatedDuplicate {

    public static void main(String[] args) {

        int[] array = {3, 3, 3, 1, 2, 3};
        int targetEl = 4; //Output : false

//        int[] array = {3, 3, 3, 1, 2, 3};
//        int targetEl = 11; //Output : false

//        int[] array = {2,5,6,0,0,1,2};
//        int targetEl = 0; //Output : true

//        int [] array ={4,5,6,6,7,0,1,2,4,4};
//        int targetEl = 9; // Output : true

        boolean found = searchForEl(array,targetEl);
        System.out.println("Is element present  : "+found);
    }

    private static boolean searchForEl(int[] array, int targetEl) {
        boolean index = false;
        int start = 0;
        int end = array.length -1;
        while (start <= end){
            // checking wheter to shrink the start and end
            if(array[start] == array[end]){

                start = start +1 ;
                end = end - 1;
                continue;
            }
            int middle = start + (end- start)/2;
            if(array[middle] == targetEl){
                // checking for target element in the middle index
                return true;
            }else if(array[start] <= array[middle]){
                // Left side is sorted
                if(array[start] <= targetEl && array[middle] > targetEl){
                    // if the element lies within the sorted range checking that range now
                    end = middle -1;
                }else{
                    // If the element does not lie within sorted range then checking the right array
                    start = middle + 1;
                }
            }else{
                // Right side is sorted
                if(array[middle] < targetEl && array[end] >= targetEl){
                    // if the element lies within the sorted range checking that range now
                    start = middle +1;
                }else{
                    // If the element does not lie within sorted range then checking the left array
                    end = middle - 1;
                }
            }
        }
        return index;
    }
}
