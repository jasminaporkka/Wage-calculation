import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import com.opencsv.*;

public class ParseFile {
	//Parses csv file and returns list of employees
	
	public List<Employee> parseOpenCVS(){
		//create placeholders for employees and their id's to only create each employee once
		List<Employee> emplist = new ArrayList<Employee>();
		List<Integer> idlist = new ArrayList<Integer>();
		 try {
	         
	         CSVReader reader = new CSVReader(new FileReader("HourList201403.csv"));
	
	         String [] nextLine;
	       //skip header row
	         reader.readNext(); 
	        
	         while ((nextLine = reader.readNext()) != null) {
	             //create workday from csv line 
	        	 int id = Integer.parseInt(nextLine[1]);
	        	 Workday wday = new Workday(id, nextLine[2], nextLine[3], nextLine[4]);
	        	 //if employee registered, add workday to their list
	        	 if (idlist.contains(id)){
	        		 for (Employee empl : emplist){
	        			 if (empl.getId()==id){
	        				 empl.addWorkday(wday);
	        			 }
	        		 }
	 	       //if employee is new, add to list and add corresponding workday to employee's workdaylist
	        	 }else{
	        		 Employee emp = new Employee(nextLine[0], id);
	        		 emp.addWorkday(wday);
	        		 emplist.add(emp);
	        		 idlist.add(id);
	        	 }
		        	   
	         }
	         reader.close();
	         
	     } catch (FileNotFoundException e) {
	         
	         e.printStackTrace();
	     }
	     catch (IOException e1) {
	         e1.printStackTrace();
	     }
		
		return emplist;
		 
	}


}
