package database;

import com.helper.XmlReader;

/* comments */
public class DataBaseManager {
	
	private String _vIp = "${ip}";
	private String _vDataBaseName = "${database}"; 
	private String _vUser = "${user}";
	private String _vPassword = "${password}";
	private String url = "jdbc:sqlserver://" + this._vIp + 
			":1433;databaseName=" + this._vDataBaseName + 
			";user=" + this._vUser + 
			";password=" + this._vPassword;
	private String _ip, _databasename, _user, _pasword;
	
	public DataBaseManager(String mensaje) {
		XmlReader r = new XmlReader();
		//this._ip = 
	}
	
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
}
