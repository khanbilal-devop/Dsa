package dsa.striverbinarysearchques;

public class SearchInRotatedSortedArr {

    public static void main(String[] args) {
//        int[] array = {4,5,6,7,0,1,2};
//        int targetEl = 0; // output : 4

//        int[] array = {4,5,6,7,0,1,2};
//        int targetEl = 3; // output : -1

        int[] array = {1};
        int targetEl = 0; // output : -1

       int index =  searchForTargetElement(array,targetEl);
        System.out.println("Target element is present at index "+ index);
    }

    /*
     Since it's a rotated sorted array that means at any index withing array there arise two case

     Case 1 : One side is sorted (ascending) other is not
     Case 2 : Both sides are sorted (ascending)

     Since we are sure that one side is always sorted we will check wheter the target element lies in that range
     if it does then we  will discard the other side and search within sorted side
     */
    private static int searchForTargetElement(int[] array, int targetEl) {
        int index = -1;
        int start = 0;
        int end = array.length -1;
        while (start <= end){
            int middle = (end -start)/2 + start;
            if(array[middle] == targetEl){
                return middle;
            }

            //If right is sorted
            if(array[start] <=  array[middle]){
                if(array[start] <= targetEl && array[middle] >= targetEl){
                    //Checking wheter target element lies within range
                    end = middle -1;
                }else {
                    // If not discarding that half and going for the next one
                    start = middle +1;
                }
            }else{
                if(array[start] <= targetEl && array[middle] >= targetEl){
                    //Checking wheter target element lies within range
                    end = middle -1;
                }else {
                    // If not discarding that half and going for the next one
                    start = middle +1;
                }
            }
        }
        return index;
    }


}
