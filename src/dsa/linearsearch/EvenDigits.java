package dsa.linearsearch;

//Leet code problem
//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/?source=submission-ac
public class EvenDigits {

    public static void main(String[] args) {
        int[] numbers = {12,345,2,6,7896,34,567,30,0,-90,-40};
        int count = countForEvenDigits(numbers);
        System.out.println(count);
    }

    static int countForEvenDigits(int[] numbers){
        int count = 0;
        for(int index =0 ; index < numbers.length; index++) {
            if(isEvenDigit(numbers[index])){
               count++;
            }
            // String based approach
//            var converted = String.valueOf(numbers[index]);
//            if(converted.length() % 2 == 0 ){
//                count++;
//            }
        }
        return count;
    }

    private static boolean isEvenDigit(int number) {
        //To handle negative numbers
        number = number < 0 ?  (number * -1): number;

        var digitCount = 0;

        //Looping number till last digit
        while (number > 0){
           number = number /10;
           digitCount++;
        }
        if(digitCount != 0 && digitCount %2 == 0){
            return true;
        }
        return  false;
    }
}
