package dsa.binarysearchquestion;

public class Ceiling {

    public static void main(String[] args) {
//        int[] arr = {3, 6, 7, 9, 12, 16};
        int[] arr = {13,12,11,9,8,4};
//        int[] arr = {};
//        int[] arr = {5};
//        int[] arr = {5,5,5,5,5};

        int targetEl = 8;
        int result = searchForCeilingNo(arr, targetEl);
//        int result = ceiling(arr,targetEl);
        System.out.println(result);
    }

    private static int searchForCeilingNo(int[] arr, int targetEl) {
        var arrLength = arr.length;
        int result = checkForOrderAndRangeCheck(arr, targetEl);
        boolean isAscending = result == 0;
        int start = 0;
        int end = arrLength - 1;
        while (start <= end) {
            int middleIndex = (start + (end - start) / 2);
            if (isAscending) {
                if (arr[middleIndex] > targetEl) {
                    end = middleIndex - 1;
                } else if (targetEl == arr[middleIndex]) {
                    return arr[middleIndex];
                } else {
                    start = middleIndex + 1;
                }
            } else {
                if (arr[middleIndex] < targetEl) {
                    end = middleIndex - 1;
                } else if (targetEl == arr[middleIndex]) {
                    return arr[middleIndex];
                } else {
                    start = middleIndex + 1;
                }
            }
        }
        return arr[start];
    }


    private static int checkForOrderAndRangeCheck(int[] arr, int targetEl) {
        boolean isAscending = true;
        var arrLength = arr.length;
        if (arrLength == 0) {
            throw new RuntimeException("Array found to be empty");
        } else {
            if (arr[0] == arr[arrLength - 1]) {
                if (arr[0] >= targetEl) {
                    return arr[0];
                }
                throw new RuntimeException("No Ceiling number found");
            } else if (arr[0] > arr[arrLength - 1]) {
                isAscending = false;
                if (targetEl <= arr[arrLength - 1]) {
                    return arr[arrLength - 1];
                } else if (targetEl > arr[0]) {
                    throw new RuntimeException("No Ceiling number found");
                }
            } else {
                if (targetEl <= arr[0]) {
                    return arr[0];
                } else if (targetEl > arr[arrLength - 1]) {
                    throw new RuntimeException("No Ceiling number found");
                }
            }
        }
        return isAscending ? 0 : -1;
    }

}



