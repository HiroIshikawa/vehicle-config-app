package server;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Properties;


public class 
DefaultSocketServer
extends Thread 
implements SocketClientInterface,
SocketClientConstants {

	protected BufferedReader reader;
	protected BufferedWriter writer;
	protected ServerSocket sSock;
	protected Socket sock;
	protected String strHost;
	protected int iPort;
	protected ObjectOutputStream out = null;
	protected ObjectInputStream in = null;

	AutoServer autoServer = new BuildCarModelOptions();

	public DefaultSocketServer() {
		// TODO Auto-generated constructor stub
	}

	public DefaultSocketServer(Socket soc) {
		// TODO Auto-generated constructor stub
	}

	public DefaultSocketServer(String strHost, int iPort) {       
		setPort (iPort);
		setHost (strHost);
	}//constructor

	public DefaultSocketServer(ServerSocket serverSocket, Socket insock) {
		if (DEBUG) System.out.println("accepting process");
		this.sSock = serverSocket;
		this.sock = insock;
	}//constructor

	public void run(){
		if (openConnection()){
			try {
				if (DEBUG) System.out.println("pass the open connection");
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
			;
		}
		catch (Exception e){
			if (DEBUG) System.err.println
			("Unable to obtain stream to/from " + strHost);
			return false;
		}
		if (DEBUG) System.out.println("Opened Connection on Server");
		return true;
	}

	public void handleSession() throws IOException, ClassNotFoundException{
		while(true){
			in = new ObjectInputStream(sock.getInputStream());
			Properties fromClient;
			if (DEBUG) System.out.println("Starting handliong the sesiosn in server");
			if (DEBUG) System.out.println("waiting...");

			String clientChoice = (String) in.readObject();

			if (clientChoice.equals("upload")) {
				try {
					while(true){
						// System.out.println("Serverside");
						if ((fromClient = (Properties) in.readObject())!=null){
							if (DEBUG) System.out.println(fromClient);				
							autoServer.buildWithProp(fromClient);
							break;
						}
						// System.out.println("addition completed");
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e){}

				out = new ObjectOutputStream(sock.getOutputStream());
				out.flush();
				out.writeObject("Completed");
				in = null;
				out = null;
			} else if (clientChoice.equals("config"))
			{
				ObjectOutputStream out = new ObjectOutputStream(
						sock.getOutputStream());
				out.flush();
				ArrayList<String> models = autoServer.getModels();
				System.out.println(models.toString());
				out.writeObject(models);
			
				String theModel ="";

				while(true){
					if ((theModel = (String) in.readObject())!=null){
						System.out.println("Client want to config: " + theModel);
						if(autoServer.sendChoosenModel(out, theModel))
							break;
					}
				}
				
				in = null;
				out = null;
			} else {
				System.err.println("Please do again");
			}
			
			System.out.println("end of server process");
			in = null;
			out = null;
		}
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


