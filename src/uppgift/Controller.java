package uppgift;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Controller {

	private String selectWhat;
	private String fromWhat;
	private String respons = "";

	public Controller(String vad, String toDo) throws Exception {
		Class.forName("org.postgresql.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection("jdbc:postgresql://104.199.20.214/ag7420?user=ag7420&password=ukq2wl3i");

		PreparedStatement stmt = conn.prepareStatement(toDo);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

//			if (vad.equals("tabeller")) {
//				respons += "Förnamn: " + rs.getString(1) + " " + rs.getString(2) + "  Band: " + rs.getString(3) + "\n";
//			}
			
			
			if (vad.equals("Contact")) {
				respons += "Förnamn: " + rs.getString(1) + " " + rs.getString(2) + "  Band: " + rs.getString(3) + "\n";
			}

			if (vad.equals("schema")) {
				respons += "Band: " + rs.getString(1) + "  Scene: " + rs.getString(2) + "  Tid: " + rs.getString(3)
						+ "\n";
			}

			if (vad.equals("band")) {
				respons += "Band: " + rs.getString(1) + "  Land: " + rs.getString(2) + "\n";
			}

			if (vad.equals("jobbare")) {
				respons += "Pid: " + rs.getString(1) + "  Förnamn: " + rs.getString(2) + " " + rs.getString(3)
						+ "  Personnummer: " + rs.getString(4) + "  Adress: " + rs.getString(5) + "\n";
			}
		}
		conn.close();
	}
	
//	public Controller(String selectWhat, String fromWhat)throws Exception {
//		
//		this.selectWhat = selectWhat;
//		this.fromWhat = fromWhat;
//		
//        Class.forName("org.postgresql.Driver").newInstance();  
//        Connection conn = DriverManager.getConnection("jdbc:postgresql://104.199.20.214/ag7420?user=ag7420&password=ukq2wl3i");
//   
//        PreparedStatement stmt = conn.prepareStatement("select "+ selectWhat +"  from " + fromWhat );
//        ResultSet rs = stmt.executeQuery();
//        while (rs.next()) {
//        	
//           respons +=  selectWhat+ ": " +rs.getString(1)+"\n";
//        }
//        
//        conn.close();
//    }
		
	
	public String getRespons(){
		return respons;
	}
	
	}

