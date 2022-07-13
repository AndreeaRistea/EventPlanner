package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import date.EventData;

public class PanelProgramareEveniment
{
	static boolean tip;
	JFrame frame = new JFrame();
	JButton programeaza;
	GridBagConstraints c;
	JButton genereazaMail;
	JButton sent;
	
	JLabel mail;
	JLabel txt;
	JLabel txt2;
	EventData even;
	
	public PanelProgramareEveniment(boolean tip) 
	{
		initialize(tip);
	}
	
	private void initialize(boolean tip) 
	{
		if (!tip)
		{
			frame.setSize(500,500);
			frame.setBounds(20, 0, 400, 400);

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JPanel panel = new JPanel();
			panel.setBackground(Color.GRAY);
			panel.setSize(500, 500);
			panel.setLayout(null);
			
			programeaza = new JButton ("Programeaza evenimentul");
			programeaza.setBounds(50,100,200,30);
			programeaza.setVisible(true);
			
			c = new GridBagConstraints();
			c.gridx = 0;
	 		c.gridy = 1;
	 		panel.add(programeaza,c);
	 		
	 		programeaza.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					even = new EventData();
					even.plansEvent();
					programeaza.setVisible(false);
					genereazaMail = new JButton("Genereaza EMail");
					genereazaMail.setBounds(50,100,200,30);
					genereazaMail.setVisible(true);
					c.gridx = 0;
			 		c.gridy = 1;
			 		panel.add(genereazaMail,c);
			 		genereazaMail.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e) 
						{
							genereazaMail.setVisible(false);
							mail = new JLabel("Evenimentul dumneavoastra a fost programat cu succes!");
							mail.setBounds(50,100,500,30);
							mail.setFont(new Font("Serif", Font.BOLD, 14));
							
							txt = new JLabel (" Va multumim pentru ca ne-ati ales!");
							txt.setBounds(50,120,500,30);
							txt.setFont(new Font("Serif", Font.BOLD, 14));
							
							mail.setVisible(true);
							txt.setVisible(true);
							panel.add(mail);
							panel.add(txt);
							
							sent = new JButton("Trimite EMail");
							sent.setBounds(50,200,200,30);
							sent.setVisible(true);
							panel.add(sent);
							
							sent.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent e) 
								{
									try {
										JOptionPane.showMessageDialog(null, "Email-ul a fost trimis cu succes!");
										frame.setVisible(false);
									} catch (Exception e1) {
										JOptionPane.showMessageDialog(null, e1+"");
									}
								}
							});
							
						}
					});
				}
			});
	 		frame.add(panel);
			frame.setVisible(true);
		}
		else
		{
			frame.setSize(100,100);;
		    frame.setBounds(20, 0, 400, 400);
		    
		    JPanel panel = new JPanel();
			panel.setBackground(Color.PINK);
			panel.setSize(100, 100);
			panel.setLayout(null);
			
		    genereazaMail = new JButton("Genereaza EMail");
			genereazaMail.setBounds(50,100,200,30);
			genereazaMail.setVisible(true);
			
			c = new GridBagConstraints();
			c.gridx = 0;
	 		c.gridy = 1;
	 		
	 		File file = new File("Files/cereri.txt");
	 		try {
				new FileWriter(file, false).close();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
	 		
	 		panel.add(genereazaMail,c);
	 		genereazaMail.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					genereazaMail.setVisible(false);
					mail = new JLabel("Evenimentul dumneavoastra nu poate fi programat!");
					mail.setBounds(50,100,500,30);
					mail.setFont(new Font("Serif", Font.BOLD, 14));
					
					txt = new JLabel (" Va rugam alegeti o alta data sau locatie!");
					txt.setBounds(50,120,500,30);
					txt.setFont(new Font("Serif", Font.BOLD, 14));
					
					txt2 = new JLabel (" Va multumim pentru intelegere!");
					txt2.setBounds(50,140,500,30);
					txt2.setFont(new Font("Serif", Font.BOLD, 14));
					
					mail.setVisible(true);
					txt.setVisible(true);
					txt2.setVisible(true);
					
					panel.add(mail);
					panel.add(txt);
					panel.add(txt2);
					
					sent = new JButton("Trimite EMail");
					sent.setBounds(50,200,200,30);
					sent.setVisible(true);
					panel.add(sent);
					
					sent.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e) 
						{
							try {
								JOptionPane.showMessageDialog(null, "Email-ul a fost trimis cu succes!");
								frame.setVisible(false);
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(null, e1+"");
							}
						}
					});
					
				}
			});
	 		frame.add(panel);
			frame.setVisible(true);
		}
	}
}
