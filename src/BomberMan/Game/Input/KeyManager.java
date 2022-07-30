package BomberMan.Game.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	
	private boolean[] keys;
	public boolean up, down, left, right , bomb;

	// frz migrim 256 modl vase vorodi grftn drim hr kodom 
	//az dokme ha zade she oon true mishe
	// hr kodom ke azadm beshe false mishe
	public KeyManager(){
		keys = new boolean[256];
	}
	
	public void update(){
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		bomb = keys[KeyEvent.VK_X];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
