package me.werewolf2;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import com.samczsun.skype4j.Skype;
import com.samczsun.skype4j.SkypeBuilder;
import com.samczsun.skype4j.exceptions.ConnectionException;
import com.samczsun.skype4j.exceptions.InvalidCredentialsException;
import com.samczsun.skype4j.exceptions.NotParticipatingException;

import me.werewolf2.roles.Drunk;
import me.werewolf2.roles.Hunter;
import me.werewolf2.roles.Insomniac;
import me.werewolf2.roles.Robber;
import me.werewolf2.roles.Role;
import me.werewolf2.roles.Seer;
import me.werewolf2.roles.Tanner;
import me.werewolf2.roles.Troublemaker;
import me.werewolf2.roles.Werewolf;
import me.werewolf2.roles.Witch;

public class Main extends Applet implements Runnable {
	
	private static final long serialVersionUID = 8784017235395936622L;
	
	final int WIDTH = 1152, HEIGHT = 864;
	public static GameState gs;
	public static ArrayList<Role> roles = new ArrayList<Role>();
	public static ArrayList<Player> players = new ArrayList<Player>();
	public static int playerCount;
	Thread thread, run;
	Graphics gfx;
	Image img, werewolf;
	public static ArrayList<Role> midRoles = new ArrayList<Role>();
	
	public void init() {
		//Add whatever roles you want.
		roles.add(new Werewolf());
		roles.add(new Tanner());
		roles.add(new Robber());
		roles.add(new Troublemaker());
		roles.add(new Werewolf());
		roles.add(new Seer());
		
		this.resize(WIDTH, HEIGHT);
		
		img = createImage(WIDTH, HEIGHT);
		gfx = img.getGraphics();
		werewolf = getImage(getDocumentBase(), "Werewolf.jpg");
		
		thread = new Thread(this);
		thread.start();
		
		run = new Thread(new Run());
		run.start();
				
		Skype skype = new SkypeBuilder(Login.username, Login.password).withAllResources().build();
		
		try {
			skype.login();
		} catch (NotParticipatingException e) {
			e.printStackTrace();
		} catch (InvalidCredentialsException e) {
			e.printStackTrace();
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		
		try {
			skype.subscribe();
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		
		registerEvents(skype);
		
		System.out.println("Logged in!");
		
		gs = GameState.LOGIN;
		
	}
	
	public void paint(Graphics g) {
		gfx.setColor(Color.DARK_GRAY);
		gfx.fillRect(0, 0, WIDTH, HEIGHT);
		gfx.drawImage(werewolf, 0, 0, WIDTH, HEIGHT, this);
		gfx.setColor(Color.WHITE);
		Font f = new Font("TimesRoman", Font.BOLD, 50);
		gfx.setFont(f);
		gfx.drawString("Players:", 500, 50);
		f = new Font("TimesRoman", Font.BOLD, 30);
		gfx.setFont(f);
		for(int i = 0; i < playerCount; i++) {
			gfx.drawString((i+1) + ": " + Main.players.get(i).getName(), 20, 50 + ((i + 1) * 30));
		}
		f = new Font("TimesRoman", Font.BOLD, 50);
		gfx.setFont(f);
		gfx.setColor(Color.RED);
		gfx.drawString(Run.countdown + "", 1074, 50);
		
		g.drawImage(img, 0, 0, this);
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	
	public static void registerEvents(Skype skype) {
		skype.getEventDispatcher().registerListener(new UserChat());
	}

	public void run() {
		while(true) {
			
			
			
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
