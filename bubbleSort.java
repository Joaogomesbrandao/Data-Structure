import java.util.Scanner; import java.util.Arrays;

public class bubbleSort{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] arr = sc.nextLine().split(" ");
		int[] v = new int[arr.length];
		for (int k=0; k<arr.length;k++){
			v[k] = Integer.parseInt(arr[k]);
		}
		buble(v);
		System.out.println(Arrays.toString(v));
	}

	public static void buble(int[] v){
		for (int i=0; i < v.length-1; i++){
			for (int j=0; j<v.length-1-i;j++){
				if (v[j] > v[j+1]){
					int temp = v[j];
					v[j] = v[j+1];
					v[j+1] = temp;
				}
			}
		}
	}
}