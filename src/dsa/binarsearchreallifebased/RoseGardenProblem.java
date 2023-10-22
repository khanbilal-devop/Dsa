package dsa.binarsearchreallifebased;

import java.util.Arrays;
import java.util.Collections;


// Coding ninja - https://www.codingninjas.com/studio/problems/rose-garden_2248080?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=1
// Leet code - https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
public class RoseGardenProblem {

    public static void main(String[] args) {

//        int[] flowers = {1, 2, 1, 2, 7, 2, 2, 3, 1}; // Flowers array
//        int noOfRoses = 3 ; // Roses reuired to form  a Boquet
//        int noOfB = 2; // No of bouqet required

//        int[] flowers = {1 ,1, 1, 1}; // Flowers array
//        int noOfRoses = 1 ; // Roses reuired to form  a Boquet
//        int noOfB = 1; // No of bouqet required

//        int[] flowers = {1,10,3,10,2}; // Flowers array
//        int noOfRoses = 1 ; // Roses reuired to form  a Boquet
//        int noOfB = 3; // No of bouqet required // Output : 3

//        int[] flowers = {1,10,3,10,2}; // Flowers array
//        int noOfRoses = 2 ; // Roses reuired to form  a Boquet
//        int noOfB = 3; // No of bouqet required // output : -1

//        int[] flowers = {7,7,7,7,12,7,7}; // Flowers array
//        int noOfRoses = 3 ; // Roses reuired to form  a Boquet
//        int noOfB = 2; // No of bouqet required // output : 12

        int[] flowers = {87, 78, 57, 75, 43, 55, 16, 36, 59, 18, 22, 77, 4, 35, 40, 15,4}; // Flowers array
        int noOfRoses = 4 ; // Roses reuired to form  a Boquet
        int noOfB = 3; // No of bouqet required // output : 75

        int minimumDays =  minimumDaysRequireToCreateBouquet(flowers,noOfRoses,noOfB);
        System.out.println("Minimum Days is "+ minimumDays);
    }

    private static int minimumDaysRequireToCreateBouquet(int[] flowers, int noOfRoses, int noOfBouquet) {
        // Initialize min and max with the first element of the array
        int minimumDays = flowers[0];
        int maximumDays = flowers[0];

        // Iterate through the array to find the minimum and maximum values
        for (int i = 1; i < flowers.length; i++) {
            if (flowers[i] < minimumDays) {
                minimumDays = flowers[i];
            }
            if (flowers[i] > maximumDays) {
                maximumDays = flowers[i];
            }
        }
        int possibleValue = -1; // If no minimum possible days found return default value

        while (minimumDays <= maximumDays){
            int possibleDays = (maximumDays -minimumDays)/2 + minimumDays;
           boolean isPossible = checkingForGivenDays(possibleDays,flowers,noOfRoses,noOfBouquet);
           if(isPossible){
               // Now if a particular days is possible then all days greater than that will also be possible
               // and here we have to find the minimum then so discarding the right and then look the answer in left
               // and also save the current day as a possible answer
               possibleValue = possibleDays;
               maximumDays = possibleDays -1;
           }else {
               minimumDays = possibleDays +1;
           }
        }
        return possibleValue;
    }

    /*
      Checking wheter it is possible to create this noOfBouquet from flowers with this noOfRoses where each index from flowers array
      represent the bloom time for the flower . Here givenNoOfDays represent the value to validate and return a boolean value accordingly
     */
    private static boolean checkingForGivenDays(int givenNoOfDays, int[] flowers, int noOfRoses, int noOfBouquet) {
        int rosesCount = 0;
        int i;
        for (i = 0; i < flowers.length ; i++) {
            rosesCount++; // roses count
            int days = flowers[i]; // Days require to bloom that flower
            if(days > givenNoOfDays){
                // If rose day to bloom is greater than provided days  skip the adjacent element
                // in case of coding ninja
                i++;

                // Here we are skipping adjacent element equal to the noOfRoses as if is a requiremnet
                // In case of leet code probelm
//                int differnece =  noOfRoses - rosesCount;
//                i = i + differnece;

                //If rose day to bloom is greater than provided days reset the roses count and continue for the next flower
                rosesCount = 0;
                continue;
            }
            if(rosesCount == noOfRoses){
                // if roses count is equal to noOfRoses in a boquet and since the days constraint is not breach
                // create one B and reset the roses count to zero
                noOfBouquet--;
                rosesCount = 0;
            }
            if(noOfBouquet == 0){
                // If the required Bouquet has been created break the loop.
                break;
            }
        }
        // Return true if the split is possible or return false
        return noOfBouquet == 0;
    }
}
