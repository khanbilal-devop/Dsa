package dsa.binarsearchreallifebased;

public class ShipPackages {

    public static void main(String[] args) {
//        int [] weights = {5, 4, 5, 2, 3, 4, 5, 6};
//        int days = 5;// Output : 9

//        int [] weights = {1 ,2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int days = 1;// Output : 55

//        int [] weights = {1 ,2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int days = 5;// Output : 15

//        int [] weights = {3,2,2,4,1,4};
//        int days = 3;// Output : 6

        int [] weights = {1,2,3,1,1};
        int days = 4;// Output : -1

        int weightCapacity = checkForMinimumWeightCapacity(weights,days);
        System.out.println("The minimum weight capacity is "+ weightCapacity);
    }

    private static int checkForMinimumWeightCapacity(int[] weights, int days) {
        int possibleWeight = -1;
        int minWeight = weights[0]; // The maximum single weight in array
        int maxWeight =weights[0]; // Sum of all the weights
        for (int i = 1; i < weights.length; i++) {
            maxWeight = maxWeight + weights[i];
            if (weights[i] > minWeight) {
                minWeight = weights[i];
            }
        }

        while (minWeight <=  maxWeight){
            int middleWeight= (maxWeight-minWeight)/2 + minWeight;

            int returnedVal = checkForDaysAndWeight(days,middleWeight,weights);

            if(returnedVal == 0){
                // Middle weight can be transported in provided no of days
                possibleWeight = middleWeight;
                maxWeight= middleWeight -1;
            }else if(returnedVal == 1){
                // Middle weight require more than the provided no of days
                minWeight = middleWeight +1;
            }else{
                // Middle weight require less than the provided no of days
                maxWeight = middleWeight -1;
            }
        }
        return possibleWeight;

    }

    private static int checkForDaysAndWeight(int days, int middleWeight,int [] weights) {
        int daysCounter = 1;
        int totalWeight = 0;
        for(int i =0 ; i < weights.length; i++){

            int currentWeight = weights[i];
            totalWeight = totalWeight + currentWeight;
            if(totalWeight > middleWeight){
                 daysCounter++;
                 totalWeight = currentWeight;
            }
        }
        if(daysCounter == days){
            return 0;
        }else if(daysCounter < days){
            return -1;
        }else{
            return 1;
        }
    }
}
