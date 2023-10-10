package dsa.striverbinarysearchques;

public class FindMinimum {

    public static void main(String[] args) {
//        int [] array ={11,13,15,17}; // output : 11

//        int [] array ={4,5,6,7,0,1,2}; // output : 0

        int [] array ={3,4,5,1,2}; // output : 1

        int minimumEL = findMinimumElementInArray(array);
        System.out.println("The minimum element of array is "+ minimumEL);
    }

    /*
     Assuming that the array will have no duplicate values within

     Again the same logic we will have a variable for minimumValue initialize with arr[0] value.Now from here we will
     search the array as at any given index we have two arrays in either both sorted or at leat one sorted so we will
     check the start element of the sorted element with the minimum value and then discard the sorted side and move towards the other side
     */
    private static int findMinimumElementInArray(int[] array) {
        int start = 0;
        int end = array.length -1;
        int minimumEl = array[start];

        if(array[start] <= array[end]){
            return array[start];
        }

        while (start<= end){

            int middle = (end -start)/2+ start;

            // If left is sorted
            if(array[start] <= array[middle]){
                if(array[start] < minimumEl){
                    // Checking wheter start element is lower than current minimum element if yes than replace it.
                    minimumEl = array[start];

                }
                // Irrespective discard the left half
                start = middle +1;
            }else{
                // If right is sorted

                if(array[middle] < minimumEl){
                    // Checking wheter middle element is lower than current minimum element if yes than replace it.
                    minimumEl = array[middle];
                }
                // Irrespective discard the right half
                end = middle - 1;
            }

        }

        return minimumEl;
    }
}
