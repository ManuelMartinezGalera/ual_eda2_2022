package P1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class PlayerListTest {

	@Test
	void testTop10Players() {
		PlayerList.top=10;
		PlayerList.loadFile(PlayerList.path);
		//loadFile("C:\\Users\\jef97\\git\\ual_eda2_2022\\Practica1\\src\\P1\\NbaStats.csv");
		ArrayList<Player> comprobacion = PlayerList.top10Players(PlayerList.players);
		
		assertEquals("[LeBron James: 1031,"
				+ " James Harden: 994,"
				+ " Stephen Curry: 975,"
				+ " Karl-Anthony Towns: 965,"
				+ " Russell Westbrook: 931,"
				+ " Anthony Davis: 894,"
				+ " Kevin Durant: 864,"
				+ " Damian Lillard: 825,"
				+ " DeMar DeRozan: 820,"
				+ " Wilt Chamberlain*: 785]",comprobacion.toString() );;
	}
	
	@Test
	void testAscendente() {
		
		PlayerList.top=10;
		PlayerList.players = new ArrayList<Player>();
		
		for (int i = 1; i <= 100; i++) { //String playerName, String team, String position, int score
			Player p = new Player("Jugador"+i, "", "", i);
			PlayerList.players.add(p);
		}
		
		ArrayList<Player> comprobacion = PlayerList.top10Players(PlayerList.players);
		
		assertEquals("[Jugador100: 100, Jugador99: 99, Jugador98: 98, Jugador97: 97, Jugador96: 96, Jugador95: 95, Jugador94: 94, Jugador93: 93, Jugador92: 92, Jugador91: 91]", comprobacion.toString());
	}
	
	@Test
	void testDescendente() {
		
		PlayerList.top=10;
		PlayerList.players = new ArrayList<Player>();
		
		int j = 1;
		
		for (int i = 100; i >= 1; i--) { //String playerName, String team, String position, int score
			Player p = new Player("Jugador"+j, "", "", i);
			PlayerList.players.add(p);
			j++;
		}
		
		ArrayList<Player> comprobacion = PlayerList.top10Players(PlayerList.players);
		
		assertEquals("[Jugador1: 100, Jugador2: 99, Jugador3: 98, Jugador4: 97, Jugador5: 96, Jugador6: 95, Jugador7: 94, Jugador8: 93, Jugador9: 92, Jugador10: 91]", comprobacion.toString());
		
	}

}
