package dsa.binarsearchreallifebased;

public class SquareRootOfNumber {

    public static void main(String[] args) {
//        int number = 856; // output : 29

//        int number = 7; // output : 2

//        int number = 6; // output : 2

//        int number = 100; // output : 10

        long number = 6; // output : 1

        long ans = findingSquareRootOfNumber(number);
        System.out.println("Answer is "+ ans);
    }

    /*
      Let us find square root for 81 :
      1 * 1 = 1;
      2 *2 = 4
      ...
      8*8 =64;
      9*9 = 81
      10 * 10 = 100

      At number 10 we were sure that it was exceeding 81 so any number beyond that for sure will not be a squre root of 81

      so any number upto 1 .. 9 could be our answer and the biggest number among that would be our answer
     */
    private static int findingSquareRootOfNumber(long number){
        int answer  = 0;
        if(number == 0){
            return answer;
        }
        int start = 1;
        int end = (int) number/2;

        while (start <= end){
            int middle =(end -start)/2+ start;

            long squareNumber = middle * middle;
            if(squareNumber == number){
                return middle;
            }else if(squareNumber > number){
                // neglecting all numbers above that
                end = middle -1;
            }else {
                answer = middle;
                start = middle +1;
            }


        }
        return  answer;
    }
}
