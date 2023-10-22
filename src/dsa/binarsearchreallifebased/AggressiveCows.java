package dsa.binarsearchreallifebased;

import java.util.Arrays;

public class AggressiveCows {

    public static void main(String[] args) {
//        int [] stallPosition = {0 ,3 ,4, 7 ,10, 9};
//        int noOfCows = 4; // Output : 3

        int [] stallPosition = {4 ,2, 1, 3, 6};
        int noOfCows = 2; // Output : 3

        int distance = searchForDistanceBetweenCows(stallPosition,noOfCows);
        System.out.println("Maximum min distance possible is "+ distance);
    }

    private static int searchForDistanceBetweenCows(int[] stallPosition, int noOfCows) {
        Arrays.sort(stallPosition);
        int start = 1;
        int end = stallPosition[stallPosition.length -1] - stallPosition[0];

        while (start <= end){
            int minDistance = (end -start)/2 + start;

           boolean canBePlaced = canPlaceCow(stallPosition,minDistance,noOfCows);

           if(canBePlaced){
               start = minDistance +1;
           }else{
               end = minDistance -1;
           }
        }
         return end;
    }

    private static boolean canPlaceCow(int[] stallPosition, int minDistance, int noOfCows) {
        boolean canBePlaced = false;
        int lastCowPosition = 0;
        int counter = 1;
        for(int i = 1 ; i < stallPosition.length ; i++){
            if(stallPosition[i] - stallPosition[lastCowPosition] >= minDistance){
                counter++;
                lastCowPosition = i;
            }
            if(counter == noOfCows){
                canBePlaced = true;
                break;
            }
        }

        return canBePlaced;
    }

}
