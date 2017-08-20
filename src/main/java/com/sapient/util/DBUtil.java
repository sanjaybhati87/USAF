/**
 * 
 */
package com.sapient.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author ssi248
 *
 */
public class DBUtil {

	
//	private Config config;
	// To do - Put in config file
	private static Connection con;
	private static final String Driver = "oracle.jdbc.driver.OracleDriver";
	private static final String ConnectionString = "jdbc:oracle:thin:QA_Automation_Mobile/QA_Automation_Mobile145@10.105.36.139:1525:SEPQA01";
	private static final String user = "username";
	private static final String pwd = "password";

	static {
		try {
			Class.forName(Driver);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	
	public static Connection initDatabaseProvider() throws SQLException
	{
		if(con==null || con.isClosed())
		{
			con= DriverManager.getConnection(ConnectionString);
		}
		return con;
	}

	
	public static boolean isConnectedToDB() throws SQLException
	{
		boolean IsConncted=false;
		if(!con.isClosed()){
			IsConncted=true;
		}
		return IsConncted;
	}

	
	public static ResultSet performSelectQuery(String sQuery) throws SQLException
	{
		Connection con = initDatabaseProvider();
		ResultSet rs;
		PreparedStatement st = con.prepareStatement(sQuery);
		rs = st.executeQuery();
		return rs;
	}

	
	public static void performUpdateQuery(String query) throws SQLException {
		Connection con = initDatabaseProvider();
		//ResultSet rs;
		PreparedStatement st = con.prepareStatement(query);
		st.executeUpdate();
	}

	
	public static void closeConnection() 
	{
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {

			}
		}
	}



}
