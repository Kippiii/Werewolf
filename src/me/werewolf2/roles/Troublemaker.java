package me.werewolf2.roles;

import me.werewolf2.Main;
import me.werewolf2.Player;

public class Troublemaker extends Role {
	int pick = 0, pick2 = 0;
	boolean doingPick2 = false;

	public Troublemaker() {
		super(allRoles.TROUBLEMAKER);
	}

	public void doNightAbility(Player p) {
		
		//Nothing here
		
	}

	public void runNight(Player p) {
		
		if(pick != 0 && pick2 != 0) {
			Player r1 = Main.players.get(pick - 1);
			Player r2 = Main.players.get(pick2 - 1);
			Role role1 = r1.getRole();
			Role role2 = r2.getRole();
			
			r1.setRole(role2);
			r2.setRole(role1);
			
			p.sendMessage(r1.getName() + "'s and " + r2.getName() + "'s roles have been switched.");
		}
		
	}

	public void nightListen(String msg, Player p) {
		
		try {
			Integer number = Integer.parseInt(msg);
			if(number >= 1 && number <= Main.playerCount) {
				if(doingPick2) {
					pick2 = number;
					p.sendMessage("Your second pick is " + Main.players.get(number - 1).getName() + ".");
					doingPick2 = false;
				}else{
					pick = number;
					p.sendMessage("Your first pick is " + Main.players.get(number - 1).getName() + ". Don't forget to make a second pick!");
					doingPick2 = true;
				}
			}else{
				p.sendMessage("That is not a valid number!");
			}
		}catch(Exception e) {
			p.sendMessage("Please send in a number!");
		}
		
	}

	public void doSpecialAbility(Player p) {
		
		//Nothing here.
		
	}

	public void doVotingAbility(Player p, Player r, boolean lostVote) {
		
		//Nothing here.
		
	}

}
