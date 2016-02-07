import java.util.*;


public class Monthly_wage {
	
	private double hourlypay = 3.75;
	private double eveningpay = 1.15;
	private double over0_2 = 1.25;
	private double over2_4 = 1.5;
	private double over_4 = 2;
	private double reghours, evehours, overhours1, overhours2, overhours3;
	private double totalpay;
	
	
	public String CalculateWage(List<Workday> wdays){ 
	
	//Wage calculated per employee, uses Workday methods to calculate different hours. 
	//get total number of normal hours, evening hours, overtime hours/month
	
		double overtime=0;
		for (Workday wday : wdays){
			reghours += wday.countRegHours();		//count regular hours 0-8
			evehours += wday.countEveHours();		//evening hours 18-06
			overtime = wday.getOverTime();			//get total overtime
			if (overtime<=2){
				overhours1 +=overtime;				//if only 2h or less
			}else if(2<overtime && overtime<=4){
				overhours1 +=2;						//if 2-4h of overtime
				overhours2 += (overtime-2);
			}else{
				overhours1 +=2;						//if over 4h overtime
				overhours2 +=2;
				overhours3 += (overtime-4);
			}

		}
		//calculate total salary
		double regpay = reghours*hourlypay;
		double evepay = evehours*eveningpay;
		double over1 = overhours1*over0_2*hourlypay;
		double over2 = overhours2*over2_4*hourlypay;
		double over3 = overhours3*over_4*hourlypay;
		
		totalpay += regpay+evepay+over1+over2+over3;
		//format the output
		String result = String.format("%.2f", totalpay);
		
		return result;
	}

}
