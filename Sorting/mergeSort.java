package Sorting;
import java.util.Arrays;

public class mergeSort{
    public static void main(String[] args){
        int[] v = new int[]{5,2,3,4,1};
        meuSort(v,0,v.length-1);
        System.out.println(Arrays.toString(v));
    }
    
    private static void meuSort(int[] v, int ini, int fim) {
        if (ini < fim){
            int meio = (fim+ini)/2;
            meuSort(v,ini,meio);
            meuSort(v,meio+1,fim);
            merge(v,ini,meio,fim);
        }
    }
    
    private static void merge(int[] v, int ini, int meio, int fim){
        int[] helper = new int[v.length];
        int i = ini;
        int j = meio+1;
        int k = ini;
        
        for (int a = 0; a < v.length; a++){
            helper[a] = v[a];
        }
    
        while (i <= meio && j <= fim){
            if (helper[i] <= helper[j]){
                v[k++] = helper[i++];
            } else{
                v[k++] = helper[j++];
            }
        }
    
        while (i <= meio){
            v[k++] = helper[i++];
        }
    }
}