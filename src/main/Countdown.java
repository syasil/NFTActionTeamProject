/*package main;

import javax.swing.JLabel;

public class Countdown extends Thread {
	private boolean bStop;
	
	JLabel lblCountdown;
	int second;


	public Countdown(JLabel lbl, int second) {
		bStop = false;
		this.lblCountdown = lbl;
		this.second = second;
	}

	public void run() {
		int hh;
		int mm;
		int ss;

		while (!bStop) {
			// "Auction end in : 5h 10m 5s"

			mm = second / 60; // 입력받은 sec를 60으로 나누면 분(min)
			hh = mm / 60; // min의 값을 60으로 나누면 시(hour)
			ss = second % 60; // 시분초로 바꿔주는 것이므로, sec를 60으로 나눠 그 나머지가 남은 초
			mm = mm % 60; // min을 60으로 나눠 그 나머지가 남은 분
			
			lblCountdown.setText(hh + "h " + mm + "m " + ss + "s");
			second--;

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (second < 0) {
				break;
			}
		}
	}
	
	public void stopCountdown() {
		bStop = true;
	}
}*/