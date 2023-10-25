package dsa.binarsearchreallifebased;

public class BookAllocation {

    public static void main(String[] args) {
//        java.util.Collections
//        java.util.ArrayList<Integer> books = java.util.List.of(1 ,17 ,14, 9 ,15, 9 ,14);
//        int noOfStudent = 7; // Output : 113

        int [] books = { 1 ,17 ,14, 9 ,15, 9 ,14};
        int noOfStudent = 7; // Output : 71

        int maxPage = searchForMaxMinPage(books,noOfStudent);
        System.out.println("The max min page is "+ maxPage);
    }

    private static int searchForMaxMinPage(int[] books, int noOfStudent) {
        int minPossiblePage = books[0];
        int maxPossiblePage = books[0];
        for (int i = 1; i < books.length ; i++) {
            if (books[i] < minPossiblePage) {
                minPossiblePage = books[i];
            }
            maxPossiblePage = maxPossiblePage + books[i];

        }

        while (minPossiblePage <= maxPossiblePage){
            int middlePage = (maxPossiblePage - minPossiblePage)/2 + minPossiblePage;
            int returnValue = canBookDistributed(books,noOfStudent,middlePage);
            if(returnValue > noOfStudent){
               minPossiblePage = middlePage +1;
            }else{
                maxPossiblePage = middlePage -1;
            }
        }
        return minPossiblePage;
    }

    private static int canBookDistributed(int[] books, int noOfStudent, int middlePage) {

        int studentsPossible =1;
        int totalPage = 0;
        for(int bookPage : books){
            totalPage = totalPage + bookPage;
            if(totalPage > middlePage){
                studentsPossible++;
                totalPage = bookPage;
            }
        }
        return studentsPossible;

    }


}
