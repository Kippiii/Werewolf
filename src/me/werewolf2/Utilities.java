package me.werewolf2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

import me.werewolf2.roles.Role;
import me.werewolf2.roles.Tanner;
import me.werewolf2.roles.Werewolf;
import me.werewolf2.roles.allRoles;
import me.werewolf2.roles.Mayors.RevealedMayor;
import me.werewolf2.roles.PIs.TannerPI;
import me.werewolf2.roles.PIs.WerewolfPI;

public class Utilities {
	
	public static Player getPlayer(String id) {
		Player p = null;
		for(int i = 0; i < Main.playerCount; i++) {
			if(Main.players.get(i).getId() == id) {
				p = Main.players.get(i);
				break;
			}
		}
		return p;
	}
	
	public static void sendToAll(String msg) {
		for(int i = 0; i < Main.playerCount; i++) {
			Main.players.get(i).sendMessage(msg);
		}
	}
	
	public static void startGame() {
		int rand, i = 0;
		while(Main.roles.size() != 0) {
			rand = (int)(Math.random() * (Main.roles.size() - 1));
			if(i < Main.players.size()) {
				Main.players.get(i).setRole(Main.roles.get(rand));
				Main.players.get(i).setOriginalRole(Main.roles.get(rand));
			}else{
				if(Main.midRoles.size() == 0) {
					Main.midRoles.add(Main.roles.get(rand));
				}else if(Main.midRoles.size() == 1) {
					Main.midRoles.add(Main.roles.get(rand));
				}else{
					Main.midRoles.add(Main.roles.get(rand));
				}
			}
			
			Main.roles.remove(rand);
			i++;
		}
		
		for(int i1 = 0; i1 < Main.players.size(); i1++) {
				Player p = Main.players.get(i1);
				Role r = p.getRole();
				p.sendMessage("Your role is " + r.getRoleName() + ".");
				r.sendRoleDescription(p);
				r.doNightAbility(p);
			}
		
		Main.gs = GameState.NIGHTPHASE;
		
		Run.countdown = 60;
		
	}
	
	public static void startDay() {
		
		int n = allRoles.number;
		for(int rn = 1; rn <= n; rn++) {
			for(int i = 0; i < Main.playerCount; i++) {
				Player p = Main.players.get(i);
				Role r = p.getOriginalRole();
				int prn = r.getRN();
				if(prn == rn) {
					r.runNight(p);
				}
			}
		}
		
		Utilities.sendToAll("The night phase is over! Now try to figure out who the Werewolf is!");
		Run.countdown = 600;
		Main.gs = GameState.DAYPHASE;
		Skipper.skip();
		
	}
	
	public static void startVote() {
		
		Utilities.sendToAll("It is time to start voting! Caste your vote with the number of the person you think is the werewolf.");
		Main.gs = GameState.VOTING;
		Run.countdown = 30;
		
	}
	
	public static void endGame() {
		
		for(int i = 0; i < Main.playerCount; i++) {
			Player p = Main.players.get(i);
			if(p.getVote() != 0) {
				Player r = Main.players.get(p.getVote() - 1);
				if(p.getRole() instanceof RevealedMayor) {
					r.addVote();
					r.addVote();
				}else{
					r.addVote();
				}
			}else{
				p.sendMessage("You did not vote!");
			}
		}
		HashMap<String, Integer> playerScores = new HashMap<String, Integer>();
		
		for(int i = 0; i < Main.playerCount; i++) {
			Player p = Main.players.get(i);
			playerScores.put(p.getId(), p.getVotes());
		}
		
		TreeMap<String, Integer> ratedScores = sort(playerScores);
		
		for(int i = 0; i < Main.playerCount; i++) {
			Player p = Main.players.get(i);
			if(p.getVote() != 0) {
				Player r = Main.players.get(p.getVote() - 1);
				p.getRole().doVotingAbility(p, r, ratedScores.firstEntry().getKey() == p.getId());
			}else{
				p.sendMessage("You still did not vote!");
			}
		}
		
		for(int i = 0; i < Main.playerCount; i++) {
			Player p = Main.players.get(i);
			playerScores.put(p.getId(), p.getVotes());
		}
		
		ratedScores = sort(playerScores);
		System.out.println(ratedScores);
		
		ArrayList<String> al = new ArrayList<String>(ratedScores.keySet());
		
		String highId = al.get(0);
		Player p = null;
		for(int i = 0; i< Main.playerCount; i++) {
			if(highId == Main.players.get(i).getId()) {
				p = Main.players.get(i);
				break;
			}
		}
		
		Utilities.sendToAll(p.getName() + " has been killed! His role was " + p.getRole().getRoleName() + ".");
		
		for(int i = 0; i < Main.playerCount; i++) {
			Main.players.get(i).setName(Main.players.get(i).getName() + ": " + Main.players.get(i).getRole().getRoleName());
		}
		
		Main.gs = GameState.RESULTS;
		
		sendResults(p);
		
	}
	
	public static void sendResults(Player killed) {
		if(killed.getRole() instanceof Werewolf || killed.getRole() instanceof WerewolfPI) {
			for(int i = 0; i < Main.playerCount; i++) {
				Player p = Main.players.get(i);
				if(p.getRole().getTeam() == Team.VILLAGE) {
					p.sendMessage("You have won!");
				}else{
					p.sendMessage("You have lost!");
				}
			}
		}else if(killed.getRole() instanceof Tanner) {
			for(int i = 0; i < Main.playerCount; i++) {
				Player p = Main.players.get(i);
				if(p.getRole().getTeam() == Team.TANNER) {
					p.sendMessage("You have won!");
				}else{
					p.sendMessage("You have lost!");
				}
			}
		}else if(killed.getRole() instanceof TannerPI) {
			for(int i = 0; i < Main.playerCount; i++) {
				Player p = Main.players.get(i);
				if(p.getRole().getTeam() == Team.TANNERPI) {
					p.sendMessage("You have won!");
				}else{
					p.sendMessage("You have lost!");
				}
			}
		}else{
			for(int i = 0; i < Main.playerCount; i++) {
				Player p = Main.players.get(i);
				boolean isWerewolf = false;
				for(int i1 = 0; i1 < Main.playerCount; i1++) {
					if(Main.players.get(i1).getRole() instanceof Werewolf) {
						isWerewolf = true;
						break;
					}
				}
				if(isWerewolf) {
					if(p.getRole().getTeam() == Team.WEREWOLF) {
						p.sendMessage("You have won!");
					}else{
						p.sendMessage("You have lost!");
					}
				}else{
					if(p.getRole().getTeam() == Team.VILLAGE) {
						p.sendMessage("You have won!");
					}else{
						p.sendMessage("You have lost!");
					}
				}
			}
		}
	}
	
	public static TreeMap<String, Integer> sort(HashMap<String, Integer> map) {
		Comparator<String> c = new valueComparator(map);
		TreeMap<String, Integer> r = new TreeMap<String, Integer>(c);
		r.putAll(map);
		return r;
	}

}
