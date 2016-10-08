package me.werewolf2.roles;

import me.werewolf2.Player;
import me.werewolf2.Utilities;
import me.werewolf2.roles.Mayors.RevealedMayor;
import me.werewolf2.roles.Mayors.WerewolfMayor;

public class Mayor extends Role {

	public Mayor() {
		super(allRoles.MAYOR);
	}

	public void doNightAbility(Player p) {
		
		//Nothing here
		
	}

	public void runNight(Player p) {
		
		//Nothing here
		
	}

	public void nightListen(String msg, Player p) {
		
		p.sendMessage("You don't have a night ability.");
		
	}

	public void doSpecialAbility(Player p) {
		
		Role r = p.getRole();
		if(r instanceof Mayor) {
			p.setRole(new RevealedMayor());
			Utilities.sendToAll(p.getName() + " has revealed himself. He is still a mayor. His vote now counts as two.");
		}else if(r instanceof Werewolf) {
			p.setRole(new WerewolfMayor());
			Utilities.sendToAll(p.getName() + " has revealed himself. He is a werewolf! He has lost the game!");
		}else{
			Utilities.sendToAll(p.getName() + " has revealed himself. His is now a " + p.getRole().getRoleName() + ".");
		}
		
	}

	public void doVotingAbility(Player p, Player r, boolean lostVote) {
		
		//Nothing here
		
	}
	
	public void setRole(allRoles r) {
		this.role = r;
	}

}
