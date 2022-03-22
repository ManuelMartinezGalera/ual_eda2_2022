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
			
			if(name.equals("")) {
                name = current.getPlayerName();
                aux = current;
            }else if(!name.equals(current.getPlayerName())){
                players.add(aux); 
                aux = current;
                name = current.getPlayerName();
            }else if(name.equals(current.getPlayerName())) {
                if(!aux.getPositions().equals(current.getPositions())) {
                    aux.getPositions().addAll(current.getPositions());
                }
                if(!aux.getTeams().equals(current.getTeams())) {
                    aux.getTeams().addAll(current.getTeams());
                }
                int newScore = (aux.getScore()+ score)/2;
                aux.setScore(newScore);

            }else if(!scan.hasNextLine()) {
                players.add(aux);
            }
		}
	  }
	   public void dividirArray(int start, int end) {

	        if (start < end && (end - start) >= 1) {
	            int mid = (end + start) / 2;
	            dividirArray(start, mid);
	            dividirArray(mid + 1, end);
	            mergeArrayElements(start, mid, end);
	        }
	    }

	    public void mergeArrayElements(int start, int mid, int end) {

	        ArrayList<Player> aux = new ArrayList<Player>();

	        int left = start;
	        int right = mid + 1;

	        while (left <= mid && right <= end) {

	            if (players.get(left).compareTo(players.get(right)) == 0 || players.get(left).compareTo(players.get(right)) == -1) {

	                aux.add(players.get(left));
	                left++;

	            } else {

	                aux.add(players.get(right));
	                right++;

	            }
	        }

	        while (left <= mid) {
	        	aux.add(players.get(left));
	            left++;
	        }

	        while (right <= end) {
	            aux.add(players.get(right));
	            right++;
	        }

	        for (int i = 0; i < aux.size(); start++) {
	            players.set(start, aux.get(i++));

	        }

	    }
	public static void posPlayer(ArrayList<Player> play) {
		for (Player p : play) {
			if(p.getPositions().isEmpty()) {
				System.out.println("El array esta vacio");
			}
			System.out.println(p.getPositions());
		}
	}
	   
	   
	public static void teamsPlayer(ArrayList<Player> play) {
		for (Player p : play) {
			System.out.println(p.getScore());
		}
	}
	public static void scorePlayer(ArrayList<Player> play) {
		for (Player p : play) {
			System.out.println(p.getTeams());
		}
		
	}
	public static void main(String[] args) {
		//loadFile("C:\\Users\\Manuel MG\\git\\ual_eda2_2022\\Practica1\\src\\P1\\NbaStats.csv");
		loadFile("C:\\Users\\jef97\\git\\ual_eda2_2022\\Practica1\\src\\P1\\NbaStats.csv");
		System.out.println(players.size());
		posPlayer(players);
		teamsPlayer(players);
		scorePlayer(players);
	}
}
