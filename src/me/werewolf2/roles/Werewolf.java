package me.werewolf2.roles;

import java.util.ArrayList;

import me.werewolf2.Main;
import me.werewolf2.Player;

public class Werewolf extends Role {
	boolean hasDoneNight;
	
	public Werewolf() {
		super(allRoles.WEREWOLF);
	}

	public void doNightAbility(Player p) {
		ArrayList<Player> werewolves = new ArrayList<Player>();
		for(int i = 0; i < Main.players.size(); i++) {
			if(Main.players.get(i).getRole() instanceof Werewolf) {
				werewolves.add(Main.players.get(i));
			}
		}
		if(werewolves.size() == 1) {
			p.sendMessage("You are the only werewolf! You get to look at a middle role! Type a number 1-3 for a middle role.");
		}else{
			String msg = "The werewolves in the game are: ";
			for(int i = 0; i < werewolves.size(); i++) {
				if(i == werewolves.size() - 1) {
					msg += werewolves.get(i).getName() + ".";
				}else{
					msg += werewolves.get(i).getName() + ", ";
				}
			}
			p.sendMessage(msg);
		}
	}

	public void doSpecialAbility(Player p) {
		
		p.sendMessage("Werewolves don't have day abilities!");
		
	}

	public void nightListen(String msg, Player p) {
			
			if(!hasDoneNight) {
				try {
				Integer midNumber = Integer.parseInt(msg);
				ArrayList<Player> werewolves = new ArrayList<Player>();
				for(int i = 0; i < Main.playerCount; i++) {
					if(Main.players.get(i).getRole().getRoleName().equalsIgnoreCase("werewolf")) {
						werewolves.add(Main.players.get(i));
					}
				}
				
				if(werewolves.size() == 1) {
					if(midNumber <= 3 && midNumber >=1) {
						p.sendMessage("The middle role is " + Main.midRoles.get(midNumber - 1).getRoleName());
						hasDoneNight = true;
					}else{
						p.sendMessage("Please send a number between 1 and 3.");
					}
				}else{
					p.sendMessage("You don't have a night ability!");
				}
				
			}catch(Exception e) {
				p.sendMessage("You need to send a number!");
			}
		}else{
			p.sendMessage("You have already done your night ability!");
		}
	}

	public void runNight(Player p) {
		
		//Nothing to put here.
		
	}

	public void doVotingAbility(Player p, Player r, boolean lostVote) {
		
		//Nothing to do here.
		
	}

}
