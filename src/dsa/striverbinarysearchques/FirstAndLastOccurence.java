package dsa.striverbinarysearchques;

import java.util.Arrays;


// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FirstAndLastOccurence {

    public static void main(String[] args) {
//        int [] array = {5,7,7,8,8,10};
//        int targetEL = 8; // Output : {3,4}

//        int [] array = {5,7,7,8,8,10};
//        int targetEL = 6; // Output : {-1,-1}

//        int [] array = {};
//        int targetEL = 0; // Output : {-1,-1}

//        int [] array = {0, 0, 1, 1, 2, 2, 2, 2};
//        int targetEL = 2; // Output : {4,7}

        int [] array = {0,1,1,5};
        int targetEL = 1; // Output : {1,2}


        int [] positions = searchForFirstAndLast(array,targetEL);
        System.out.println("The positions are "+ Arrays.toString(positions));

    }

    private static int[] searchForFirstAndLast(int[] array, int targetEL) {
        int first = searchForFirst(array,targetEL);
        int last = searchForLast(array,targetEL);
        return new int []{first,last};
    }

    private static int searchForFirst(int[] array, int targetEL) {
        int start = 0;
        int end = array.length -1;
        int first = -1;
        while (start <= end){
            int mid = (end -start)/2 + start;

            /*
              If the target element is found saving this as a potential answer int first variable and then goes on to check array.
             */
            if(targetEL == array[mid]){
                first= mid;
            }

            if(targetEL > array[mid]){
                /*
                   Since we have to find the first occurence if target element is bigger then middle element then all elements to the left
                    will be smaller so discarding those and movinf to check the right half
                 */
                start = mid +1;
            }else{
                /*
                   Since we have to find the first occurence if target element is smaller or equal to middle element then all elements
                   to the right will be bigger or equal so discarding those and moving to check the left half
                */
                end = mid -1;
            }
         }
        return  first;
    }

    private static int searchForLast(int[] array, int targetEL) {
        int start =0;
        int end = array.length -1;
        int last = -1;
        while (start <= end){
            int mid = (end -start)/2 + start;

              /*
              If the target element is found saving this as a potential answer in last variable and then goes on to check array.
             */
            if(targetEL == array[mid]){
                last= mid;
            }
            if(targetEL < array[mid]){
                     /*
                   Since we have to find the last occurence if target element is smaller then mid element then all element to the right will be bigger
                   so discarding those and moving to check the left half
                 */
                end = mid -1;
            }else{
                    /*
                   Since we have to find the last occurence if target element is bigger  or equal to middle element then all elements
                   to the left will be smaller or equal so discarding those and moving to check the right half
                */
                start = mid +1;
            }
        }
        return  last;
    }


}
