package BomberMan.Game.ObjectManager;

import java.awt.Rectangle;

import BomberMan.Game.Game;
import BomberMan.Game.Creature.Player;
import BomberMan.Game.Diaplay.Display;
import BomberMan.Game.GameManger.GameManager;
import BomberMan.Game.GameObject.Bomb;
import BomberMan.Game.Map.Map;
import BomberMan.Game.tiles.Tile;

public class ObjectManger {
	private Player player;
	private long Time;
	private Game game;

	public ObjectManger(Player player, Game game) {
		this.player = player;
		this.game = game;
		CheckBrKhord();
	}

	public void CheckBrKhord() {

		// brsi mohasebe bord
		if (GameManager.enemyObj.size() == 0) {
			game.getDisplay().getFrame().dispose();
			if (!game.isWin()) {
				game.setFinish(true);

				// display ro meqdr dehi mikonim
				game.getDisplay().setTddEnemy(game.getTddEnemy());
				game.getDisplay().setTddBomb(game.getTddBomb());
				game.getDisplay().setW(4);
				game.getDisplay().setTime(game.getNow2());
				game.getDisplay().YouWin();
				game.setWin(true);

				System.out.println("You Win");
			}
		} else if (player.getHealth() <= 0) {
			game.getDisplay().getFrame().dispose();
			if (!game.isLose()) {
				game.setFinish(true);

				// display ro meqdr dehi mikonim
				game.getDisplay().setTddEnemy(game.getTddEnemy());
				game.getDisplay().setTddBomb(game.getTddBomb());
				game.getDisplay().setW(1);
				game.getDisplay().setTime(game.getNow2());
				game.getDisplay().YouLose();
				game.setLose(true);

			}
		}

		Display.lblOutPutHealth.setText(String.valueOf(player.getHealth()));
		// bomb baad az 3 saniye 3 halat dre
		for (int i2 = 0; i2 < GameManager.bombObj.size(); i2++) {
			if (System.currentTimeMillis() - GameManager.bombObj.get(i2).getTime() > 3000) {
				for (int j = 0; j < GameManager.enemyObj.size(); j++) {
					// age shoaye bomb stone wall va player va enemy ba ham bahsn
					if (GameManager.bombObj.get(i2).getBounds().intersects(GameManager.enemyObj.get(j).getBounds())
							&& GameManager.bombObj.get(i2).getBounds().intersects(player.getBounds())
							&& StoneWallisExplodable(GameManager.bombObj.get(i2))) {
						GameManager.enemyObj.remove(j);
						player.setHealth(player.getHealth() - 5);
					} // age player va enemy ba ham to shoaye bomb bodn
					else if (GameManager.bombObj.get(i2).getBounds().intersects(GameManager.enemyObj.get(j).getBounds())
							&& GameManager.bombObj.get(i2).getBounds().intersects(player.getBounds())) {
						GameManager.enemyObj.remove(j);
						player.setHealth(player.getHealth() - 5);
					} // age player va stone wall dr shoaye bomb bodn
					else if (GameManager.bombObj.get(i2).getBounds().intersects(player.getBounds())
							&& StoneWallisExplodable(GameManager.bombObj.get(i2))) {
						player.setHealth(player.getHealth() - 5);
					} // age enemy ba stone wall to shoaye bomb bodn
					else if (GameManager.bombObj.get(i2).getBounds().intersects(GameManager.enemyObj.get(j).getBounds())
							&& StoneWallisExplodable(GameManager.bombObj.get(i2))) {
						GameManager.enemyObj.remove(j);
					} // age enemy ba player to shoaye bomb bodn
					else if (GameManager.bombObj.get(i2).getBounds().intersects(GameManager.enemyObj.get(j).getBounds())
							&& GameManager.bombObj.get(i2).getBounds().intersects(player.getBounds())) {
						GameManager.enemyObj.remove(j);
						player.setHealth(player.getHealth() - 5);
					} // age stone wall to shoa bshe
					else if (StoneWallisExplodable(GameManager.bombObj.get(i2))) {

					} // age enemy dr shoaye bomb bshe
					else if (GameManager.bombObj.get(i2).getBounds()
							.intersects(GameManager.enemyObj.get(j).getBounds())) {
						GameManager.enemyObj.remove(j);
					} // age playe dr shoaye bomb bashe
					else if (GameManager.bombObj.get(i2).getBounds().intersects(player.getBounds())) {
						player.setHealth(player.getHealth() - 5);
						// GameState.bombObj.remove(i2);

						System.out.println("helth " + player.getHealth());
						// break;
					}

				}
				GameManager.bombObj.remove(i2);

			}
		}

		// /// dr inja miyaym barkhord har kodom object har ro brsi mikonim

		// barkhord har kodom az enemy ha ba player
		for (int i = 0; i < GameManager.enemyObj.size(); i++) {
			if (GameManager.enemyObj.get(i).getBounds().intersects(player.getBounds())) {
				GameManager.enemyObj.remove(i);
				player.setHealth(player.getHealth() - 50);

			}
		}

		// barkhor hr enemy ba bomb ro brsi mikonim

		// barkhord player ba heart
		for (int i = 0; i < GameManager.heartObj.size(); i++) {

			if (player.getBounds().intersects(GameManager.heartObj.get(i).getBounds())) {
				player.setHealth(100);
				GameManager.heartObj.remove(i);
			}
		}
		// inja brsi mikonimke age be star brkhord kone
		for (int i = 0; i < GameManager.StarObj.size(); i++) {
			if (GameManager.StarObj.get(i).getBounds().intersects(player.getBounds())) {
				System.out.println("l;klk");
				GameManager.StarObj.remove(i);
				if (!(Bomb.ShoayeTrkidn > 3)) {
					Bomb.ShoayeTrkidn++;
					player.setTime(5 * 1000 + System.currentTimeMillis());

				}
			}
		}

		// inja brsi mikone age zaman khordn star az 40 saniye gozashte bashe
		// shoaye oon be shoaye ghblish bargarde

		if (System.currentTimeMillis() - player.getTime() > 5 * 1000) {
			if (Bomb.ShoayeTrkidn > 1) {
				Bomb.ShoayeTrkidn--;
			}
		}

	}// end Check BarKhord Method

	public Rectangle getBounds() {
		for (int i = 0; i < Map.tiles.length; i++) {
			for (int j = 0; j < Map.tiles.length; j++) {
				if (Map.tiles[i][j] == 1) {
					return new Rectangle(i * Tile.TILEWIDTH, j * Tile.TILEHEIGHT, Tile.TILEWIDTH, Tile.TILEHEIGHT);
				}
			}
		}
		return null;

	}

	public boolean StoneWallisExplodable(Bomb bomb) {

		for (int i = 0; i < Map.tiles.length; i++) {
			for (int j = 0; j < Map.tiles.length; j++) {
				// chon tile = 0 mishe stone wall
				if (Map.tiles[i][j] == 1) {
					// i va j ro tbdil be pix tbdil mkonm
					if (bomb.getBounds().intersects(
							new Rectangle(i * Tile.TILEWIDTH, j * Tile.TILEHEIGHT, Tile.TILEWIDTH, Tile.TILEHEIGHT))) {
						// chon khone hayi ke stone wal bodn ro save krde bodim
						// hr kodom ke hazf mishe ro az arrayList pak mikonim
						for (int k = 0; k < Map.Hrkt.size(); k++) {
							String[] Hold = Map.Hrkt.get(k).split(" ");
							if (Integer.parseInt(Hold[0]) == i && Integer.parseInt(Hold[1]) == j) {
								Map.Hrkt.remove(k);
								Map.tiles[i][j] = 0;
								return true;
							}
						}

					}
				}
			}
		}
		return false;

	}
}// end class
