package me.werewolf2.roles;

import me.werewolf2.Main;
import me.werewolf2.Player;

public class ApprenticeSeer extends Role {
	int pick = 0;

	public ApprenticeSeer() {
		super(allRoles.APPRENTICE_SEER);
	}

	public void doNightAbility(Player p) {
		
		//Nothing here
		
	}

	public void runNight(Player p) {
		
		if(pick != 0) {
			Role r = Main.midRoles.get(pick - 1);
			p.sendMessage("Middle role " + pick + " is " + r.getRoleName() + ".");
		}else{
			p.sendMessage("You didn't take your turn!");
		}
		
	}

	public void nightListen(String msg, Player p) {
		
		try {
			Integer number = Integer.parseInt(msg);
			if(number >= 1 && number <= 3) {
				pick = number;
				p.sendMessage("You decided to look at middle role " + number + ".");
			}else{
				p.sendMessage("Please choose a number between one and three.");
			}
		}catch(Exception e) {
			p.sendMessage("Please send a number.");
		}
		
	}

	public void doSpecialAbility(Player p) {
		
		//Nothing here
		
	}

	public void doVotingAbility(Player p, Player r, boolean lostVote) {
		
		//Nothing here
		
	}

}
