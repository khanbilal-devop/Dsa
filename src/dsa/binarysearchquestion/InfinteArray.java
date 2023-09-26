package dsa.binarysearchquestion;

/*
   Here we are trying to serch for a number in a sorted array . The catch is the given array is of inifite size.
    Thus arr.length will not work in that case
 */
public class InfinteArray {

    public static void main(String[] args) {

        // Test cases to test the algorithm
        int [] array  = {9, 11, 17, 26, 37, 52, 89, 111, 129, 144, 198};
        int targetEl = 89 ; // Output : 6

//        int [] array ={2, 4, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26};
//        int targetEl = 20 ; // Output : 8

//        int [] array ={2, 4, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26};
//        int targetEl = 15 ; // Output : -1

        int index = searchInInfinteArray(array,targetEl);
        System.out.println("Found on index "+ index );

    }

    /*
       In this method we first identify the range in which we will find our target once identify then we will apply binary search
     */
    private static int searchInInfinteArray(int[] array, int targetEl) {
         int start = 0;

         // since we can't use length attribute so have started with second index
        int end = 1;
        if(array[start] > targetEl){
            return  -1;
        }

        // This flag is to track range indentification as soon as it is defined i.e true we can apply binary search
        boolean isRangeNotDefined = true;


        while (start <= end || isRangeNotDefined){
            int middle = start + (end - start)/2;
            if(array[middle] < targetEl){
                start = middle + 1;

//                Till  our range is not identified we will be doubling the size of our array thus exponentially increasing our array.
                if(isRangeNotDefined){
                    end = end *2;
                }
            }else if(array[middle] > targetEl){
                end = middle -1 ;

                // as soon as we find an element greater than target this implies that ouir range has been identified
                isRangeNotDefined = false;
            }else {
                return middle;
            }
        }

        return  -1;
    }

}
