import java.util.*;



public class main {
	
	//format the outcome date and lists of employee names and their wages to output in the GUI
	private String date;
	private List<String> names;
	private List<String> wages;
	
	
	public main(){
		date="";
		names = new ArrayList<String>();
		wages = new ArrayList<String>();
	}

	
	public void initialize(){
		ParseFile fil = new ParseFile();
		List<Employee> employees = fil.parseOpenCVS();
		List<Workday> wdays = new ArrayList<Workday>();
		for (Employee emp: employees){
			names.add(emp.getName());
			wdays = emp.getWorkdays();
			
			Monthly_wage mwage = new Monthly_wage();
			String totwage = mwage.CalculateWage(wdays);
			wages.add(totwage);
			//System.out.println(totwage);
			
		}
		//store date 
		String[] temp = wdays.get(0).getDate().split("\\.");
		date = temp[1]+"/"+temp[2];

	}
	
	public String getDate(){
		return date;
	}
	public List<String> getNames(){
		return names;
	}
	public List<String> getWages(){
		return wages;
	}

}
