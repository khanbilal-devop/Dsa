package dsa.linearsearch;

public class FindMin {

    public static void main(String[] args) throws Exception {

        // Finding minimum number
//        int[] numbersArr = {1,3,-8,-2,0,5,-5};
//        System.out.println(findMinNumber(numbersArr));
    }

    static int findMinNumber(int[] numbersArr) throws Exception {
        if(numbersArr.length == 0){
            throw  new Exception("Empty array passed");
        }
        var minimumNumber = numbersArr[0];
        for(int index = 1 ; index < numbersArr.length ;index++){
            if(numbersArr[index] < minimumNumber){
                minimumNumber = numbersArr[index];
            }
        }
        return minimumNumber;
    }

}
