package dsa.binarsearchreallifebased;

import java.util.Arrays;

// https://www.codingninjas.com/studio/problems/minimum-rate-to-eat-bananas_7449064?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
public class KokoEatingBanana {
    public static void main(String[] args) {

//        int [] bananas = {3,6,2,8};
//        int hours = 7; // answer : 3

        int [] bananas = {7, 15, 6, 3};
        int hours = 8; // answer : 5

//        int [] bananas = {25, 12, 8, 14, 19};
//        int hours = 5; // answer : 25

//        int [] bananas = {3, 6, 7, 11};
//        int hours = 8; // answer : 25
        
        int maxBanana = serchingForMaxBananaToFinish(bananas,hours);
        System.out.println(maxBanana);
    }

    private static int serchingForMaxBananaToFinish(int[] bananas, int hours) {
        int start = 1; // Minimum max value;
        int end = Arrays.stream(bananas).max().getAsInt(); // getting maximum bananas in a pile as that can bemaximum eaten in an hour

        while (start <= end){
           int middle = (start + end)/2;

           // checking wheter for the given banana/hour how many hours is require to eat all banana
           int maxHours =checkingForMaxHour(middle,bananas);

           // If calculated hour is less or equal to given hour than decrease banana / hour by going toward left
           if(maxHours <= hours){
              end = middle -1;
           }else{
               // If calculated hour is greater than increase banana / hour by going toward right
               start = middle +1;
           }

        }
        return start;
    }

    private static int checkingForMaxHour(int middle, int[] bananas) {
        int count = 0;
        for(int i =0 ; i <bananas.length ; i++){
            // Dividing banana in each pile with the banana/ hour and taking the ceil value to get hour required to eat
            // all bananas in that pile
            count += Math.ceil((double)(bananas[i]) / (double)(middle));
        }

        return count;
    }
}
