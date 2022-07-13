package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Notificare 
{
	JFrame frame = new JFrame();
	int optiune;
	public Notificare()
	{
		Object[] options = {"Da", "Nu"};
		this.optiune = JOptionPane.showOptionDialog(frame,
				"Doriti sa va programati un eveniment?",
				null, JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				options,
				options[1]);
		frame.dispose();
	}
	boolean returnOptiune()
	{
		if(this.optiune == 0)
		{
			return false;
		}
		return true;
	}
}

