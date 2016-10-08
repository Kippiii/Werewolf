package me.werewolf2.roles;

import java.util.ArrayList;

import me.werewolf2.Main;
import me.werewolf2.Player;

public class AssistantTanner extends Role {

	public AssistantTanner() {
		super(allRoles.ASSISTANT_TANNER);
	}

	public void doNightAbility(Player p) {
		
		//Nothing here
		
	}

	public void runNight(Player p) {
		
		ArrayList<Player> tanners = new ArrayList<Player>();
		for(int i = 0; i < Main.playerCount; i++) {
			Player r = Main.players.get(i);
			if(r.getRole() instanceof Tanner) {
				tanners.add(r);
			}
		}
		
		String msg;
		if(tanners.size() == 0) {
			msg = "There are no tanners. You are now a tanner yourself. Enjoy.";
			p.setRole(new Tanner());
		}else if(tanners.size() == 1) {
			msg = "The tanner is " + tanners.get(0).getName() + ".";
		}else{
			msg = "The tanners are ";
			for(int i = 0; i < tanners.size() - 1; i++) {
				Player r = tanners.get(i);
				msg += r.getName() + ", ";
			}
			msg += "and " + tanners.get(tanners.size() - 1).getName() + ".";
		}
		
		p.sendMessage(msg);
		
	}

	public void nightListen(String msg, Player p) {
		
		p.sendMessage("You do not have a night ability!");
		
	}

	public void doSpecialAbility(Player p) {
		
		//Nothing here
		
	}

	public void doVotingAbility(Player p, Player r, boolean lostVote) {
		
		//Nothing here
		
	}

}
