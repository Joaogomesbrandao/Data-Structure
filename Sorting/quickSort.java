package Sorting;
import java.util.Arrays;

public class quickSort {
    public static void main(String[] args){
        int[] v = new int[]{7, 8, 1, 2, 90, 4, 65, 32};
        sort(v, 0, v.length-1);
        System.out.println(Arrays.toString(v));
    }

    /**
     * Method that applies the QuickSort algorithm.
     * 
     * You can choose which varitation of lomuto to use.
     */
    private static void sort(int[] v, int left, int rigth){
        if (left < rigth){
            int i_pivot = hoare(v, left, rigth);
            sort(v, left, i_pivot-1);
            sort(v, i_pivot+1, rigth);
        }
    }

    /**
     * The first method is the classical Lomuto, when we choose the first number of sequence every time.
     */
    private static int lomuto(int[] v, int left, int right){
        int pivot = v[left];
        int i = left;

        for (int j = left+1; j<=right; j++){
            if (v[j] <= pivot){
                i+=1;
                swapp(v,i,j);
            }
        }
        swapp(v,left,i);
        return i;
    }

    /**
     * The second method is the Lomuto when we choose a random number to be the pivot's index.
     */
    private static int lomutoRandom(int[] v, int left, int right){
        // change the first number of sequence with a random number;
        int range = right - left +1;
        int random_index = (int)(Math.random() * range) + left;
        swapp(v, left, random_index);

        
        int pivot = v[left];
        int i = left;

        for (int j = left+1; j<=right; j++){
            if (v[j] <= pivot){
                i+=1;
                swapp(v,i,j);
            }
        }
        swapp(v,left,i);
        return i;
    }

    /**
     * The third method is the Lomuto when we choose the median of three sequence numbers.
     * (v[left],v[mid] and v[right]).
     */
    private static int lomutoMidPivot(int[] v, int left, int right){
        // change the first number of sequence with a median of three numbers;
        int median = pickPivotIndex(v, left, right);
        swapp(v, left, median);

        
        int pivot = v[left];
        int i = left;

        for (int j = left+1; j<=right; j++){
            if (v[j] <= pivot){
                i+=1;
                swapp(v,i,j);
            }
        }
        swapp(v,left,i);
        return i;
    }

    /**
     * Private method to pick the median of three sequence numbers.
     */
    private static int pickPivotIndex(int[] v, int ini, int fim){
        int mid = (ini+fim)/2;
        int[] values = new int[]{v[ini],v[mid],v[fim]};
        Arrays.sort(values);

        if (values[1] == v[ini]) return ini;
        else if (values[1] == v[mid]) return mid;
        else return fim;
    }

    /**
     * Private method that applies the Hoare strategy of partition.
     */
    private static int hoare(int[] v, int left, int right){
        int i = left + 1;
        int j = right;
        int pivot = v[left];

        while(i <= j){
            while(i <= j && v[i] <= pivot){
                i++;
            }
            while (i <= j && v[j] > pivot){
                j -= 1;
            }
            if (i < j){
                swapp(v, i, j);
            }
        }

        swapp(v, left, j);
        return j;
    }

    /**
     * Private method to change numbers according to their respective indices.
     */
    private static void swapp(int[] v, int i0, int i1){
        int value = v[i0];
        v[i0] = v[i1];
        v[i1] = value;
    }
}