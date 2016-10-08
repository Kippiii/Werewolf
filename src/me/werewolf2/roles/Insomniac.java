package me.werewolf2.roles;

import me.werewolf2.Player;

public class Insomniac extends Role {

	public Insomniac() {
		super(allRoles.INSOMNIAC);
	}

	public void doNightAbility(Player p) {
		
		//Nothing here
		
	}

	public void runNight(Player p) {
		
		p.sendMessage("Your current role is " + p.getRole() + ".");
		
	}

	public void nightListen(String msg, Player p) {
		
		p.sendMessage("You don't have a night ability!");
		
	}

	public void doSpecialAbility(Player p) {
		
		//Nothing here
		
	}

	public void doVotingAbility(Player p, Player r, boolean lostVote) {
		
		//Nothing here
		
	}

}
