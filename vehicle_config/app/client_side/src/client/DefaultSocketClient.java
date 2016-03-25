package client;

import java.net.Socket;
import java.io.*;

public class 
DefaultSocketClient 
extends Thread 
implements SocketClientInterface,
SocketClientConstants {

	protected BufferedReader reader;
	protected BufferedWriter writer;
	protected Socket sock;
	protected String strHost;
	protected int iPort;

	public DefaultSocketClient() {
		// TODO Auto-generated constructor stub
	}

	public DefaultSocketClient(Socket soc) {
		// TODO Auto-generated constructor stub
	}

	public DefaultSocketClient(String strHost, int iPort) {       
		setPort (iPort);
		setHost (strHost);
	}//constructor

	public void run(){
		if (openConnection()){
			try {
				//System.out.println("Starting sessiono in client");
				handleSession();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			closeSession();
		}
	}//run
	public boolean openConnection(){

		try {
			sock = new Socket(strHost, iPort);                    
		}
		catch(IOException socketError){
			if (DEBUG) System.err.println
			("Unable to connect to " + strHost);
			return false;
		}

		/*
		 * you dont need this for using with the server
		 */
		try {
			reader = new BufferedReader
					(new InputStreamReader(sock.getInputStream()));
			writer = new BufferedWriter
					(new OutputStreamWriter (sock.getOutputStream()));
		}
		catch (Exception e){
			if (DEBUG) System.err.println
			("Unable to obtain stream to/from " + strHost);
			return false;
		}
		return true;
	}

	public void handleSession() throws IOException, ClassNotFoundException{
		String strInput = "";
		if (DEBUG) System.out.println ("Handling session with "
				+ strHost + ":" + iPort);
		try {
			while ( (strInput = reader.readLine()) != null)
				handleInput (strInput);
		}
		catch (IOException e){
			if (DEBUG) System.out.println ("Handling session with "
					+ strHost + ":" + iPort);
		}
	}       

	public void sendOutput(String strOutput){
		try {
			writer.write(strOutput, 0, strOutput.length());
		}
		catch (IOException e){
			if (DEBUG) System.out.println 
			("Error writing to " + strHost);
		}
	}

	public void handleInput(String strInput){
		System.out.println(strInput);
	}       

	public void closeSession(){
		try {
			writer = null;
			reader = null;
			sock.close();
		}
		catch (IOException e){
			if (DEBUG) System.err.println
			("Error closing socket to " + strHost);
		}       
	}

	public void setHost(String strHost){
		this.strHost = strHost;
	}

	public void setPort(int iPort){
		this.iPort = iPort;
	}
	/*
    public static void main (String arg[]){
    	   debug main; does daytime on local host
    	    String strLocalHost = "";
    	  try{
    	      strLocalHost = 
    	    		  InetAddress.getLocalHost().getHostAddress();
    	  }
    	 catch (UnknownHostException e){
    	      System.err.println ("Unable to find local host");
    	 }
    	  DefaultSocketClient d = new DefaultSocketClient
    	     (strLocalHost, 55555);
    	  d.start();
    }
	 */
} // class DefaultSocketClient


