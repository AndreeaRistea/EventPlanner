package date;

import java.util.*;
import java.io.*;

public class BasicDataAdmin
{
	int id;
	String nume;
	String parola;

	BasicDataAdmin(int i, String n, String p)
	{
		id = i;
		nume = n;
		parola = p;
	}
	
	public int getID()
	{
		return id;
	}
	
	public String getName()
	{
		return nume;
	}
	
	public String getPassword()
	{
		return parola;
	}
	
	public void setID(int ID)
	{
		id = ID;
	}
	
	public void setName(String Name)
	{
		nume = Name;
	}
	
	public void setPassword(String Password)
	{
		parola = Password;
	}
	
	public void print()
	{
		System.out.println("\nID: " + id );
		System.out.println("Nume: " + nume );
		System.out.println("Parola: " + parola );	
	}
}	
