package dsa.binarsearchreallifebased;

public class KthPosition {

    public static void main(String[] args) {
      int numbers[] = {2,3,4,7,11};
      int k = 5;

      int number = findKthPositive(numbers,k);
        System.out.println("The answer is "+ number);
    }

    private static int findKthPositive(int[] numbers, int k) {
        int start = 0;
        int end = numbers.length -1;

        if(k < numbers[start]){
            return k;
        }

        while (start <= end){
            int middle = (end - start)/2 + start;

            int countMissingEL = numbers[middle] - (middle +1);
            if(countMissingEL < k ){
                start = middle +1;
            }else{
                end = middle -1;
            }

        }
        return end + k +1;

    }


}
