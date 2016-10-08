package me.werewolf2.roles;

import me.werewolf2.Main;
import me.werewolf2.Player;

public class Robber extends Role {
	int pick = 0;

	public Robber() {
		super(allRoles.ROBBER);
	}

	public void doNightAbility(Player p) {
		
		//Nothing here
		
	}

	public void runNight(Player p) {
		
		if(pick != 0) {
			Player r = Main.players.get(pick - 1);
			Role pRole = p.getRole();
			Role rRole = r.getRole();
			p.setRole(rRole);
			r.setRole(pRole);
			p.sendMessage("Your new role is " + rRole.getRoleName());
		}else{
			p.sendMessage("You forgot to do your role!");
		}
		
	}

	public void nightListen(String msg, Player p) {
		
		try {
			Integer number = Integer.parseInt(msg);
			if(number >= 1 && number <= Main.playerCount) {
				Player r = Main.players.get(number - 1);
				p.sendMessage("You are going to rob " + r.getName() + " tonight.");
				pick = number;
			}else{
				p.sendMessage("That is not a valid player number.");
			}
		}catch(Exception e) {
			p.sendMessage("Please enter a valid number.");
		}
		
	}

	public void doSpecialAbility(Player p) {
		
		//Nothing here.
		
	}

	public void doVotingAbility(Player p, Player r, boolean lostVote) {
		
		//Nothing here.
		
	}

}
