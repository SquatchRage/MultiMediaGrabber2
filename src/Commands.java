import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Commands {
	
	String message;
	Talker talk;
	
	public Commands(String message, Talker talk){
		this.message = message;
		this.talk = talk;
		commands();
	}
	
	public void commands(){
		
		if(message.startsWith("Kill Program")){
			System.exit(1);

		}
		
		else if(message.startsWith("Show Message")){
			//System.out.println("COMMANDS :"+message);
			SwingUtilities.invokeLater(new Runnable()
					{ @Override
				public void run(){
						
						JOptionPane.showMessageDialog(null, "Good job keep going!");

					}
				}
					
			);
		}
		
		else if(message.startsWith("Get Files")){
			
			new Thread(new Runnable()
			{
				 public void run()
				 {
						try {
							new Search(talk);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					

				 }
		}).start();


		}
		
	}

}
