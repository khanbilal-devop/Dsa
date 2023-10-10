package dsa.striverbinarysearchques;

public class SearchInRotatedDuplicate {


    public static void main(String[] args) {
//        int [] arr ={};
//        int targetEl = 0; // Output : -1

//        int [] arr ={2,5,6,0,0,1,2};
//        int targetEl = 0; // Output : true


        int [] arr ={2,5,6,0,0,1,2};
        int targetEl = 3; // Output : false

       boolean isPresent = searchForElementWithDuplicate(arr,targetEl);
        System.out.println("The index of the element is "+ isPresent);
    }

    /*
      We have previously done a similar problem of searching elemnt in rotated sorted array.
      There we used the approach of finding the sorted side and checking if target element lies within the range
      and then decide which side of array to discard.

      Since here we are dealing with duplicate values so if the start end and middle index all happen to be same in that case
      we will not be able to decide the sorted side and hence it could give us faulty results. so we have to come up with a different approach this time.

      So here whenever we will find the start and the end index to be same we could neglect those element and can trim
      down the search space as we will be sure that since both are equal and different from target element these can be
      neglected
     */
    private static boolean searchForElementWithDuplicate(int[] arr, int targetEl) {
        int start = 0;
        int end = arr.length -1;

        while (start<= end){

            // Checking wheter start element and end element are same if found to be then stariaght away
            // trim down the search space
            if(arr[start] == arr[end]){
                start = start +1;
                end = end -1;
            }
            int middle = (end -start)/2+ start;

            if(arr[middle] == targetEl){
                return true;
            }
            //If right is sorted
            if(arr[start] <=  arr[middle]){
                if(arr[start] <= targetEl && arr[middle] >= targetEl){
                    //Checking wheter target element lies within range
                    end = middle -1;
                }else {
                    // If not discarding that half and going for the next one
                    start = middle +1;
                }
            }else{
                if(arr[start] <= targetEl && arr[middle] >= targetEl){
                    //Checking wheter target element lies within range
                    end = middle -1;
                }else {
                    // If not discarding that half and going for the next one
                    start = middle +1;
                }
            }

        }

        return false;
    }

}
