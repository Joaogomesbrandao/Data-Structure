import java.util.Scanner;

//Realizando a busca binária recursiva printando os índices visitados.
public class buscaBinaria {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] vetor = sc.nextLine().split(" ");
        int num = sc.nextInt();
        int[] v = new int[vetor.length];
        for (int k=0;k<vetor.length;k++) v[k] = Integer.parseInt(vetor[k]);
        System.out.println(busca(v,num,0,v.length-1));
        sc.close();
    }

    public static int busca(int[] v, int num, int ini, int fim){
        int meio = (ini+fim)/2;
        if (ini > fim) return -1;
        else if (v[meio] == num) return meio;
        System.out.println(meio);
        if (v[meio] > num) return busca(v,num,ini,meio-1);
        else if (v[meio] < num) return busca(v,num,meio+1,fim);
        else return -1;
    }
}
