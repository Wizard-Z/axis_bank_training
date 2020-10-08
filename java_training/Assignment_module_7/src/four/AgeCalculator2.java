package four;


import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AgeCalculator2 {
		public static int calculateAge(String DOB)throws Exception,InvalidDOBException {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.setLenient(false);
			Calendar c = Calendar.getInstance();
			c.setTime(sdf.parse(DOB));
			if(c.compareTo(Calendar.getInstance())>0)
				throw new InvalidDOBException();
			int cyear = Calendar.getInstance().get(Calendar.YEAR);
			int dyear = c.get((Calendar.YEAR));
			//System.out.println(cyear+":"+dyear);
			return cyear - dyear;
		}
}
