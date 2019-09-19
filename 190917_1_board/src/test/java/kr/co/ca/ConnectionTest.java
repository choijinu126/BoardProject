package kr.co.ca;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class ConnectionTest {
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USERNAME = "board_jwchoi";
	private final String PASSWORD = "4642";
	
	
	@Test
	public void testConnection() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		try {
			conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
