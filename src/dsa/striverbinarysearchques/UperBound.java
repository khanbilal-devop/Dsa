package dsa.striverbinarysearchques;



/*
Upper bound of a number is the number which is immediate greater to the given number
In case there is no number greater than given return length of array
 */
public class UperBound {

    public static void main(String[] args) {
//        int [] array ={2,4,6,7};
//        int targetEl = 5 ;// Output : 2

//        int [] array ={1,2,5,6,10};
//        int targetEl = 10 ;// Output : 5

        int [] array ={1 ,5, 5, 7, 7, 9, 10};
        int targetEl = 5 ;// Output : 3


        int upperBoundIndex =  searchUpperBound(array,targetEl);
        System.out.println("Upper bound index is "+ upperBoundIndex);
    }

    private static int searchUpperBound(int[] array, int targetEl) {
        int start =0;
        int end = array.length -1;


        while (start<=end){
            int mid = (end-start/2) + start;


            if(array[mid] > targetEl){
                // Here checking if this could be a possible upper bound if yes than going to the left half of array
                // as all to the right woulb be the gretear than the current possible upper bound

                end = mid -1;
            }else{

                // If the element is smaller or equal definetely we can discard everything to the left as the array is sorted in ascending and
                // all to the left will be smaller than the current mid
                start = mid + 1;
            }
        }

        // as here the start represents the previous possible upper bound index
        return start;
    }
}
