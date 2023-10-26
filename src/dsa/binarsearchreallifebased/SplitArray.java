package dsa.binarsearchreallifebased;

public class SplitArray {

    public static void main(String[] args) {
//        int [] a = {1, 2, 3, 4, 5};
//        int k = 3; // Output : 6

//        int[]a ={3 ,5, 1};
//        int k =3; // Output : 5

//        int[]a ={10 ,4 ,5 ,10, 9, 10,};
//        int k =4; // Output : 15

//        int[]a ={7,2,5,10,8};
//        int k =2; // Output : 18

        int [] a = {1, 2, 3, 4, 5};
        int k = 2; // Output : 9

       int largestSum =  largestSubarraySumMinimized(a,k);
        System.out.println("Minimized largest sum is "+ largestSum);
    }

    private static int largestSubarraySumMinimized(int[] a, int k) {
         if(k > a.length){
             return -1;
         }
         int minSum = a[0];
         int maxSum = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > minSum) {
                minSum = a[i];
            }
            maxSum = maxSum + a[i];
        }

        while (minSum <= maxSum){
            int possibleSum = (maxSum - minSum)/2 + minSum;
            int splitCounter = countSplitForSum(a,possibleSum);
            if(splitCounter > k){
                minSum = possibleSum + 1;
            }else {
               maxSum = possibleSum -1;
            }
        }
        return minSum;
    }

    private static int countSplitForSum(int[] a, int possibleSum) {
        int splitCount =1;
        int totalSum = 0;
        for(int number : a){
            totalSum = totalSum + number;
            if(totalSum > possibleSum){
                totalSum = number;
                splitCount++;
            }
        }

        return splitCount;
    }
}
