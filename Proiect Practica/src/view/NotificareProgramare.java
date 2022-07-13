package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class NotificareProgramare 
{
	JFrame frame = new JFrame();
	int optiune;
	public NotificareProgramare()
	{
		Object[] options = {"Da", "Nu"};
		this.optiune = JOptionPane.showOptionDialog(frame,
				"Se poate programa acest eveniment?",
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
