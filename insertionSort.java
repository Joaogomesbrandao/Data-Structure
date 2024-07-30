import java.util.Arrays;
import java.util.Scanner;

public class insertionSort {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int[] v = new int[arr.length];
        for (int k=0;k<arr.length;k++){
            v[k] = Integer.parseInt(arr[k]);
        }
        insertion(v);
        System.out.println(Arrays.toString(v));
        sc.close();
    }

    private static void insertion(int[] v){
        for (int i = 1; i<v.length;i++){
            int j = i;
            while (j > 0 && v[j] < v[j-1]){
                swapp(v, j, j-1);
                j--;
            }
        }
    }

    private static void swapp(int[] v, int index1, int index2){
        int temp = v[index1];
        v[index1] = v[index2];
        v[index2] = temp;
    }
}
