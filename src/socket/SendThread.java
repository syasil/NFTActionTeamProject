package Socket;


import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


public class SendThread extends Thread{
	
	private Socket socket;

	public void run(String data) {
		super.run();
		
		try {
			PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
			
			
			
			
			/*BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
			bufferedWriter.write(data);
			
				
			bufferedWriter.flush();
			
			bufferedWriter.close();
				*/
		} catch (Exception e) {
			
		}
		
	}
	
	
	public void setSocket(Socket _socket) {
		
		socket= _socket;
		
	}
}
