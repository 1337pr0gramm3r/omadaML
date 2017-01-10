package smartSQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {
	public static void main(String[] args)
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
	try
	{
		// Main code here
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String connectionUrl = "jdbc:mysql://127.0.0.1:3306/smartHotel";
		String connectionUser = "root";
		String connectionPassword = "test123";
		conn = DriverManager.getConnection(connectionUrl, connectionUser,
		connectionPassword);
		stmt = conn.createStatement();
		rs = stmt.executeQuery("SELECT * FROM test");
		while (rs.next())
			
			{
			
		    String id = rs.getString("id");
			
			String firstName = rs.getString("name");
			
			
			System.out.println("ID: " + id + ", First Name: " + firstName);
			}
	}
	catch (Exception e)
	{
			e.printStackTrace();
	}
	finally
	{
		// Finally code here
	}
	}
}
