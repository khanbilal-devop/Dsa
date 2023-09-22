package dsa.binarysearch;

public class Search {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4,5,8,13,15,23,25};
        var targetEl = 23;
//        boolean isExist = existUsingBinarySearch(arr, targetEl);
        boolean isExist = existUsingBinarySearch2(arr,targetEl);
        System.out.println(isExist);
    }

    // Brute force
    private static boolean existUsingBinarySearch(int[] arr, int targetEl) {
        boolean isExist = false;
        int startIndex = 0;
        int uptoIndex = arr.length - 1;
        int middleIndex = arr.length / 2;
        for (int index = 0; index < Math.ceil(arr.length / 2.0); index++) {
            if (arr[middleIndex] == targetEl) {
                return true;
            } else if (arr[middleIndex] < targetEl) {
                var temp = middleIndex;
                startIndex = middleIndex;
                middleIndex = (uptoIndex + startIndex) / 2;
                if (temp == middleIndex)
                    middleIndex++;
            } else {
                var temp = middleIndex;
                uptoIndex = middleIndex;
                middleIndex = (uptoIndex - startIndex) / 2;
                if (temp == middleIndex)
                    middleIndex--;
            }
        }
        return isExist;
    }


    //Clean and optimize
    private static boolean existUsingBinarySearch2(int[] arr, int targetEl) {
        boolean isExist = false;
        int start = 0;
        int end = arr.length -1;
        int middleIndex = start + ((end- start)/2);
        while (start <= end){
            if(arr[middleIndex] == targetEl){
                return true;
            }else if(arr[middleIndex] < targetEl){
                start = ++middleIndex;
            }else {
                end = --middleIndex;
            }
        }
        return isExist;
    }

}
