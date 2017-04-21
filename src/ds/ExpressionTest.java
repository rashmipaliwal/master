import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ExpressionTest {

	public static void main(String[] args) {
		List<String> listOfWords;
		String listOfWordsStr;
		
		int inputCount; 
		
		Map<Integer, List<String>> reviewMap = new HashMap<Integer, List<String>>();
		Map<Integer, Integer> mapReviewCount = new LinkedHashMap<Integer, Integer>();
		
	     
	      Scanner in = new Scanner(System.in);

	      listOfWordsStr = in.nextLine();
	      listOfWords = Arrays.asList(listOfWordsStr.split("\\s+"));
	      
	      inputCount = in.nextInt();
	      
	      for (int i = 0; i < inputCount; i++) {
	    	  int hotelId = in.nextInt();
	    	  in.nextLine();
	    	  String review = in.nextLine();
	    	  
	    	  if (reviewMap.containsKey(hotelId)) {
	    		  reviewMap.get(hotelId).add(review);
	    	  } else {
	    		  List<String> reviews = new ArrayList<String>();
	    		  reviews.add(review);
	    		  reviewMap.put(hotelId, reviews);
	    	  }
	      }
	      
	      in.close();
	      
	      
	    	  for (int hotelId : reviewMap.keySet()) {
	    		  List<String> reviews = reviewMap.get(hotelId);
	    		  int wordCount = 0;
	    		  for (String word : listOfWords) {
	    			  for (String review : reviews) {
			    		  if (review.contains(word)) {
			    			  wordCount++;
			    		  }
	    			  }
	    		  }
	    		  mapReviewCount.put(hotelId, wordCount);
	    	  }
	    	  
	    	  mapReviewCount.entrySet().stream()
	    	    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
	    	    .forEach(entry ->  System.out.println(entry.getKey()));
	 
	}
}
