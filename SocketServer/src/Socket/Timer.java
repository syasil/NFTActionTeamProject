package Socket;

public class Timer extends Thread implements Runnable{
	
	private int second;
	
	private static Timer singleton = null;
	
	public static Timer getInstance(int second) {
		
		if(singleton == null) {
			singleton = new Timer(second);
		}
		
		return singleton;
	}
	
	private Timer(int second) {
		
		this.second = second;
		
	
	}

	@Override
	public void run() {
		
		
		while(true) {
			try {
				
				Thread.sleep(1000);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			if(second > 0) {
				
				second--;
				
			}
			else{
				
				break;
				
			}
			
		}
		
	}
	public int getTime() {
		return second;
	}

}
