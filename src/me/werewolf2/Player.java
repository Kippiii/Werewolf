package me.werewolf2;

import com.samczsun.skype4j.chat.Chat;
import com.samczsun.skype4j.exceptions.ConnectionException;

import me.werewolf2.roles.Role;

public class Player {
	String id, name;
	Chat chat;
	Role role, originalRole;
	int vote = 0, votes = 0;
	
	Player(String id, String name, Chat c) {
		this.id = id;
		this.name = name;
		this.chat = c;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Chat getChat() {
		return this.chat;
	}
	
	public void sendMessage(String m) {
		try {
			this.chat.sendMessage(m);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
	}
	
	public void setRole(Role r) {
		this.role = r;
	}
	
	public Role getRole() {
		return this.role;
	}
	
	public void setVote(int v) {
		this.vote = v;
	}
	
	public int getVote() {
		return this.vote;
	}
	
	public void addVote() {
		this.votes ++;
	}
	
	public void setVotes(int v) {
		this.votes = v;
	}
	
	public int getVotes() {
		return this.votes;
	}
	
	public void setName(String n) {
		this.name = n;
	}
	
	public void setOriginalRole(Role r) {
		this.originalRole = r;
	}
	
	public Role getOriginalRole() {
		return this.originalRole;
	}
}
