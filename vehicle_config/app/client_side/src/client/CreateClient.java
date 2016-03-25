package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import model.Automobile;

public class CreateClient extends DefaultSocketClient{

	Socket socket = null;
	ObjectOutputStream out = null;
	ObjectInputStream in = null;

	public CreateClient() {};
	public CreateClient(String strHost, int iPort){
		super(strHost,iPort);
	}

	public boolean openConnection() {
		try {
			if (DEBUG) System.out.println("making socket");
			socket = new Socket(strHost, iPort);
			if (DEBUG) System.out.println("socket made");
		}
		catch(IOException socketError){
			if (DEBUG) System.err.println
			("Unable to connect to " + strHost);
			return false;
		}
		return true;
	}

	public void handleSession() throws IOException, ClassNotFoundException{
		while(true){
			if (DEBUG) System.out.println("starting clinet process");

			Scanner scanner = new Scanner(System.in);
			System.out.println("The Car Configuration Tool");
			System.out.println("Please enter 'upload' or 'config': ");

			String userChoice = scanner.nextLine();
			// out.flush();
			if (userChoice.equals("upload")) {
				out = new ObjectOutputStream(socket.getOutputStream());
				out.writeObject("upload");
				if (DEBUG) System.out.println("inside upload proces");

				out.flush();
				
				System.out.println("Please enter the file name to upload: ");
				String fileName = scanner.nextLine();

				CarModelOptionsIO myobj = new CarModelOptionsIO();
				Properties prop = myobj.readData(fileName);
				out.writeObject(prop);

				if (DEBUG) System.out.println("After out prop");
				in = new ObjectInputStream(socket.getInputStream());
				//in = new ObjectInputStream(socket.getInputStream());

				while(true){	
					String fromServer;
					if ((fromServer = (String) in.readObject())!=null){
						System.out.println(fromServer);
						out.flush();
						break;
					}
				}
				if (DEBUG) System.out.println("After in read");

				out = null;
				in = null;

			} else if (userChoice.equals("config")) {
				
				SelectCarOption selections = new SelectCarOption();
				// sending the config string
				out = new ObjectOutputStream(socket.getOutputStream());

				out.writeObject("config");
				if (DEBUG) System.out.println("inside config proces");

				ArrayList<String> obj = null;

				out.flush();
				in = new ObjectInputStream(socket.getInputStream());
				while(true){				
					if ((obj = (ArrayList<String>) in.readObject()) != null){
						ArrayList<String> models = obj;
						selections.showModels(models);
						break;
					}
				}

				Automobile theAuto = null;
				while(true){
					String theModel = selections.selectModel();
					out.writeObject(theModel);
					out.flush();
					if ((theAuto = (Automobile) in.readObject())!=null){
						if (theAuto != null) {
							//System.out.println("The model from server:");
							//theAuto.print();
							selections.showOptions(theAuto);
						}
						break;
					}
					in = null;
				}

				out = null;
				in = null;
			}

		}

	}

	public void closeSession(){
		try {
			writer = null;
			reader = null;
			socket.close();
		}
		catch (IOException e){
			if (DEBUG) System.err.println
			("Error closing socket to " + strHost);
		}       
	}

	public static void main (String arg[]) {
		String strLocalHost = "";
		try{
			strLocalHost = 
					InetAddress.getLocalHost().getHostAddress();
		}
		catch (UnknownHostException e){
			System.err.println ("Unable to find local host");
		}
		CreateClient c = new CreateClient
				(strLocalHost, 7895);
		c.start();
	}
}
