
public class LCMOfNumbers {
	
public static void main(String[] args) {
	int[] array = {1,2,3,4,5, 6, 7};
	System.out.println("LCM=" + lcm(array, array.length));
}	
	
	static int gcd(int a, int b) {
		  if (b == 0) return a;
		  return gcd(b, a%b);
		}
	
		static int lcm(int[] a, int n) {
		  int res = 1, i;
		  for (i = 0; i < n; i++) {
		    res = res*a[i]/gcd(res, a[i]);
		  }
		  return res;
		}

}
