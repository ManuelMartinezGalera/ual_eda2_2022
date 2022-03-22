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
			String name = "";
			Player aux = null;
			try {
				scan = new Scanner(new File(file));
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				System.exit(-1);
				
			}
			while(scan.hasNextLine()) {
			line = scan.nextLine().replace(";;", ";0;");
			if(line.isEmpty()) continue;
			if(line.contains("PlayerName")) continue;
			items = line.split(";");
			int score = (int) (Double.parseDouble(items[7].replace(",", "."))*(Integer.parseInt(items[8]))/100);
			Player current = new Player(items[2], items[6], items[4], score);
				if(name.equals(current.getPlayerName())) {
					if(!aux.getPositions().equals(current.getPositions())) {
						aux.getPositions().addAll(current.getPositions());
					}
					if(!aux.getTeams().equals(current.getTeams())) {
						aux.getTeams().addAll(current.getTeams());
					}
					int newScore = (aux.getScore()+ score)/2;
					aux.setScore(newScore);
				}else if(!name.equals(current.getPlayerName())){
					players.add(aux);
					aux = current;
					name = current.getPlayerName();
				} else if(name.equals("")) {
					name = current.getPlayerName();
					aux = current;
				} else if(!scan.hasNextLine()) {
					players.add(aux);
				}
			}
	   }
	//public void DyV() 
	public static void main(String[] args) {
		loadFile("C:\\Users\\Manuel MG\\git\\ual_eda2_2022\\Practica1\\src\\P1\\NbaStats.csv");
		System.out.println(players.size());
	}
}
