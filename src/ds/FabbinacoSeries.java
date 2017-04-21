
public class FabbinacoSeries {
	
	public static void main(String[] args) {
		System.out.println(generateFabbinaci(9));
		System.out.println(fabDP(9));
		
	}
	
	public static int generateFabbinaci(int n) {
		if (n <= 1) {
			return n;
		}
		
		return generateFabbinaci(n -1) + generateFabbinaci(n-2);
	}
	
	public static int fabDP(int n) {
		int[] fab = new int[n +1];
		
		fab[0] = 0;
		fab[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			fab[i] = fab[i -1] + fab[i -2];
		}
		
		return fab[n];
	}

}
