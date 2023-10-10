package dsa.striverbinarysearchques;

public class NumberOfOccurence {

    public static void main(String[] args) {
//        int [] arr = {1,1,1,2,2,3,3};
//        int targetEl = 3; // Output : 2;

        int [] arr = {1, 2, 4 ,4, 5};
        int targetEl = 6; // Output : 0;

        int count = countOccurence(arr,targetEl);
        System.out.println("The count of target element is "+ count);
    }

    private static int countOccurence(int[] arr, int targetEl) {
        int first = searchForFirst(arr,targetEl);
        if(first == -1){
            return 0;
        }
        int last = searchForLast(arr,targetEl);
        return (last - first) + 1;
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
