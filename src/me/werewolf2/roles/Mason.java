package me.werewolf2.roles;

import java.util.ArrayList;

import me.werewolf2.Main;
import me.werewolf2.Player;

public class Mason extends Role {

	public Mason() {
		super(allRoles.MASON);
	}

	public void doNightAbility(Player p) {

		ArrayList<Player> masons = new ArrayList<Player>();
		for(int i = 0; i < Main.players.size(); i++) {
			Player r = Main.players.get(i);
			if(r.getRole() instanceof Mason) {
				masons.add(r);
			}
		}
		
		if(masons.size() == 1) {
			p.sendMessage("You are the only mason. #AloneMason");
		}else{
			String msg = "The masons are ";
			for(int i = 0; i < masons.size() - 1; i++) {
				msg += masons.get(i).getName();
			}
			msg += "and " + masons.get(masons.size() - 1) + ".";
			p.sendMessage(msg);
		}
	}

	public void runNight(Player p) {
		
		//Nothing here.
		
	}

	public void nightListen(String msg, Player p) {
		
		p.sendMessage("You don't have a night ability!");
		
	}

	public void doSpecialAbility(Player p) {
		
		//Nothing here.
		
	}

	public void doVotingAbility(Player p, Player r, boolean lostVote) {
		
		//Nothing here.
		
	}

}
