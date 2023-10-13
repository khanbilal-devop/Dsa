package dsa.binarsearchreallifebased;

public class FindNthRootOfM {

    public static void main(String[] args) {
//        int n = 3;
//        int m = 27; //output : 3

        int n = 4;
        int m = 69; //output : -1

        int answer = findNthRootOfM(n,m);
        System.out.println("The answer is "+ answer);
    }


    /*
     Nth root of M means mutliplying means mutiplyin the number n times to reach the value M
     i.2 3th root of 27 means 3*3*3 = 27
     */
    private static int findNthRootOfM(int n, int m) {
        int start =1;
        int end = m;
        while (start <= end){
            int middle = (end - start)/2 + start;
            int nthRoot = 1;

            // Calulating nth times of the middle element
            for(int i = 1; i <= n; i++ ){
                nthRoot = nthRoot * middle;
            }

            // Comapring nthRoot of middle element with m if equal then return m
            if(nthRoot == m){
                return middle;
            }else if(nthRoot > m){
                // Comapring nthRoot of middle element with m if greater that means all values to the right will also be greater
                // so neglecting all those
                end = middle -1;
            }else{
                // Comapring nthRoot of middle element with m if small that means all values to the left will also be smaller
                // so neglecting all those
                start = middle+1;
            }
        }
        return  -1;
    }
}
