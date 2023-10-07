package dsa.striverbinarysearchques;


//Implement lower bound
//https://www.codingninjas.com/studio/problems/lower-bound_8165382?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
public class LowerBound {

    public static void main(String[] args) {
//        int [] array = {1,2,2,3};
//        int targetEl = 0; //  Output : 0;


        int [] array = {1 ,2 ,2, 3 ,3 ,5};
        int targetEl = 7; //  Output : 6;

       int index = searchForLowerBound(array,targetEl);
        System.out.println("Index of lower bound element is : "+ index);
    }

    private static int searchForLowerBound(int[] array, int targetEl) {
        int start = 0;
        int end = array.length -1;
        int lowerBoundIndex = array.length ;
        while (start <= end){
            int mid = (end-start/2) + start;
            if(array[mid] >= targetEl){
                lowerBoundIndex = mid;
                // If mid is lower and array is sorted we can be sure that all the elements to the right of the array will
                // also be bigger than this so discarding those
                end = mid -1;
            }else{
                start = mid +1;
            }
        }
        return lowerBoundIndex;
    }


}
