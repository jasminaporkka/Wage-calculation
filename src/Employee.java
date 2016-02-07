import java.util.*;

public class Employee {
	
	//class for employees, their name, id and a list of their workdays
	private String ename;
	private int eid;
	private List<Workday> workdays;
	
	public Employee(String name, int id){
		ename = name;
		eid = id;
		workdays = new ArrayList<Workday>();
		
	}
	
	public void setName(String name){
		ename = name;
		
	}
	public void setId(int id){
		eid = id;
		
	}
	public int getId(){
		return eid;
	}
	public String getName(){
		return ename;
		
	}
	public List<Workday> getWorkdays(){
		return workdays;
		
	}
	public void addWorkday(Workday wday){
		workdays.add(wday);
	}

}
