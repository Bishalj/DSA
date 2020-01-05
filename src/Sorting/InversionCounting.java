package Sorting;

public class InversionCounting {
        static  int result;
        public static void main(String[] args) {
            int array[] = { 5,7,6,2,4,3,1};
            int lowerBoundIndex = 0;
            int upperBoundIndex = array.length - 1;
            displayArray(array);
            mergeSorts(array, lowerBoundIndex, upperBoundIndex);
            displayArray(array);
            System.out.println(result);
        }

        private static int mergeSorts(int[] array, int lowerBoundIndex, int upperBoundIndex) {
            int count = 0;
            if(lowerBoundIndex >= upperBoundIndex)
                return count;

            int middleIndex = (lowerBoundIndex + upperBoundIndex)/2;

            count = mergeSorts(array, lowerBoundIndex, middleIndex);
            count += mergeSorts(array, middleIndex + 1, upperBoundIndex);
            count += mergeArrays(array, lowerBoundIndex, middleIndex, upperBoundIndex);
            return count;
        }

        private static int mergeArrays(int[] array, int lowerBoundIndex, int middleIndex, int upperBoundIndex) {
            int leftArray[] = new int[middleIndex - lowerBoundIndex + 1];
            int rightArray[] = new int[upperBoundIndex - middleIndex];
            int leftArraySize = leftArray.length;
            int rightArraySize = rightArray.length;
            int res = 0;
            for(int i=0; i<leftArraySize; i++) {
                leftArray[i] = array[lowerBoundIndex + i];
            }

            for(int j=0; j<rightArraySize; j++) {
                rightArray[j] = array[middleIndex + j + 1];
            }

            int leftArrayStartIndex = 0;
            int rightArrayStartIndex = 0;
            int newArrayIndex = lowerBoundIndex;
            while(leftArrayStartIndex < leftArraySize && rightArrayStartIndex < rightArraySize){
                if(leftArray[leftArrayStartIndex] <= rightArray[rightArrayStartIndex]) {
                    array[newArrayIndex++] = leftArray[leftArrayStartIndex++];

                }
                else {
                    array[newArrayIndex++] = rightArray[rightArrayStartIndex++];
                    res += leftArraySize - leftArrayStartIndex;
                }
            }

            while(leftArrayStartIndex < leftArraySize)
                array[newArrayIndex++] = leftArray[leftArrayStartIndex++];

            while(rightArrayStartIndex < rightArraySize)
                array[newArrayIndex++] = rightArray[rightArrayStartIndex++];

            return res;
        }

        private static void displayArray(int[] array) {
            for (int element: array)
                System.out.print(element + " ");
            System.out.println();
        }
    }
