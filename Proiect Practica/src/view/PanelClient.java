package view;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class PanelClient 
{
	JFrame frame = new JFrame();
	static boolean tip;
	JButton dateClient;
	JButton dateEven;
	JButton programeaza;
	
	PanelEventAdd event;
	
	public PanelClient (boolean tip) 
	{
		initialize(tip);
	}
	private void initialize(boolean tip) 
	{
		if (!tip)
		{
			frame.setSize(800, 1000);
			frame.setBounds(20, 0, 800, 1000);

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JPanel panel = new JPanel();
			panel.setBackground(Color.PINK);
			panel.setSize(800, 1000);
			panel.setLayout(null);
			
			JLabel adauga = new JLabel("Noi iti programam evenimentul in functie de dorintele tale!");
			adauga.setFont(new Font("Elephant", Font.BOLD, 20));
			adauga.setBounds(95, 11, 800, 37);
			panel.add(adauga);
			
			programeaza = new JButton ("Programeaza evenimentul");
			programeaza.setBounds(400, 650, 250, 50);
			programeaza.setVisible(true);
			panel.add(programeaza);
			
			JLabel titlu = new JLabel("Introdu datele tale!");
			titlu.setFont(new Font("Arial", Font.BOLD, 18));
			titlu.setBounds(70, 100, 236, 37);
			panel.add(titlu); 
		
			event = new PanelEventAdd();
			event.setBounds(10, 150, 700, 800);
			panel.add(event);
			programeaza.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					try {
						event.saveEventData();
						JOptionPane.showMessageDialog(null, "Date adaugate cu succes!");
						frame.setVisible(false);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1+"");
					}
				}
			});
			
			frame.add(panel);
			frame.setVisible(true);
		}
		else
		{
			frame.setVisible(false);
		}
	}
}
