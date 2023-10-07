package dsa.binarysearchquestion;

import java.util.Arrays;


// https://www.codingninjas.com/studio/problems/painter-s-partition-problem_1089557
public class PaintersPartition {

    public static void main(String[] args) {
        int[] array ={7,2,5,10,8};
        int k =1;
        int time =  minimumPaintersTime(array,k);
        System.out.println("Minimum time is "+ time);
    }

    private static int minimumPaintersTime(int[] array, int k) {
        int end = array[0];
        int start = array[0];
        for(int i = 1 ; i < array.length ;i++){
            // finding the sum as the ending of the range
            end = end + array[i];
            if(array[i] > start){
                // Find maximum number in the array as the starting of the range
                start = array[i];
            }
        }
        int midRange = 0;
        int ans = 0;
        while (start <= end){
             midRange = (end - start)/2 + start;
            int painters = countingPainter(array,midRange);
            if(painters > k){
                start = midRange +1;
            }else{
                end = midRange -1;
            }
        }

        return ans;

    }

    private static int countingPainter(int[] array, int allowedMaxTime) {
        int currentMaxTime = 0;
        int counter = 1;
        for(int i =0 ; i < array.length;i++){
            currentMaxTime = currentMaxTime + array[i];
            if(currentMaxTime  > allowedMaxTime){
                currentMaxTime = array[i];
                counter++;
            }
        }
        return counter;
    }


}
