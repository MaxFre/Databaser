

	import java.sql.*;
	import java.util.*;

	public class firstTest {
		private String test = "";
		
		
		public firstTest() throws Exception {
			 Class.forName("org.postgresql.Driver").newInstance();
		        Connection conn = DriverManager.getConnection("jdbc:postgresql://pgserver.mah.se/ag7420?user=ag7420&password=lpc6hvpi");
		        PreparedStatement stmt = conn.prepareStatement("select * from hund");
		        ResultSet rs = stmt.executeQuery();
		        while (rs.next()) {
		            test += "Namn: " +rs.getString(2)+", Ras: "+rs.getString(3)+", Medlemsnummer: "+rs.getString(1) +"\n";
		        }
		        conn.close();
		    
		        
		        System.out.println(test);
		}
		
	    public static void main(String[] args) throws Exception{
	    	firstTest run = new firstTest();
	    }
	}