import java.util.Arrays;
import java.util.Scanner;

public class selectionSortRecursivo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int[] v = new int[arr.length];
        for (int k=0;k<arr.length;k++){
            v[k] = Integer.parseInt(arr[k]);
        }
        selection(v,0);
    }

    private static void selection(int[] v, int index){
        if (index == v.length-1) return;
        int indexMenor = index;
        for (int j = 1+index; j<v.length;j++){
                if (v[j] < v[indexMenor]){
                    indexMenor= j;
                }
            }
        swapp(v,index,indexMenor);
        System.out.println(Arrays.toString(v));
        selection(v,index+1);
    }

    private static void swapp(int[] v, int index1, int index2){
        int temp = v[index1];
        v[index1] = v[index2];
        v[index2] = temp;
    }
}