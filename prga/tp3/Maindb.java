package diallo.laudet.tp3;
import java.sql.*;
import java.util.Map;

public class Maindb {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			System.out.println("erreur: "+e.getMessage());
		}

		try {
			
		ChargerGrille cg = new ChargerGrille();
			Map<Integer, String> mp = cg.grillesDisponibles();
			System.out.println(mp);
			
			MotsCroises mc = cg.extraireGrille(10);
			System.out.println("ok");
			System.out.println(mc.solutions());
			
			
		} catch (SQLException e) {
			System.out.println("erreur: "+e.getMessage());
		} 
		
		
	}

}
