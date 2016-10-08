package me.werewolf2;

import com.samczsun.skype4j.chat.Chat;
import com.samczsun.skype4j.events.EventHandler;
import com.samczsun.skype4j.events.Listener;
import com.samczsun.skype4j.events.chat.message.MessageReceivedEvent;

public class UserChat implements Listener {
	
	@EventHandler
	public void onChat(MessageReceivedEvent e) {
		String msg = e.getMessage().getContent().asPlaintext();
		Chat c = e.getChat();
		String id = e.getMessage().getSender().getId();
		Player p = Utilities.getPlayer(id);
		
		if(Main.gs == GameState.LOGIN) {
			if(p != null) {
				p.sendMessage("You are already in the game!");
			}else{
				p = new Player(id, msg, c);
				if(msg.length() <= 25) {
					Main.players.add(p);
					Main.playerCount++;
					if(Main.roles.size() - 3 == Main.playerCount) {
						Utilities.startGame();
					}
				}else{
					p.sendMessage("Your name is too long!");
				}
			}
		}else if(Main.gs == GameState.NIGHTPHASE) {
			if(p != null) {
				p.getRole().nightListen(msg, p);
			}
		}else if(Main.gs == GameState.DAYPHASE) {
			if(p != null) {
				p.getOriginalRole().doSpecialAbility(p);
			}
		}else if(Main.gs == GameState.VOTING) {
			try {
				int vote = Integer.parseInt(msg);
				if(vote >= 1 && vote <= Main.players.size()) {
					p.setVote(vote);
					p.sendMessage("Thank you for voting!");
				}else{
					p.sendMessage("That is not a valid number!");
				}
			}catch(Exception ex) {
				p.sendMessage("That is not a vote!");
			}
		}
 		
	}

}
