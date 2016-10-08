package me.werewolf2.roles;

import me.werewolf2.Main;
import me.werewolf2.Player;

public class Seer extends Role {
	boolean mid = false, picking2 = false;
	int pick = 0, pick2 = 0;

	public Seer() {
		super(allRoles.SEER);
	}

	public void doNightAbility(Player p) {
		
		//Nothing here
		
		
	}

	public void runNight(Player p) {
		
		if(pick != 0) {
			if(mid) {
				String msg = pick2 != 0 ? "The roles you found are " + Main.midRoles.get(pick - 1).getRoleName() + " and " + Main.midRoles.get(pick2 - 1).getRoleName() + "." : "The role you found was " + Main.midRoles.get(pick - 1) + ".";
				p.sendMessage(msg);
			}else{
				Player r = Main.players.get(pick - 1);
				p.sendMessage(r.getName() + "'s is " + r.getRole().getRoleName() + ".");
			}
		}
		
	}

	public void nightListen(String msg, Player p) {
		
		try {
			Integer person = Integer.parseInt(msg);
			if(mid) {
				if(person >= 1 && person <= 3) {
					if(picking2) {
						pick2 = person;
						p.sendMessage("You choose to look at the middle card " + person + ".");
						picking2 = false;
					}else{
						pick = person;
						p.sendMessage("You choose to look at the middle card " + person + ". You can still pick one more card.");
						picking2 = true;
					}
				}else{
					p.sendMessage("You need to pick a number between one and three.");
				}
			}else{
				if(person >= 1 && person <= Main.players.size()) {
					pick = person;
					p.sendMessage("You are going to look at the card of " + Main.players.get(person - 1) + ".");
				}else{
					p.sendMessage("That is not a valid player number.");
				}
			}
		}catch(Exception e) {
			if(msg.equalsIgnoreCase("mid")) {
				mid = true;
				p.sendMessage("You are now going to pick two center roles to look at. Type the number of those roles.");
			}else{
				p.sendMessage("That is not a valid thing you can type.");
			}
		}
		
	}

	public void doSpecialAbility(Player p) {
		
		//Nothing here.
		
	}

	public void doVotingAbility(Player p, Player r, boolean lostVote) {
		
		//Nothing here.
		
	}

}
