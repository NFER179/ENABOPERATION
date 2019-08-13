import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {

		/*String connectionUrl = "jdbc:sqlserver://192.168.56.101:1433;databaseName=DAYSGESTIONS;user=SA;password=Nicol@s1";

		try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
			String SQL = "SELECT * FROM FND_TABLE";
			ResultSet rs = stmt.executeQuery(SQL);

			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				System.out.println(rs.getString("table_name") + " | " + rs.getString("title_en"));
			}
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fnd_schema", "root", "root");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM fnd_users_tbl");
			while(rs.next()) {
				System.out.println(rs.getString(1) + "|\t" + rs.getString(2) + "|\t" + rs.getString(3) + "|\t" + rs.getString(4) + "|\t" + rs.getString(5) + "|\t" + rs.getString(6) + "|\t");
			}
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("---------test");
	}
}
