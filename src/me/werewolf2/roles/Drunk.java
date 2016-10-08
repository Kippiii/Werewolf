package me.werewolf2.roles;

import me.werewolf2.Main;
import me.werewolf2.Player;

public class Drunk extends Role {
	int pick = 0;

	public Drunk() {
		super(allRoles.DRUNK);
	}

	public void doNightAbility(Player p) {
		
		//Nothing here.
		
	}

	public void runNight(Player p) {
		
		if(pick != 0) {
			Role playerRole = p.getRole();
			Role midRole = Main.midRoles.get(pick - 1);
			
			p.setRole(midRole);
			Main.midRoles.set(pick - 1, playerRole);
		}
		
	}

	public void nightListen(String msg, Player p) {
		
		try {
			Integer number = Integer.parseInt(msg);
			if(number >= 1 && number <= 3) {
				pick = number;
				p.sendMessage("You picked to become middle role " + number + ".");
			}
		}catch(Exception e) {
			p.sendMessage("Please send a number between one and three.");
		}
		
	}

	public void doSpecialAbility(Player p) {
		
		//Nothing here.
		
	}

	public void doVotingAbility(Player p, Player r, boolean lostVote) {
		
		//Nothing here.
		
	}

}
