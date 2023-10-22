package dsa.binarsearchreallifebased;

public class SmallestDivisor {

    public static void main(String[] args) {
//        int [] number ={1, 2, 3, 4, 5};
//        int limit = 8; //Output :3

        int [] number ={8 ,4, 2, 3};
        int limit = 10; //Output :2

       int answer = searchForSmallestDivisor(number,limit);
        System.out.println("The answer is "+ answer);
    }

    private static int searchForSmallestDivisor(int[] number, int limit) {
        int answer = 0;
        int start = 1;
        int end = number[0];
        // Iterate through the array to find the minimum and maximum values
        for (int i = 1; i < number.length; i++) {

            if (number[i] > end) {
                end = number[i];
            }
        }

        while (start <= end){
            int middle = (end -start)/2 + start;

            int value = checkForDivisor(number,middle,limit);
            if(value == 0){
                answer = middle;
                end = middle -1;
            }else{
                start = middle+1;
            }
        }
        return answer;
    }

    private static int checkForDivisor(int[] number, int middle, int limit) {
        int sum = 0;
        for (int j : number) {
            double value = Math.ceil((double) j / middle);
            sum = sum + (int) value;
        }
        if(sum <= limit){
            return 0;
        }else {
            return 1;
        }
    }
}
