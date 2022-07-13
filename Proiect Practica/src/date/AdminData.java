package date;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class AdminData 
{
	static ArrayList<BasicDataAdmin> Admin;
	public AdminData()
	{
		try{
			Admin = new ArrayList<BasicDataAdmin>();

			BufferedReader in_Admin = new BufferedReader (new FileReader("Files/admin.txt"));
		
			String s;
			String id;
			String name;
			String password;
		
			while((s = in_Admin.readLine()) != null)
			{  
	           		id = s.substring(3,s.indexOf("Name") - 2);
				name = s.substring(s.indexOf("Name") + 5, s.indexOf("Password") - 2);
				password = s.substring(s.indexOf("Password") + 9, s.length());

				BasicDataAdmin obj = new BasicDataAdmin(Integer.parseInt(id), name, password);
				Admin.add(obj);
			}
			
			in_Admin.close();
			
		} catch(Exception e)
	    {
			JOptionPane.showMessageDialog(null, e+"Acest admin nu este inregistrat!");	
	    }
	}
	public int size() {
		return Admin.size();
	}
	public BasicDataAdmin get(int i) {
		return Admin.get(i);
	}
}
