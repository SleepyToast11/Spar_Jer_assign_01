package FOO;
import java.util.Arrays;

/**
 * Name: Jerome Sparnaay
 * Date: January 18th, 2022
 * Description: method for array manipulation program and testing of said methods
 */
public class Main {

        /**
         * Generates a random integer in a specified range
         * @param min minimum value the random value can be inclusively
         * @param max maximum value the generated value can be inclusively
         * @return a random integer inside the range of min, max inclusively
         * */
        public static int randomIntGenerator(int min, int max){

            return (int)Math.floor(Math.random()*(max-min+1)+min);
        }

        /**
         * generates a one-dimensional array of a specified size with random values
         * @param size size of the array needing to be generated
         * @return A one-dimensional array of random values going from 0 to 100 of size provided
         * */
        public static int[] generateArray(int size) {

            int[] array = new int[size];

            for (int i = 0; i < array.length; i++)
                array[i] = randomIntGenerator(0, 100);

            return array;
        }

        /**
         * generates a two-dimensional array of a specified size with random values
         * @param rows number of rows of the array needing to be generated
         * @param columns number of columns of the array needing to be generated
         * @return A two-dimensional array of random values going from 0 to 100 of size provided
         * */
        public static int[][] generateArray(int rows, int columns) {

            int[][] array = new int[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    array[i][j] = randomIntGenerator(0, 10);
                }
            }
            return array;
        }

        /**
         * prints array on a single line with elements
         * separated with spaces and ended with an end-line
         * @param array one-dimensional array
         */
        public static void displayArray(int[] array){

            StringBuilder arrayString = new StringBuilder();
            for (int j : array) arrayString.append(j).append(" ");

            System.out.println(arrayString);
        }

        /**
         * prints each row of a two-dimensional array by passing each
         * row separately to displayArray
         * @param array two-dimensional array
         * */
        public static void displayArray(int[][] array){
            for (int[] ints : array) displayArray(ints);
        }

        /**
         * verifies if two one-dimensional array are of equal length and if every
         * index of the arrays are equal in value
         * as a result
         * @param array1 one-dimensional array to be compared to array2
         * @param array2 one-dimensional array to be compared to array1
         * @return boolean value of if the two provided arrays are equal
         * */
        public static boolean arrayEqual(int[] array1,int[] array2){

            if (array1.length != array2.length)
                return false;

            for (int i = 0; i < array1.length; i++){
                if (array1[i] != array2[i])
                    return false;}

            return true;
        }

        /**
         * copies array from the index value first to the index of last inclusively
         * @param array array to be partially copied
         * @param first integer of first index to be copied
         * @param last integer of the last index of the array to be copied
         * @return a copied one-dimensional array from the first to last index
         * */
        public static int[] copyArray(int[] array, int first, int last){

            int[] copiedArray = new int[last-first + 1];

            for (int i = first; i <= last; i++) {
                copiedArray[i] = array[i];
            }

            return copiedArray;
        }

        /**
         * Sums all the elements of a one-dimensional
         * @param array one-dimensional array
         * @return the sum of the 1d array as an int
         * */
        public static int arraySum(int[] array){

            int sum = 0;
            for (int i : array) sum += i;

            return sum;
        }

        /**
         * Sums all the rows of a two-dimensional array by passing
         * them as a one dimensional array into the method for 1d array summation
         * @param array two-dimensional array
         * @return the sum of the 2d array as an int
         * */
        public static int arraySum(int[][] array){

            int sum = 0;

            for (int[] i : array) sum += arraySum(i);
            return sum;
        }

        /**
         * if called with an int and a 2d array, sums up the row at the index row of the
         * two-dimensional array by passing it as a one dimensional array into the method for 1d array summation
         * @param array two-dimensional array
         * @param row index of row to be summed up
         * @return the sum of the row of the 2d array as an int
         * */
        public static int arraySum(int[][] array, int row){

            int sum;

            sum = arraySum(array[row]);
            return sum;
        }

        /**
         * finds the hemming distance between two arrays
         * @param array1 first 1d array to be compared with array2
         * @param array2 second 1d array to be compared with array1
         * @return the number of indexes where integers differ from one another
         * */
        public static int hammingDistance(int[] array1,int[] array2){

            int hammingDistanceCounter = 0;

            for (int i = 0; i < array1.length; i++){
                if (array1[i] != array2[i])
                    hammingDistanceCounter++;}

            return hammingDistanceCounter;
        }

        /**
         * makes a copy and sorts passed array and searches for the element
         * using binary search algorithm
         * @param array array to be search for if the element is present
         * @param element element to be searched for in the array
         * @return boolean value of if the element was found in the array
         * @see java.util.Arrays sort method used
         * */
        public static boolean binarySearch(int[] array, int element){

            int[] arrayCopy = copyArray(array, 0, array.length-1);
            int start = 0, last = array.length - 1, midpoint = array.length/2;
            Arrays.sort(arrayCopy);

            while(start <= last){

                if(arrayCopy[midpoint] == element)
                    return true;    //returns true if algorithm find value at midpoint

                else if(arrayCopy[midpoint] < element)
                    start = midpoint +1;

                else if (arrayCopy[midpoint] > element)
                    last = midpoint -1 ;

                midpoint = (last + start) / 2;
            }
            return false;   //if search algorithm fails to find, returns false
        }

    /**
     * tests all required methods by generating random arrays and performing
     * operations on them using methods of this same class
     * @param args command line parameter
     * */
    public static void main(String[] args) {

        System.out.println("Generating 1d array, size 10:");
        int[] oneDArray1 = generateArray(10);
        displayArray(oneDArray1);

        System.out.println("\ncopying this array:");
        int[] oneDArray1copy = copyArray(oneDArray1, 0, oneDArray1.length-1);
        displayArray(oneDArray1copy);

        System.out.println("\nGenerating 1d array, size 5:");
        int[] oneDArray2 = generateArray(10);
        displayArray(oneDArray2);

        System.out.println("\nAre they equal:" + arrayEqual(oneDArray1,oneDArray2));
        System.out.println("\nis first array equal to its copy:" + arrayEqual(oneDArray1,oneDArray1copy));

        System.out.println("\nhamming distance of the 2 arrays: " + hammingDistance(oneDArray1,oneDArray2));
        System.out.println("\nhamming distance between 2 identical array: " + hammingDistance(oneDArray1, oneDArray1copy));

        int number = randomIntGenerator(0, 100);
        System.out.println("\nis " + number + " in first array? " + binarySearch(oneDArray1, number));
        System.out.println("\nis " + oneDArray1[3] + "in first array: " + binarySearch(oneDArray1, oneDArray1[3]));

        System.out.println("\ngenerating 2 4x4 2d arrays:");
        int[][] twoDArray1 = generateArray(4,4);
        int[][] twoDArray2 = generateArray(4,4);

        displayArray(twoDArray1);
        System.out.println("\n--------------------------");
        displayArray(twoDArray2);

        System.out.println("adding second row of first 2d array: " + arraySum(twoDArray1, 1));

    }
}
