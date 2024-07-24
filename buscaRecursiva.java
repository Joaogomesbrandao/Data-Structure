import java.util.Scanner;

public class buscaRecursiva{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String num = sc.nextLine();
		String[] vetor = sc.nextLine().split(" ");
		System.out.println(busca(vetor,num,0));
		sc.close();		
	}

	public static int busca(String[] v, String num, int index){
		if (index > v.length-1) return -1;
		if (v[index].equals(num)){
			return index;
		} else{
			return busca(v,num,index+1);
		}
	}
}
