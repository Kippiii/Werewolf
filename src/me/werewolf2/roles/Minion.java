package me.werewolf2.roles;

import java.util.ArrayList;

import me.werewolf2.Main;
import me.werewolf2.Player;

public class Minion extends Role {

	public Minion() {
		super(allRoles.MINION);
	}

	public void doNightAbility(Player p) {
		
		ArrayList<Player> werewolves = new ArrayList<Player>();
		for(int i = 0; i < Main.playerCount; i++) {
			if(Main.players.get(i).getRole() instanceof Werewolf) {
				werewolves.add(Main.players.get(i));
			}
		}
		
		if(werewolves.size() == 0) {
			p.sendMessage("There are no werewolves. :(");
		}else if(werewolves.size() == 1) {
			Player w = werewolves.get(0);
			p.sendMessage("The only werewolf in the game is " + w.getName() + ".");
		}else{
			String msg = "The werewolves are ";
			for(int i = 0; i < werewolves.size() - 1; i++) {
				msg += werewolves.get(i).getName() + ", ";
			}
			msg += "and " + werewolves.get(werewolves.size() - 1).getName() + ".";
			p.sendMessage(msg);
		}
		
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
		
		//Nothing here
		
	}

}
