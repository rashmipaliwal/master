/**
 * 
 */

/**
 * @author rashmi.paliwal
 *
 */
public class JavaDataStructure {

	// Define the problem


	

	 public static void main(String[] args) {
	        // get the inputs
	        int[] numbers =  {1,2,3,4,5};
	        
	       // lcm = a*b/(gcd(a,b))
	       int lcm = getLcm(numbers);
	       System.out.println("LCM is: " + lcm);
	 
	 }
	 
	 public static int getLcm(int[] numbers) {
	     int sol = 1;
	     
	     for (int i = 0; i < numbers.length; i++) {
	         sol = sol * numbers[i] / (gcd(sol, numbers[i]));
	     }
	     
	     return sol;
	 }
	 
	 public static int gcd(int a, int b) {
	     if (b==0) {
	         return a;
	     }
	     
	     return gcd(b, a%b);
	 }


	
}
