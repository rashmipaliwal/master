import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 * 
 */

/**
 * @author rashmi.paliwal
 *
 */
public class DigitalClock {
	
	public static void main(String[] args) {
		DigitalClock clock = new DigitalClock();
		TreeMap<Integer, List<Integer>> map = clock.getNumberOfLightsForNumbers();
		System.out.println("Binary of " + 5 + ": " + toBinary(5, ""));
		
		for (Integer number : map.keySet()) {
			System.out.println("Number: " + number + ":" +  map.get(number));
		}
		
		findAllPairsOfPossibleTimes(map, 1);
		
		System.out.println("Set bits " + countSetBitsInInt(16));
	}
	
	public static void findAllPairsOfPossibleTimes(TreeMap<Integer, List<Integer>> map, int k) {
		Integer[] count = map.keySet().toArray(new Integer[map.size()]);
		int i = 0;
		int j = count.length - 1;
		while (j >= i) {
			int sum = count[i] + count[j];
			if (sum == k) {
				System.out.println("Following numbers can be paired");
//				System.out.println(map.get(i));
//				System.out.println(map.get(j));
				getAllTimes(map.get(i), map.get(j));
				i++;
				j--;
			} else if (sum > k) {
				j--;
			} else if (sum < k) {
				i++;
			}
		}
	}
	
	public static void getAllTimes(List<Integer> arr1, List<Integer> arr2) {
		for (int i = 0; i < arr1.size(); i++) {
			for (int j = 0; j < arr2.size(); j++) {
				if (arr1.get(i) < 12) {
					System.out.println("Time:" + arr1.get(i) + ":" + arr2.get(j));
				}
				if (arr2.get(j) < 12) {
					System.out.println("Time:" + arr2.get(j) + ":" + arr1.get(i));
				}
			}
		}
	}
	
	
	public static TreeMap<Integer, List<Integer>> getNumberOfLightsForNumbers() {
		TreeMap<Integer, List<Integer>> numberOfLights = new TreeMap<Integer, List<Integer>>();
		
		for (int i = 0; i < 60; i++) {
			String binaryNumber = converIntToBinary(i);   // implement method for this
			int count = getNumberOfOnes(binaryNumber);
			if (numberOfLights.containsKey(count)) {
				numberOfLights.get(count).add(i); 
			} else {
				List<Integer> list = new  ArrayList<Integer>();
				list.add(i);
				numberOfLights.put(count, list);
			}
			
		}
		
		return numberOfLights;
	}

	private static int getNumberOfOnes(String binaryNumber) {
		int count = 0;
		for (int i = 0; i < binaryNumber.length(); i++) {
			if ('1' == binaryNumber.charAt(i)) {
				count++;
			}
		}
		return count;
	}
	
	public static String converIntToBinary(int n) {
		String binraryNumber = "";
		int k;
		
		for (int i = 6; i >= 0; i--) {
			k = n >> i;
		   if ((k&1) == 1) {
			   binraryNumber = binraryNumber + 1;
		   } else {
			   binraryNumber = binraryNumber + 0;
		   }
		}
		
		System.out.println("Binary of " + n  +": " + binraryNumber);
		return binraryNumber;
	}
	
	public static String toBinary(int n, String str) {
		if (n > 1) {
			str = toBinary(n/2, str) + n%2;
		} else {
			str = str + n%2;
			return str;
		}
	    /* step 2 */
//	    System.out.println("New Binary of " + n  +": " + n%2);
		return str;
	}
	
	public static int countSetBitsInInt(int n) {
		int count = 0;
		
		while (n > 0) {
			count = count + (n&1);
			n = n >> 1; 
		}
		
		return count;
	}
}
