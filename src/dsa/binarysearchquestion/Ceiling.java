package dsa.binarysearchquestion;

public class Ceiling {

    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 9, 12, 16};
//        int[] arr = {13,12,11,9,8,4};
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
//                    if(targetEl > arr[middleIndex]){
//                        if(previousGreaterEl == 0){
//                            end = middleIndex - 1;
//                        }else{
//                            return previousGreaterEl;
//                        }
//                    }else if(targetEl ==  arr[middleIndex]){
//                        return arr[middleIndex];
//                    }else {
//                        start = middleIndex + 1;
//                        previousGreaterEl = arr[middleIndex];
//                    }
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

    private static int searchForCeiling(int[] arr, int targetEl) {
        int length = arr.length;
        if (length == 0) {
            throw new RuntimeException("Array is empty");
        }
        boolean isAscending = true;
        if (arr[0] > arr[length - 1]) {
            isAscending = false;
            if (arr[0] < targetEl) {
                throw new RuntimeException("No ceiling can be found for given number");
            }
        } else if (arr[0] == arr[length - 1]) {
            if (arr[0] >= targetEl) {
                return arr[0];
            } else {
                throw new RuntimeException("No ceiling can be found for given number");
            }
        } else {
            if (arr[length - 1] < targetEl) {
                throw new RuntimeException("No ceiling can be found for given number");
            }
        }

        int start = 0;
        int end = length - 1;
        do {
            int middle = start + ((end - start) / 2);
            if (arr[middle] == targetEl) {
                return targetEl;
            }
            if (isAscending) {
                if (arr[middle] < targetEl) {
                    start = 1 + middle;
                } else {
                    if (middle == 0 || arr[middle - 1] >= targetEl) {
                        end = middle - 1;
                    } else {
                        return arr[middle - 1];
                    }
                }
            } else {
                if (arr[middle] < targetEl) {
                    end = 1 + middle;
                } else {
                    if (middle == length - 1 || arr[middle + 1] >= targetEl) {
                        start = middle + 1;
                    } else {
                        return arr[middle + 1];
                    }

                }
            }
        } while (start <= end);
        return isAscending ? arr[length - 1] : arr[0];
    }

    static int ceiling(int[] arr, int target) {

        // but what if the target is greater than the greatest number in the array
        if (target > arr[arr.length - 1]) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }
        }
        return start;
    }
}



