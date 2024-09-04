package ArrayPractice;

import java.util.Scanner;

public class PrimeElements {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the size of the array : ");
		int size = scan.nextInt();
		int[] a = new int[size];
		
		for(int i=0; i<size; i++) {
			System.out.println("Enter the values :");
			a[i]=scan.nextInt();
		}
		
		int count=0;
		for(int i : a) {
			if(checkPrime(i)) {
				count++;
			}
		}
		int[] b = new int[count];
		int j=0;
		for(int i=0; i<size; i++) {
			if(checkPrime(a[i])) {
				b[j++]=a[i];
			}
		}
		
		System.out.print("[ ");
		for(int i: b) {
			System.out.print(i+" ");
		}
		System.out.println("]");
	}
	
	public static boolean checkPrime(int n) {
		int count=0;
		for(int i=1; i<=n; i++) {
			if(n%i==0) {
				count++;
			}
		}
		return count==2;
	}  

}
