package BomberMan.Game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

import BomberMan.Game.Diaplay.Display;
import BomberMan.Game.Diaplay.Profile;
import BomberMan.Game.GameManger.GameManager;
import BomberMan.Game.ImageLoader.ImageLoader;
import BomberMan.Game.Input.KeyManager;
import BomberMan.Game.Map.Map;

public class Game implements Runnable {

	private Display display;
	public static int width, height;
	public String title;

	private boolean running = false;
	private Thread thread;

	private BufferStrategy bs;
	private Graphics g;

	// Game <anager
	private GameManager gameManager;
	// Profile
	Profile profile;
	// Input
	private KeyManager keyManager;
	// map
	private Map world;
	// Time
	private long FirsTime;
	private long Now2;
	// tdd enemy
	private int tddEnemy;
	// tdad Stone wall
	private int tddStoneWall;
	// age brnde beshi meghdr win true age bebazi meghdr on false mishe
	private boolean win = false, lose = false;
// tdd bomb 
	private int tddBomb;
	// age true beshe bazi tamome
	private boolean finish=false;
	//
	private String Name;

	public Game(String title, int width, int height, int tddEnemy ,String Name) {
		Random rndm = new Random();
		this.width = width;
		this.height = height;
		this.tddEnemy = tddEnemy;
		this.title = title;
		this.Name=Name;
		keyManager = new KeyManager();
		tddStoneWall = rndm.nextInt(10) + 1;
		FirsTime = System.currentTimeMillis();
		// name ro vase display mifrstim
		System.out.println("Name = "+Name);

	}

	private void init() {
		display = new Display(title, width, height);
		// be canvas keyListener add mikonim
		display.getCanvas().addKeyListener(keyManager);
		display.setName(Name);
		ImageLoader.init();

		gameManager = new GameManager(this);

	}

	private void update() {

		keyManager.update();
		gameManager.update();

	}

	private void Draw() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// Clear Screen
		g.clearRect(0, 0, width, height);
		// Draw Here!

		gameManager.render(g);

		// End Drawing!
		bs.show();
		g.dispose();
	}

	public void run() {

		init();

		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();

		long timer = 0;
		int ticks = 0;

		while (running) {
			if(finish) {
				break;
			}
			now = System.nanoTime();
			// in time har dfe ke bekhaym mitonim to class haye dige bebinim
			long TN = System.currentTimeMillis();
			 Now2 = (TN - FirsTime) / 1000;
			Display.lblOutPutTime.setText(String.valueOf(Now2));
			
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				update();
				Draw();
				ticks++;
				delta--;
			}

			if (timer >= 1000000000) {
				// System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();

	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Map getWorld() {
		return world;
	}

	public void setWorld(Map world) {
		this.world = world;
	}

	public int getTddEnemy() {
		return tddEnemy;
	}

	public int getTddStoneWall() {
		return tddStoneWall;
	}

	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public boolean isLose() {
		return lose;
	}

	public void setLose(boolean lose) {
		this.lose = lose;
	}

	public Profile getProfile() {
		return profile;
	}

	public int getTddBomb() {
		return tddBomb;
	}
	public void setTddBomb(int tddBomb) {
		this.tddBomb = tddBomb;
	}

	public void setTddEnemy(int tddEnemy) {
		this.tddEnemy = tddEnemy;
	}
	public long getNow2() {
		return Now2;
	}

	public void setNow2(long now2) {
		Now2 = now2;
	}

	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}

	public String getName() {
		return Name;
	}

	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}