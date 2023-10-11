package dsa.striverbinarysearchques;


// https://www.codingninjas.com/studio/problems/unique-element-in-sorted-array_1112654?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
public class SingleElementInSortedArray {

    public static void main(String[] args) {
//        int [] array = {1,1,2,3,3,4,4,8,8}; // Output : 2

//        int [] array = {3,3,7,7,10,11,11}; // Output : 10

//        int [] array = {1 ,1, 4, 4, 15}; // Output : 15

        int [] array = {1, 1, 3, 5, 5 }; //Output : 3

        int singelEL =checkForSingleElement(array);
        System.out.println("The singel element within array is "+ singelEL);
    }

    /*
      Since here all the elements are exactly repeated twice except for one so we had one observation in this
      . Every even index and the just odd index will have the pair of duplicate value
        0 even has 2
        1 odd has 2
        2 even has 3
        3 odd has 3

        So first we will check that our middle index is the single element by checking th next and previous element
         This will throw us error in the case of mid =0   and mid = length -1 and lenght = 1
         so we will checking for this corner cases well before the loop

        If the middle element is not the single element then we will check
        if the first element within repeating sequence is at even index if that is the case then will neglect the left side and will move towards right side

        If the first element within repeating sequence is at odd index then neglect the right half and the single element
         is in the left half
     */
    private static int checkForSingleElement(int [] array) {
        int start = 0;
        int end = array.length -1;

        // Checking for array of length 1 and checking for start and last element within array seperately
        if(array.length == 1 || array[start] != array[start+1]){
            return array[start];
        }else if(array[end] != array[end -1]){
            return array[end];
        }
        start = start+1;
        end = end -1;

        while (start <= end){
            int middle = (end - start)/2 + start;

            // If middle is not equal to both adjacent elements that means middle element is the answer
            if(array[middle] != array[middle-1] && array[middle] != array[middle+1]){
                return array[middle];
            }

            //even
            if(middle %2 ==0){
//                if the first element within repeating sequence is at even index if that is the case then will neglect the left side and will move towards right side
                    if(array[middle] == array[middle+1]){
                    start= middle+1;
                }else{
                    end = middle -1;
                }
            }//odd
            else {
//                If the first element within repeating sequence is at odd index then neglect the right half and the single element
//                is on the left half
                if(array[middle] == array[middle+1]){
                    end= middle-1;
                }else{
                    start = middle +1;
                }
            }

        }
        return 0;
    }
}
