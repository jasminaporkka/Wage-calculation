import java.util.*;
import java.awt.BorderLayout;
import javax.swing.*;

//class for the GUI, run this file to execute the wage calculations and present them in GUI

public class Wage_GUI extends JFrame {
	
	
	private String date ="";
	private List<String> names;
	private List<String> wages;

	
	public Wage_GUI(){
		initUI();
	}
	//initialize the GUI
	private void initUI() {
		
		//do wage calculations and create employee and wage lists
		main init = new main();
		init.initialize();
		date=init.getDate();
		names = init.getNames();
		wages=init.getWages();
		
		//create components, add them to panel and add panel to UI
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JLabel jlbTitle = new JLabel("Monthly wages "+ date +":");
		JTextArea textarea = new JTextArea(50, 50);
		textarea.setEditable(false);
		//create clist of employees and their wages to the text area
		for (int n=1; n<=names.size(); n++){
			textarea.append(n+", "+ names.get(n-1) +", $"+ wages.get(n-1)+"\n");

		}
		panel.add(jlbTitle, BorderLayout.NORTH);
		panel.add(textarea, BorderLayout.CENTER);
		add(panel);
		pack();
		this.setSize(500, 500);
	
	}
	
	public static void main(String[] args) {
		
		Wage_GUI gui = new Wage_GUI();
		gui.setVisible(true);

	}
	

}
