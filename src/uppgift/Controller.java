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
			
			if (vad.equals("visaM")) {
				respons += "Namn: " + rs.getString(1) + " " + rs.getString(2) + ",  extra  info - " + rs.getString(3) +"\n";
			}
			if (vad.equals("visa")) {
				respons += "Tid: " + rs.getString(1) + " Scene:" + rs.getString(2)  + "\n";
			}
			if (vad.equals("Contact")) {
				respons += "Kontaktperson: " + rs.getString(1) + " " + rs.getString(2) + "  Band: " + rs.getString(3) + "\n";
			}
			if (vad.equals("AdminContact")) {
				respons += "Pid: " + rs.getString(1) + " Person: " + rs.getString(2) + " " + rs.getString(3) + "  Band-id: " + rs.getString(4) + "  Band: "+ rs.getString(5)+ "\n";
			}

			if (vad.equals("schema")) {
				respons += "Band: " + rs.getString(1) + "  Scene: " + rs.getString(2) + "  Tid: " + rs.getString(3)
						+ "\n";
			}

			if (vad.equals("Adminschema")) {
				respons += "Band: " + rs.getString(1) + "  Scene: " + rs.getString(2) + "  Tid: " + rs.getString(3)
						+ "  Extra: " + rs.getString(4) + "\n";
			}
			
			if (vad.equals("band")) {
				respons += "Band: " + rs.getString(1)+ "\n";
			}
			if (vad.equals("Adminband")) {
				respons += "Band: " + rs.getString(1) +"          Band-id: " + rs.getString(2) + "\n";
			}

			if (vad.equals("jobbare")) {
				respons += "Pid: " + rs.getString(1) + "  Förnamn: " + rs.getString(2) + " " + rs.getString(3)
						+ "  Personnummer: " + rs.getString(4) + "  Adress: " + rs.getString(5) + "\n";
			}
			if (vad.equals("Addband")) {
				respons = "Added";
			}
			if (vad.equals("DeleteBand")) {
				respons = "Deleted";
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

