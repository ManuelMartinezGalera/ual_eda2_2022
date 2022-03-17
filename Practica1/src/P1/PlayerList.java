package P1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerList {
	static ArrayList<Player> players = new ArrayList<Player>();
	   public static void loadFile(String file) {
			Scanner scan = null;
			String line;
			String[] items = null;
			try {
				scan = new Scanner(new File(file));
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				System.exit(-1);
				
			}
			while(scan.hasNextLine()) {
			line = scan.nextLine();
			
			if(line.isEmpty()) continue;
			if(line.contains("PlayerName")) continue;
			items = line.split(";");
			int score = (int) ((Float.parseFloat(items[7]))*(Integer.parseInt(items[8]))/100);
			players.add(new Player(items[2], items[6], items[4], score));
			}
	   }
	public static void main(String[] args) {
		loadFile("C:\\WORKSPACES\\EDAII2022\\Practica1\\src\\P1\\NbaStats.csv");
		System.out.println(players);
	}
}
