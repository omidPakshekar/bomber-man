package BomberMan.Game.Map;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import BomberMan.Game.Game;
import BomberMan.Game.tiles.Tile;

public class Map {

	private int width, height;
	// bar aval ke stone wall gozashte besh meqdr oon true mishe
	private boolean booleanStoneWall = false;
	public static int[][] tiles;
	private static int[][] tilesStatic;
	public static ArrayList<String> Hrkt = new ArrayList<>();

	private Game game;

	public Map(Game game, String path) {
		this.game = game;
		loadWorld(path);
	}
	public void update() {

	}
	public void Draw(Graphics g) {
		// mire bar asas pixel oon tile hamono rsm mikone

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				getTile(x, y).Draw(g, (x * Tile.TILEWIDTH), (y * Tile.TILEHEIGHT));

			}
		}
	}

	public Tile getTile(int x, int y) {
		// har Tile ye id dre mire bar asas id onono rsm mikone
		Tile t = Tile.tiles[tiles[x][y]];

		return t;
	}

	private void loadWorld(String path) {
		// String file = Utils.loadFileAsString(path);
		//
		// chon 17 ta kht drim koln
		String[] Lines = new String[17];
		// speak after
		String[] NeghahDar;
		try {

			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			int Count = 0;
			while ((line = br.readLine()) != null) {
				Lines[Count] = line;
				Count++;
			}

			// kht aval tool va arz zamin ro moshkas mikone
			for (int i = 0; i < Lines.length; i++) {
				if (i == 0) {
					// chon to kht aval shamel tdad kashi haye mord estefade hst
					// vase hmin aval tdad ino bedst miyarim bad ba in array misazim
					NeghahDar = Lines[i].split(" ");

					width = Integer.parseInt(NeghahDar[0]);
					height = Integer.parseInt(NeghahDar[1]);
					tiles = new int[width][height];

				}
				if (i >= 2) {
					// choon az kht 2 miyaym mokhtasat khashi ro vared mikonim
					String[] Hold = Lines[i].split(" ");
					for (int j = 0; j < Hold.length; j++) {
						tiles[i - 2][j] = Integer.parseInt(Hold[j]);
					}

				}

				// stone wall be sorat rndom
				if (!booleanStoneWall) {
					for (int j = 0; j < game.getTddStoneWall(); j++) {
						String[] Hold = RndomHrkt().split(" ");
						tiles[Integer.parseInt(Hold[0])][Integer.parseInt(Hold[1])] = 1;
					}
					booleanStoneWall = true;
				}

				if (booleanStoneWall) {
					for (int j = 0; j < Hrkt.size(); j++) {
						String[] Hold = Hrkt.get(j).split(" ");
						// System.out.println("t "+Hold[0] + " t2 " + Hold[1]);
						tiles[Integer.parseInt(Hold[0])][Integer.parseInt(Hold[1])] = 1;
					}
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// in khone haye rndom ro entekhab mikone va be arrayList ezfe mikone
	public String RndomHrkt() {
		Random rndm = new Random();
		int XX, YY;
		int rndX, rndY;
		String Hold = "";
		Label: while (true) {

			while (true) {

				// rndom az 13+1 hst chon khone avvl divar hst khone akhar ham divar hst
				rndX = rndm.nextInt(13) + 1;
				rndY = rndm.nextInt(13) + 1;

				int[][] HoldTile = getTiles();
				// braye ghrar grftn bayad hatman ro grass bshe
				if (HoldTile[rndX][rndY] == 2 || HoldTile[rndX][rndY] == 1) {
					continue;
				}

				Hold = String.valueOf(rndX);
				Hold += " ";
				Hold += String.valueOf(rndY);

				boolean f = false;
				for (int j = 0; j < Hrkt.size(); j++) {
					String HoldStr = Hrkt.get(j);
					if (HoldStr.equals(Hold)) {
						f = true;
					}
				}

				if (!f) {
					Hrkt.add(Hold);
					break Label;

				}

			}

		} // while--->true
		return Hold;
	}// Rndm Hrkt Method

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int[][] getTiles() {
		return tiles;
	}

	public void setTiles(int[][] tiles) {
		this.tiles = tiles;
	}

}
