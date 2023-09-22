package dsa.linearsearch;

public class SearchIn2DArray {


    public static void main(String[] args) throws Exception {

        //Search in 2d Array
//        int[][] array2D = {
//                {23, 4, 1},
//                {18, 12, 3, 9},
//                {78, 99, 34, 56},
//                {18, 12}
//        };
//        int target = 120;
//        System.out.println( String.format("Is %d present in array : %s", target,search2dArray(array2D,target)));
        //
    }

    private static boolean search2dArray(int[][] array2D,int target) throws Exception {
        if(array2D.length == 0){
            throw new Exception("Empty array");
        }
        for(int row = 0; row < array2D.length; row++){
            for(int column = 0; column < array2D[row].length ; column++){
                if(array2D[row][column] == target){
                    return true;
                }
            }
        }
        return false;
    }
}
