package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CreateServer extends DefaultSocketServer{
	private ServerSocket serverSocket = null;

	public CreateServer() {
		try {
			int socketNum = 7895;
			serverSocket = new ServerSocket(socketNum);
			if (DEBUG) System.out.println("Listening on port: "+ socketNum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void runServer() {
		DefaultSocketServer defaultClientSocket = null;
		System.out.println("defaultClientSocket nulled...");
		try {
			while(true) {
				if (DEBUG) System.out.println("Socket accepting...");
				Socket socket = serverSocket.accept();
				if (DEBUG) System.out.println("Socket accepted...");
				defaultClientSocket = new DefaultSocketServer(serverSocket, socket);
				if (DEBUG) System.out.println("Server starting...");
				defaultClientSocket.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		CreateServer server = new CreateServer();
		server.runServer();
	}
}