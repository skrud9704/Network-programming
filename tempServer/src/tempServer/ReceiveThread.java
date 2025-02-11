package tempServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.google.gson.Gson;

public class ReceiveThread extends Thread {
	private Socket m_socket;
	private Gson gson = new Gson();
	
	@Override 
	public void run() {
		super.run();
		try {
			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(m_socket.getInputStream()));
			String receiveMessage;
			while(true) {
				receiveMessage = tmpbuf.readLine();
				String tmp = gson.toJson(receiveMessage, Message.class);
				if(receiveMessage == null) {
					break;
				}
				else {
					
				}
			}
			tmpbuf.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void setSocket(Socket _socket) {
		m_socket = _socket;
	}
}
