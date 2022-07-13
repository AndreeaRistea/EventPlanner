package date;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EventData extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane jScrollPane;
    private JTextArea jTextArea ;
    private static final String FILE_PATH="Files/event.txt";
    
    private static final String FILE_PATH2 = "Files/cereri.txt";
    private JScrollPane jScrollPane2;
    private JTextArea jTextArea2 ;
    
	 public void showEvents() {

	        try {
	            jTextArea = new JTextArea(30, 60);

	            jTextArea.read(new BufferedReader(new FileReader(FILE_PATH)), null);

	        } catch (Exception e){

	            e.printStackTrace();
	        }

	        jScrollPane = new JScrollPane(this.jTextArea);
	        this.add(this.jScrollPane);
	        this.setVisible(true);
	        this.setSize(600, 200);
	    }
	 
	 public void showRequestEvents()
	 {
		 try {
	            jTextArea2 = new JTextArea(30, 60);

	            jTextArea2.read(new BufferedReader(new FileReader(FILE_PATH2)), null);

	        } catch (Exception e){

	            e.printStackTrace();
	        }

	        jScrollPane2 = new JScrollPane(this.jTextArea2);
	        this.add(this.jScrollPane2);
	        this.setVisible(true);
	        this.setSize(600, 200);
	 }
	 
	 public void plansEvent()
	 {
		 File file = new File("Files/cereri.txt");
		 File dest = new File("Files/event.txt");
		 try {
			FileInputStream inputStream = new FileInputStream(file);
			try (Scanner sc = new Scanner(inputStream)) {
				StringBuffer buffer = new StringBuffer();
				while(sc.hasNext()) {
				     buffer.append(" "+sc.nextLine());
				  }
				try {
					new FileWriter(file, false).close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					try (FileWriter writer = new FileWriter(dest.getAbsoluteFile(),true)) {
						writer.write(buffer.toString());
						writer.write("\n");
						writer.flush();
						
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}

