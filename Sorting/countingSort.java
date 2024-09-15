package Sorting;
import java.util.Arrays;

public class countingSort {
    public static void main(String[] args){
        int[] v = new int[]{5,2,1,4,3};
        int[] out = sort(v);
        System.out.println(Arrays.toString(out));
    }

    /**
     * Method that applies the counting sort strategy to order numbers.
     */
    private static int[] sort(int[] v){
        // Looking for the biggest number in this sequence.
        int biggest = searchBiggest(v);

        // Creating an array of size equal to the largest number found.
        int[] frequence = new int[biggest];

        // The array that will be ordered.
        int[] out = new int[v.length];

        /*
         * Saving the numbers frequencies that appear.
         */
        for (int i = 0; i < v.length; i++){
            frequence[v[i]-1] += 1;
        }

        /**
         * Accumulatively adding the frequencies.
         */
        for (int j = 1; j < frequence.length; j++){
            frequence[j] += frequence[j-1];
        }

        /**
         * Assigning the numbers to their proper positions.
         */
        for (int k = v.length-1; k >= 0; k--){
            out[frequence[v[k]-1]-1] = v[k];
            frequence[v[k]-1] -= 1;
        }

        return out;
    }

    /**
     * Another way to sort an array using the booleans values.
     */
    private static int[] sortOne(int[] v){
        int biggest = searchBiggest(v);
        boolean[] frequencies = new boolean[biggest];
        int[] out = new int[v.length];
        int i_aux = 0;

        for (int i = 0; i<v.length; i++){
            frequencies[v[i]-1] = true;
        }

        for (int j = 0; j<frequencies.length; j++){
            if (frequencies[j] == true){
                out[i_aux] = j+1;
                i_aux += 1;
            }
        }

        return out;
    }

    private static int searchBiggest(int[] v){
        int i = 0;
        for (int j = 1; j < v.length; j++){
            if (v[j] > v[i]){
                i = j;
            }
        }
        return v[i];
    }


}
