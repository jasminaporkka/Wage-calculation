
import org.joda.time.DateTime;
import org.joda.time.Period;

public class Workday {
	
	//class for one workday
	private String datestring;
	private String starthour;
	private String endhour;
	private int employeeid;
	private double hours, regHours, overTime, eveningHours;
	private DateTime dt1;
	private DateTime dt2;
	
	
	public Workday(int id, String date, String start, String end){
		employeeid = id;
		datestring = date;
		starthour= start;
		endhour = end;
		
	}
	//calculate regular hours (0<hours<8 per day) and count overtime hours if regular hours
	//excel 8 hours/day
	public double countRegHours(){
		String[] datel = datestring.split("\\.");
		int day = Integer.parseInt(datel[0]);
		int month = Integer.parseInt(datel[1]);
		int year = Integer.parseInt(datel[2]);
		String[] timel = starthour.split(":");
		int hour1 = Integer.parseInt(timel[0]);
		int minute1 = Integer.parseInt(timel[1]);
		dt1 = new DateTime(year, month, day, hour1, minute1);
		
		String[] time2 = endhour.split(":");
		int hour2 = Integer.parseInt(time2[0]);
		int minute2 = Integer.parseInt(time2[1]);
		dt2 = new DateTime(year, month, day, hour2, minute2);
		
		
		Period p = new Period(dt1, dt2);
		hours = p.getHours();
		double minutes = p.getMinutes();
		
		if (hours<0){
			hours = 24+hours;
		}
		
		hours += minutes/60;
		if (hours>8){
			overTime = hours-8;
			regHours = 8;
		}else{
			regHours=hours;
			overTime=0;
		}
	
		return regHours;
	}
	//count evening hours 18-06
	public double countEveHours(){
	    double beginHour = dt1.getHourOfDay();
	    double endHour = dt2.getHourOfDay();

	    if (beginHour < endHour) {
	        for (double a=beginHour; a< endHour; a++) {
	            if ((a>=18)||(a<=6)) {
	                eveningHours++;
	            }
	        }
	    } else {
	        endHour = endHour + 24;
	        for (double a=beginHour; a< endHour; a++) {
	            if ((a>=18)||(a<=6)) {
	                eveningHours++;
	            }
	        }
	    }
	    return eveningHours;
	}
	public double getOverTime(){
		
		return overTime;
	}
	public String getDate(){
		return datestring;
	}
	
	

}
