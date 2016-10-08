package me.werewolf2.roles;

import me.werewolf2.Player;
import me.werewolf2.Team;

public abstract class Role {
	allRoles role;
	
	public Role(allRoles r) {
		this.role = r;
	}
	
	public String getRoleName() {
		return this.role.name;
	}
	
	public void sendRoleDescription(Player p) {
		p.sendMessage(this.role.description);
	}
	
	public int getRN() {
		return this.role.roleNumber;
	}
	
	public Team getTeam() {
		return this.role.team;
	}
	
	public abstract void doNightAbility(Player p);
	
	public abstract void runNight(Player p);
	
	public abstract void nightListen(String msg, Player p);
	
	public abstract void doSpecialAbility(Player p);
	
	public abstract void doVotingAbility(Player p, Player r, boolean lostVote);

}
