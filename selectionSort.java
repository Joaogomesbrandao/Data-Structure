import java.util.Arrays;
import java.util.Scanner;

public class selectionSort {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int[] v = new int[arr.length];
        for (int k=0;k<arr.length;k++){
            v[k] = Integer.parseInt(arr[k]);
        }
        selection(v);
        System.out.println(Arrays.toString(v));
        sc.close();
    }

    private static void selection(int[] v){
        for (int i = 0; i<v.length; i++){
            int indexMenor = i;
            for (int j = 1+i; j < v.length; j++){
                if (v[j] < v[indexMenor]){
                    indexMenor = j;
                }
            }
            swapp(v,i,indexMenor);
        }
    }

    private static void swapp(int[] v, int index1, int index2){
        int temp = v[index1];
        v[index1] = v[index2];
        v[index2] = temp;
    }
}
