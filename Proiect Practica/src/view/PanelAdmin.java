package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import date.EventData;
import date.AdminData;


public class PanelAdmin  extends JFrame implements ActionListener  
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton b1;  
    JPanel newPanel;  
    JPanel content;
    GridBagConstraints c;
    JLabel userLabel, passLabel;  
    final JTextField  textField1;
    final JPasswordField textField2;
    
    JButton selectEvents;
	JButton selectRequests;
	
	JButton programeazaEveniment;
	JButton iesire;
	
    AdminData admin;
    EventData even;
    
    PanelAdmin()
    {
    	setSize(300,300);
    	setResizable(false);
    	userLabel = new JLabel();  
        userLabel.setText("Username"); 
		this.textField1 = new JTextField(20);
		passLabel = new JLabel();  
        passLabel.setText("Password");  
		this.textField2 = new JPasswordField(20);
		b1 = new JButton("SUBMIT");
		newPanel = new JPanel(new GridLayout(3, 1));   
		newPanel.add(userLabel);
		newPanel.add(textField1);
		newPanel.add(passLabel); 
		newPanel.add(textField2);
		newPanel.add(b1);
		add(newPanel, BorderLayout.CENTER);  
		b1.addActionListener(this);  
		setTitle("LOGIN FORM");  
		setVisible(true);
    }
    
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		 String userValue = textField1.getText();   
		 @SuppressWarnings("deprecation")
		 String passValue = textField2.getText(); 
		 admin = new AdminData();
		 for(int i = 0; i<admin.size();i++)
			{
				if(admin.get(i).getName().equals(userValue) && admin.get(i).getPassword().equals(passValue))
				{
					 setVisible(false);
					 FereastraNoua page = new FereastraNoua();  
					 page.setVisible(true); 
					 JLabel wel_label = new JLabel("Welcome: "+userValue);  
					 
			         content = new JPanel(new GridBagLayout());
			         c = new GridBagConstraints();
			         content.setBackground(Color.PINK);
			         selectEvents = new JButton ("Evenimente programate");
   			 		 selectEvents.setBounds(50,100,95,30); 
			 		 selectEvents.setVisible(true);
			 		 
			 		 
					 selectEvents.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
						      even = new EventData();
							  even.showEvents();	
							}							
						});
					 
			 		 selectRequests = new JButton ("Cereri clienti");
			 		 selectRequests.setBounds(50,100,95,30);
			 		 selectRequests.setVisible(true);
			 		 
			 		 selectRequests.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
						      even = new EventData();
							  even.showRequestEvents();	
							  
							  c.gridx = 0;
						 	  c.gridy = 1;
						 		 
							  programeazaEveniment = new JButton ("Programeaza");
							  programeazaEveniment.setBounds(50,100,95,30);
							  programeazaEveniment.setVisible(true);
							  content.add(programeazaEveniment,c);
							  
							  c.insets = new Insets(10,10,10,10);
							  c.gridx = 0;
						 	  c.gridy = 2;
						 	  
							  iesire = new JButton ("Iesire");
							  iesire.setBounds(50,120,95,30);
							  iesire.setVisible(true);
							  content.add(iesire,c);
							  
							  selectRequests.setVisible(false);
							  selectEvents.setVisible(false);
							  
							  programeazaEveniment.addActionListener(new ActionListener() 
							  {
								  public void actionPerformed(ActionEvent ae)
								  {
									  dispose();
									  NotificareProgramare not = new NotificareProgramare();
									  @SuppressWarnings("unused")
									PanelProgramareEveniment fereastra = new PanelProgramareEveniment(not.returnOptiune());
									  page.setVisible(false);
								  }
							  });
							  
							  iesire.addActionListener(new ActionListener() 
							  {
								  public void actionPerformed(ActionEvent ae)
								  {
									  page.setVisible(false);
								  }
								  
							  });
							  
							}							
						});
			 		 
			 		 c.insets = new Insets(10,10,10,10);
			         content.add(wel_label);
			         
			         c.gridx = 0;
			 		 c.gridy = 1;
			 		 content.add(selectEvents,c);
			 		 
			 		 c.gridx = 0;
			 		 c.gridy = 3;
			 		 content.add(selectRequests,c);
			 		 
			 		 page.add(content,BorderLayout.CENTER);
				}
			}
	}

}

