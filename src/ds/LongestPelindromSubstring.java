/**
 * 
 */

/**
 * @author rashmi.paliwal
 *
 */
public class LongestPelindromSubstring {
	
	private static String getLongestPelindromSubstring(String str) {
		
		int start = 0;
		int maxLength = 0;
		
		int low, high;
		
		char[] charArray = str.toCharArray();
		
	// we have to find all odd and even pelindrom and record the maxlength and a start point
	for (int i = 1; i < str.length() - 1; i ++) {
		
		
		// get all even pelindrome
		low = i-1;
		high = i;
		
		while (low >= 0 && high < str.length() && charArray[low] == charArray[high]) {
			if ((high - low) +1 > maxLength) {
				maxLength = (high - low) + 1;
				start = low;
			}
			--low;
			++ high;
		}
		
		// get all odd pelindrome
		low = i-1;
		high = i+1;
		while (low >= 0 && high < str.length() && charArray[low] == charArray[high]) {
			if ((high - low) +1 > maxLength) {
				maxLength = (high - low) + 1;
				start = low;
			}
			--low;
			++high;
		}
	}
	
	String longestSubstring = str.substring(start, start + maxLength);
	System.out.println("Longst pelindrome: " + longestSubstring);
	return longestSubstring;
		
	}
	
	public static void main(String[] args) {
		String str = "forgeeksskeegfor";
		
		getLongestPelindromSubstring(str);
		
	}

}
