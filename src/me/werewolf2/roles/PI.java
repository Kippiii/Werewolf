package me.werewolf2.roles;

import me.werewolf2.Main;
import me.werewolf2.Player;
import me.werewolf2.roles.PIs.TannerPI;
import me.werewolf2.roles.PIs.WerewolfPI;

public class PI extends Role {
	int pick = 0, pick2 = 0;
	boolean picking2 = false;

	public PI() {
		super(allRoles.PI);
	}

	public void doNightAbility(Player p) {
		
		//Nothing here
		
	}

	public void runNight(Player p) {
		
		if(pick == 0 || pick2 == 0) {
			p.sendMessage("You forget to do your role!");
		}else{
			Player r = Main.players.get(pick - 1);
			Player r2 = Main.players.get(pick2 - 1);
			p.sendMessage(r.getName() + "'s role is " + r.getRole() + ".");
			if(r.getRole() instanceof Werewolf) {
				p.setRole(new WerewolfPI());
				p.sendMessage("You are now a werewolf!");
			}else if(r.getRole() instanceof Tanner) {
				p.setRole(new TannerPI());
				p.sendMessage("You are now a tanner!");
			}else{
				p.sendMessage(r2.getName() + "'s role is " + r2.getRole() + ".");
				if(r2.getRole() instanceof Werewolf) {
					p.setRole(new WerewolfPI());
					p.sendMessage("You are now a werewolf!");
				}else if(r2.getRole() instanceof Tanner) {
					p.setRole(new TannerPI());
					p.sendMessage("You are now a tanner!");
				}else{
					p.sendMessage("You remained a regular PI.");
				}
			}
		}
		
	}

	public void nightListen(String msg, Player p) {
		
		try {
			Integer number = Integer.parseInt(msg);
			if(picking2) {
				if(number >= 1 && number <= Main.playerCount) {
					pick2 = number;
					picking2 = false;
					p.sendMessage("You chose for your second pick to be " + Main.players.get(number - 1).getName() + ".");
				}else{
					p.sendMessage("That is not a valid number!");
				}
			}else{
				if(number >= 1 && number <= Main.playerCount) {
					pick = number;
					picking2 = true;
					p.sendMessage("Your first pick is " + Main.players.get(number - 1) + ".");
				}else{
					p.sendMessage("That is not a valid number!");
				}
			}
		} catch(Exception e) {
			p.sendMessage("Please send a number!");
		}
		
	}

	public void doSpecialAbility(Player p) {
		
		//Nothing here
		
	}

	public void doVotingAbility(Player p, Player r, boolean lostVote) {
		
		//Nothing here
		
	}
	
	public void setRole(allRoles r) {
		this.role = r;
	}

}
