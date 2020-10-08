package three;

import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AgeCalculator1 {
	public static int calculateAge(String DOB) throws ParseException{//throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(DOB));
		int cyear = Calendar.getInstance().get(Calendar.YEAR);
		int dyear = c.get((Calendar.YEAR));
		return cyear - dyear;
		
	}

}
