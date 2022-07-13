package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import javax.swing.border.EtchedBorder;

public class MeniuPrincipal extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8432910580461218075L;
	@SuppressWarnings("unused")
	private BufferedImage poza;
	@SuppressWarnings("unused")
	private BufferedImage brown;
	private JPanel contentPane;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try 
				{
					MeniuPrincipal frame = new MeniuPrincipal();
					frame.setVisible(true);					
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MeniuPrincipal() throws IOException//constructor 
	{
		setResizable(false);
		try {
			poza = ImageIO.read(new File("Imag/plan1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			brown = ImageIO.read(new File("Imag/brown.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1000, 921);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		
		JComboBox tipUtilizator = new JComboBox();
		tipUtilizator.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Client"}));
		tipUtilizator.setBounds(300, 500, 147, 46);
		panel.add(tipUtilizator);
		
		JButton run = new JButton("");
		run.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tipUtilizator.getSelectedItem()=="Admin")
				{
					dispose();
					PanelAdmin admin = new PanelAdmin();
					admin.newPanel.setVisible(true);
				}
				else
					if(tipUtilizator.getSelectedItem()=="Client")
					{
						dispose();
						Notificare not = new Notificare();
						//not.frame.setVisible(true);
						PanelClient fereastra = new PanelClient(not.returnOptiune());
						//fereastra.frame.setVisible(true);
					}
			}
		});
		run.setIcon(new ImageIcon("Imag/run.png"));
		run.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		run.setFocusPainted(false);
		run.setContentAreaFilled(false);
		run.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		run.setBounds(450, 500, 102, 46);
		panel.add(run);
		
		JButton adaugaAnunt = new JButton("");
		adaugaAnunt.setBorder(null);
		adaugaAnunt.setFocusPainted(false);
		adaugaAnunt.setContentAreaFilled(false);
		adaugaAnunt.setIcon(new ImageIcon("Icons/button.png"));
		adaugaAnunt.setBounds(777, 207, 174, 53);
		
		panel.add(adaugaAnunt);
		
		adaugaAnunt.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		
		JLabel agentie = new JLabel("PLAN YOUR EVENT");
		agentie.setForeground(Color.BLACK);
		agentie.setFont(new Font("Elephant", Font.BOLD, 35));
		agentie.setBounds(300, 90, 887, 122);
		panel.add(agentie);
		JLabel background = new JLabel(new ImageIcon("Imag/plan1.png"));
		background.setSize(1000, 890);
		panel.add(background);
		panel.setBounds(0, 0, 1000, 890);
		contentPane.add(panel);
		panel.setLayout(null);
	}
}