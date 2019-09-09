import java.sql.*;

//https://mvnrepository.com/artifact/com.oracle/ojdbc14
//C:\ora11gr2\product\11.2.0\client_1\network\admin\tnsnames.ora
//(1) download ojdbc14.jar
//(2) paste into jre/lib/ext folder
//(3) set classpath=C:\Program Files\Java\jdk1.8.0_144\jre\lib\ext\ojdbc14.jar;.;


class OracleCon {
	
	public static void main(String args[]) {
	
		try {
			
			//step1 load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//step2 create the connection object
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@myhost:1521:myservice","username","password");
			
			//step3 create the statement object
			Statement stmt = con.createStatement();
			
			//step4 execute query
			ResultSet rs = stmt.executeQuery("SELECT OWNER,TABLE_NAME FROM all_tables WHERE TABLE_NAME LIKE '%BANK%'");
			
			while(rs.next())
				System.out.println(rs.getString(1) + "   " + rs.getString(2));
			
			//step5 close the connection object
			con.close();
		}
		
		catch (Exception ee) {
			System.out.println(ee);
		}
	
	}
	
}
