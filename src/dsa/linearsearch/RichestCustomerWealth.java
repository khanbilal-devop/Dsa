package dsa.linearsearch;


// Leet code problem
// https://leetcode.com/problems/richest-customer-wealth/
public class RichestCustomerWealth {

    public static void main(String[] args) {
       int[][] persons = {{2,8,7},{7,1,3},{1,9,5}};
       int maxWealth = searchForWealth(persons);
        System.out.println(maxWealth);
    }

    private static int searchForWealth(int[][] persons) {
        int maxWealth = 0;

        for(int[] accounts : persons){
            int sum = 0;
            for(int wealth :accounts){
                sum += wealth;
            }
            if(sum > maxWealth){
                maxWealth = sum;
            }
        }

        return maxWealth;
    }

}
