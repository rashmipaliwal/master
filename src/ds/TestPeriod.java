import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class TestPeriod {
	
	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date doj = sdf.parse("2016-09-15");
		LocalDate dateOfJoining = doj.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate today = LocalDate.now();
        
        long daysBetween = ChronoUnit.DAYS.between(dateOfJoining, today);
        long monthsBetween = ChronoUnit.MONTHS.between(dateOfJoining, today);
        
      	  
      	  if (daysBetween < 6) {
      		System.out.println("Time gap is less then 6 days");
      	  } else if (daysBetween < 42) {
      		System.out.println("Time gap is less then 6 weeks");
      	  } else if (monthsBetween < 6) {
      		  System.out.println("Time gap is less then 6 months");
      	  }

	}

}
