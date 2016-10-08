package me.werewolf2.roles;

import me.werewolf2.Team;

public enum allRoles {
	
	WEREWOLF(1, "Werewolf","You get to know who the other werewolves are. If one werewolf gets lynched, they all lose. If there is only one werewolf, you get to look at one role from the center.", Team.WEREWOLF),
	SEER(2, "Seer", "As the seer you can look at either two center roles or at one player role. Send the mess 'mid' to pick a middle role. To pick a person to look at, type in their number.", Team.VILLAGE),
	APPRENTICE_SEER(3, "Apprentice Seer", "You get to look at one card from the center", Team.VILLAGE),
	PI(4, "Paranormal Investigator", "You get to look at two peoples' roles. If you see a werewolf or a tanner, you become that role.", Team.VILLAGE),
	WerewolfPI(4, "Paranormal Investigator(Werewolf)", "You get to look at two peoples' roles. If you see a werewolf or a tanner, you become that role.", Team.WEREWOLF),
	TannerPI(4, "Paranormal Investigator(Tanner)", "You get to look at two peoples' roles. If you see a werewolf or a tanner, you become that role.", Team.TANNERPI),
	ROBBER(5, "Robber", "You get to choose one person during the night whose role you can steal. You get to look at that role afterwards. In order to see their role, type their player number.", Team.VILLAGE),
	TROUBLEMAKER(6, "Troublemaker", "Choose two players by their numbers to have their roles switched.", Team.VILLAGE),
	WITCH(7, "Witch", "Choose one of the three middle roles. Then give this role to one of the players.", Team.VILLAGE),
	DRUNK(8, "Drunk", "Drunk writes the number of a middle role. They recieve that middle role, but don't get to know what it is.", Team.VILLAGE),
	MASON(9, "Mason", "You get to know who the other masons are.", Team.VILLAGE),
	TANNER(10, "Tanner", "Stop at nothing to get lynched.", Team.TANNER),
	HUNTER(11, "Hunter", "If you get voted out, the person who you voted for dies instead.", Team.VILLAGE),
	MINION(12, "Minion", "You know who the werewolves are. Your job is to keep them alive at all costs. Also, if you die, you and the werewolves still win.", Team.WEREWOLF),
	PRINCE(13, "Prince", "If you get voted out, the person with the second most votes dies instead.", Team.VILLAGE),
	MAYOR(14, "Mayor", "You get to 'reveal' during the day phase. If you are still the mayor, your votes count as two. If you are now a werewolf, you instantly lose.", Team.VILLAGE),
	WEREWOLF_MAYOR(14, "Mayor(Werewolf)", "", Team.LOSTMAYOR),
	ASSISTANT_TANNER(15, "Assistant Tanner", "You are told who the real tanner is. Get them lynched at all costs.", Team.TANNER),
	INSOMNIAC(16, "Insomniac", "They get to see what their role is at the end of the night period.", Team.VILLAGE);
	
	
	
	int roleNumber;
	String name, description;
	Team team;
	
	public static int number = 16;
	
	allRoles(int rn, String n, String d, Team t) {
		this.roleNumber = rn;
		this.name = n;
		this.description = d;
		this.team = t;
	}

}
