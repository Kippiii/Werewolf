package me.werewolf2.roles;

import me.werewolf2.Main;
import me.werewolf2.Player;

public class Witch extends Role {
	int pick = 0, pick2 = 0;

	public Witch() {
		super(allRoles.WITCH);
	}

	public void doNightAbility(Player p) {
		
		//Nothing here
		
	}

	public void runNight(Player p) {
		
		if(pick != 0 && pick2 != 0) {
			Player r = Main.players.get(pick2 - 1);
			Role rRole = r.getRole();
			Role midRole = Main.midRoles.get(pick - 1);
			r.setRole(midRole);
			Main.midRoles.set(pick - 1, rRole);
			p.sendMessage(r.getName() + " is now a " + midRole.getRoleName() + ".");
		}
		
	}

	public void nightListen(String msg, Player p) {
		
		try {
			Integer number = Integer.parseInt(msg);
			if(pick != 0) {
				if(pick2 != 0) {
					p.sendMessage("You already picked!");
				}else{
					if(number >= 1 && number <= Main.playerCount) {
						pick2 = number;
						p.sendMessage("You are now making " + Main.players.get(number - 1).getName() + " a " + Main.midRoles.get(pick - 1).getRoleName() + ".");
					}else{
						p.sendMessage("That is not a valid number.");
					}
				}
			}else{
				if(number >= 1 && number <= 3) {
					pick = number;
					p.sendMessage("The role that you found was " + Main.midRoles.get(number - 1) + ".");
				}else{
					p.sendMessage("Please pick a number between one and three.");
				}
			}
		}catch(Exception e) {
			p.sendMessage("Please send a number!");
		}
		
	}

	public void doSpecialAbility(Player p) {
		
		//Nothing here.
		
	}

	public void doVotingAbility(Player p, Player r, boolean lostVote) {
		
		//Nothing here.
		
	}

}
