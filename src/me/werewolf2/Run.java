package me.werewolf2;

public class Run implements Runnable {
	public static int countdown = 0;
	
	public void run() {
		while(true) {
			
			if(Main.gs == GameState.NIGHTPHASE) {
				if(countdown>0) {
					if(countdown == 1) {
						Utilities.startDay();
					}else{
						countdown--;
					}
				}
			}else if(Main.gs == GameState.DAYPHASE) {
				if(countdown > 0) {
					if(countdown == 1) {
						Utilities.startVote();
					}else{
						countdown--;
					}
				}
			}else if(Main.gs == GameState.VOTING) {
				if(countdown > 0) {
					if(countdown == 1) {
						Utilities.endGame();
					}else{
						countdown--;
					}
				}
			}
			
			try {
			Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
