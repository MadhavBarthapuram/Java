package Recursion_Examples;
public class Recursion_Demo {
	private static char[] printnums(int i) {
		System.out.println(i);
		i++;
		if(i<10) {
			printnums(i);
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		printnums(0);
	}
}
