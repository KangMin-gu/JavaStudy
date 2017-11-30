package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String dbid = "scott";
	private static final String dbpw = "tiger";
	

	//jdbc 占쎈굡占쎌뵬占쎌뵠甕곤옙 嚥≪뮆逾?
	static {
		try{
			Class.forName(driver); 
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private ConnectionManager() {}
		
	//Connection 占쎄문占쎄쉐占쎈릭占쎈연 ?귐뗪쉘
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, dbid, dbpw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//Connection 占쎈염野껓옙 ?ル굝利?
	public static void close(Connection con) {
		try {
			if (con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
