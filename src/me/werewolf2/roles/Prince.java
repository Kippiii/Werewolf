package me.werewolf2.roles;

import me.werewolf2.Player;

public class Prince extends Role {

	public Prince() {
		super(allRoles.PRINCE);
	}

	public void doNightAbility(Player p) {
		
		//Nothing here
		
	}

	public void runNight(Player p) {
		
		//Nothing here
		
	}

	public void nightListen(String msg, Player p) {
		
		p.sendMessage("You do not have a night ability!");
		
	}

	public void doSpecialAbility(Player p) {
		
		//Nothing here
		
	}

	public void doVotingAbility(Player p, Player r, boolean lostVote) {
		
		if(lostVote) {
			p.setVotes(0);
		}
		
	}

}
