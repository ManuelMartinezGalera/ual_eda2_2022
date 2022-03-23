package P1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class PlayerListTest {

	@Test
	void testTop10Players() {
		
		PlayerList.loadFile("C:\\Users\\Manuel MG\\git\\ual_eda2_2022\\Practica1\\src\\P1\\NbaStats.csv");
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
	void testDescendente() {
		
		
		
	}

}
