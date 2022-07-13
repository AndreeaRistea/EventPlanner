package view;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import enums.LocatieEveniment;
import enums.TipEveniment;

public class PanelEventAdd extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JTextField numarInvitati;
	@SuppressWarnings("rawtypes")
	JComboBox tipEvenimentBox;
	@SuppressWarnings("rawtypes")
	JComboBox locatieBox;
	JDateChooser dataChooser;
	
	JLabel tipEveniment;
	JLabel dataEveniment;
	JLabel locatieEveniment;
	JLabel invitati;
	
	private JTextField numePersoanaField;
	private JTextField prenumePersoanaField;
	private JTextField telefon;
	private JTextField mail;
	
	JLabel prenumePersoana;
	JLabel numePersoana;
	JLabel numarTelefonPersoana;
	JLabel adresaEmailPersoana;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PanelEventAdd() 
	{
		this.setBackground(Color.PINK);
		this.setBounds(30, 425, 400, 600);
		setLayout(null);
		
		tipEveniment = new JLabel("Tipul evenimentului");
		tipEveniment.setBounds(0, 0, 132, 17);
		tipEveniment.setFont(new Font("Serif", Font.BOLD, 14));
		this.add(tipEveniment);

		dataEveniment  = new JLabel("Data evenimentului");
		dataEveniment.setBounds(0, 66, 150, 14);
		dataEveniment.setFont(new Font("Serif", Font.BOLD, 14));
		this.add(dataEveniment);
		
		locatieEveniment  = new JLabel("Locatia evenimentului");
		locatieEveniment.setBounds(0, 123, 150, 14);
		locatieEveniment.setFont(new Font("Serif", Font.BOLD, 14));
		this.add(locatieEveniment);

		invitati  = new JLabel("Numarul maxim de invitati");
		invitati.setBounds(0, 183, 200, 17);
		invitati.setFont(new Font("Serif", Font.BOLD, 14));
		this.add(invitati);
		
		tipEvenimentBox = new JComboBox();
		tipEvenimentBox.setBounds(0, 28, 130, 30);
		tipEvenimentBox.setModel(new DefaultComboBoxModel(TipEveniment.values()));
		tipEvenimentBox.setFont(new Font("Serif", Font.PLAIN, 14));
		this.add(tipEvenimentBox);
		
		dataChooser = new JDateChooser();
		dataChooser.setFont(new Font("Serif", Font.PLAIN, 14));
		dataChooser.setBounds(0, 91, 130, 30);
		dataChooser.setDateFormatString("dd.MM.yyyy");
		this.add(dataChooser);
		
		locatieBox = new JComboBox();
		locatieBox.setBounds(0, 147, 150, 30);
		locatieBox.setModel(new DefaultComboBoxModel(LocatieEveniment.values()));
		locatieBox.setFont(new Font("Serif", Font.PLAIN, 14));
		this.add(locatieBox);
		
		numarInvitati = new JTextField();
		numarInvitati.setBounds(0, 206, 117, 30);
		this.add(numarInvitati);
		numarInvitati.setColumns(10);
		
		prenumePersoana = new JLabel("Prenume");
		prenumePersoana.setBounds(0, 237, 86, 22);
		this.add(prenumePersoana);
		prenumePersoanaField = new JTextField();
		prenumePersoanaField.setColumns(10);
		prenumePersoanaField.setBounds(0, 270, 117, 30);
		this.add(prenumePersoanaField);
		
		numePersoana = new JLabel("Nume");
		numePersoana.setBounds(0, 294, 110, 35);
		this.add(numePersoana);
		numePersoanaField = new JTextField();
		numePersoanaField.setColumns(10);
		numePersoanaField.setBounds(0, 330, 117, 30);
		this.add(numePersoanaField);
		
		numarTelefonPersoana = new JLabel("Numar telefon");
		numarTelefonPersoana.setBounds(0, 376, 117, 14);
		this.add(numarTelefonPersoana);
		
		telefon = new JTextField();
		telefon.setBounds(0, 400, 117, 30);
		this.add(telefon);
		telefon.setColumns(10);
		
		adresaEmailPersoana = new JLabel("Adresa email");
		adresaEmailPersoana.setBounds(0, 450, 79, 14);
		this.add(adresaEmailPersoana);
		
		mail = new JTextField();
		mail.setBounds(0, 477, 117, 30);
		this.add(mail);
		mail.setColumns(10);
	}
	
	public void saveEventData() throws IOException
	{
		File file = new File("Files/cereri.txt");
	    FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(),true);
		fileWriter.write(tipEveniment.getText() + ": " + tipEvenimentBox.getSelectedItem() + "\n");
		fileWriter.write(dataEveniment.getText() + ": " + dataChooser.getDate()+ "\n");
		fileWriter.write(locatieEveniment.getText() + ": " + locatieBox.getSelectedItem() + "\n");
		fileWriter.write(invitati.getText() + ": " + numarInvitati.getText() + "\n");
		fileWriter.write(numePersoana.getText() + ": " + numePersoanaField.getText() + "\n");
		fileWriter.write(prenumePersoana.getText() + ": " + prenumePersoanaField.getText() + "\n");
		fileWriter.write(numarTelefonPersoana.getText() + ": " + telefon.getText() + "\n");
		fileWriter.write(adresaEmailPersoana.getText() + ": " + mail.getText() + "\n\n");
		fileWriter.close();
	}
	
	public JTextField getNumarInvitati() {
		return numarInvitati;
	}

	public void setNumarInvitati(JTextField numarInvitati) {
		this.numarInvitati = numarInvitati;
	}
	@SuppressWarnings("rawtypes")
	public JComboBox getTipEvenimentBox() {
		return tipEvenimentBox;
	}
	@SuppressWarnings("rawtypes")
	public void setTipEvenimentBox(JComboBox tipEvenimentBox) {
		this.tipEvenimentBox = tipEvenimentBox;
	}
	@SuppressWarnings("rawtypes")
	public JComboBox getLocatieBox() {
		return locatieBox;
	}
	@SuppressWarnings("rawtypes")
	public void setLocatieBox(JComboBox locatieBox) {
		this.locatieBox = locatieBox;
	}

	public JDateChooser getDataChooser() {
		return dataChooser;
	}

	public void setDataChooser(JDateChooser dataChooser) {
		this.dataChooser = dataChooser;
	}
	public JTextField getNumePersoanaField() {
		return numePersoanaField;
	}

	public void setNumePersoanaField(JTextField numePersoanaField) {
		this.numePersoanaField = numePersoanaField;
	}

	public JTextField getPrenumePersoanaField() {
		return prenumePersoanaField;
	}

	public void setPrenumePersoanaField(JTextField prenumePersoanaField) {
		this.prenumePersoanaField = prenumePersoanaField;
	}

	public JTextField getTelefon() {
		return telefon;
	}

	public void setTelefon(JTextField telefon) {
		this.telefon = telefon;
	}

	public JTextField getMail() {
		return mail;
	}

	public void setMail(JTextField mail) {
		this.mail = mail;
	}

	public JLabel getPrenumePersoana() {
		return prenumePersoana;
	}

	public void setPrenumePersoana(JLabel prenumePersoana) {
		this.prenumePersoana = prenumePersoana;
	}

	public JLabel getNumePersoana() {
		return numePersoana;
	}

	public void setNumePersoana(JLabel numePersoana) {
		this.numePersoana = numePersoana;
	}

	public JLabel getNumarTelefonPersoana() {
		return numarTelefonPersoana;
	}

	public void setNumarTelefonPersoana(JLabel numarTelefonPersoana) {
		this.numarTelefonPersoana = numarTelefonPersoana;
	}

	public JLabel getAdresaEmailPersoana() {
		return adresaEmailPersoana;
	}

	public void setAdresaEmailPersoana(JLabel adresaEmailPersoana) {
		this.adresaEmailPersoana = adresaEmailPersoana;
	}
}
