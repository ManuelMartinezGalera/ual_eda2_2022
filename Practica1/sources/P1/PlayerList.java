package P1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerList {
	
	static ArrayList<Player> players = new ArrayList<Player>();
	public static int top;
	public static String path = System.getProperty("user.dir")+File.separator+"sources"+File.separator+"P1"+File.separator+"NbaStats.csv";
	   
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
			
			//Filtro de judores para evitar repetidos y actualizar valores.
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

            }
			
			if(!scan.hasNextLine()) {
                players.add(aux);
            }
		}
	  }
	
	//DyV
	   public static void dividirArray(int start, int end) {

	        if (start < end && (end - start) >= 1) {
	            int mid = (end + start) / 2;
	            dividirArray(start, mid);
	            dividirArray(mid + 1, end);
	            mergeArray(start, mid, end);
	        }
	    }

	    public static void mergeArray(int start, int mid, int end) {

	        ArrayList<Player> aux = new ArrayList<Player>();

	        int left = start;
	        int right = mid + 1;
	        
	        while ((left <= mid && right <= end) || aux.size() == top) {

	            if (players.get(left).compareTo(players.get(right)) == 0 || players.get(left).compareTo(players.get(right)) == -1) {

	                aux.add(players.get(right));
	                right++;

	            } else {

	                aux.add(players.get(left));
	                left++;

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
	
	    
	    //Codigo usado para mostrar info de los players
//	
//	public static void posPlayer(ArrayList<Player> play) {
//		for (Player p : play) {
//			if(p.getPositions().isEmpty()) {
//				System.out.println("El array esta vacio");
//			}
//			System.out.println(p.getPositions());
//		}
//	}
//	   
//	   
//	public static void teamsPlayer(ArrayList<Player> play) {
//		for (Player p : play) {
//			System.out.println(p.getTeams());
//		}
//	}
//	public static void scorePlayer(ArrayList<Player> play) {
//		for (Player p : play) {
//			System.out.println(p.getScore());
//		}
//		
//	}
//	
//	public static void namePlayer(ArrayList<Player> play) {
//		for(Player p : play) {
//			System.out.println(p.getPlayerName()+","+p.getPositions()+","+p.getTeams()+","+p.getScore());
//		}
//		
//	}
	
	//Metodo para devolver arraylist del top 10
	public static ArrayList<Player> top10Players(ArrayList<Player> player) {
		ArrayList<Player> aux10 = new ArrayList<Player>();
		dividirArray(0,players.size()-1);
		for (int i =0; i<top; i++) {
			aux10.add(player.get(i));
		}
		
		return aux10;
		
	}
	
	public static void main(String[] args) {
		loadFile(path);
		top = 10;
		System.out.println("Los 10 mejores jugadores de la NBA:");
		long ini = System.nanoTime();
		ArrayList<Player> sol = top10Players(players);
		long end = System.nanoTime();
		int i = 1;
		for (Player p : sol) {
			System.out.print(i+". "+ p.toString()+"\n");
			i++;
		}
		
		System.out.println("El tiempo de ejecución fue: "+(end-ini)+" nanosegundos");
		
	}
}
