package me.werewolf2.roles;

import me.werewolf2.Player;

public class Hunter extends Role {

	public Hunter() {
		super(allRoles.HUNTER);
	}

	public void doNightAbility(Player p) {
		
		//Nothing here
		
	}

	public void runNight(Player p) {
		
		//Nothing here
		
	}

	public void nightListen(String msg, Player p) {
		
		p.sendMessage("You don't have a night ability!");
		
	}

	public void doSpecialAbility(Player p) {
		
		//Nothing here
		
	}

	public void doVotingAbility(Player p, Player r, boolean lostVote) {
		
		if(lostVote) {
			for(int i = 0; i < p.getVotes() + 2; i++) {
				r.addVote();
			}
			
			p.sendMessage("You were voted out. Luckily, you were the hunter, so " + r.getName() + " was voted out instead.");
		}
		
	}

}
