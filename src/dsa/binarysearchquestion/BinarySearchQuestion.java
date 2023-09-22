package dsa.binarysearchquestion;

//Smallest alphabet greater than a given character
public class BinarySearchQuestion {

    public static void main(String[] args) {

//        char []  letters = {'h', 'n', 's'};
//        char targetEl =  't'; // Output : 'h'

//        char []  letters = {'D', 'J', 'K'};
//        char targetEl = 'B'; // Output : 'D'

//        char []  letters = {'D', 'E', 'K'};
//        char targetEl = 'B'; // Output : 'E'

        char []  letters = {'D', 'E', 'K'};
        char targetEl = 'E'; // Output : 'K'

       int index  = search(letters,targetEl);
        System.out.println("Index of the result is "+index);

    }

    private static int search( char [] letters, int targetEl){
        if(targetEl > letters[letters.length -1]){
            return 0;
        }
        int start = 0;
        int end = letters.length -1;

        while(start <= end){
            int middleIndex = (start + end)/2;
            if(letters[middleIndex] > targetEl){
                end = middleIndex -1 ;
            }else{
                start = middleIndex + 1;
            }
        }
        return start;
    }
}
