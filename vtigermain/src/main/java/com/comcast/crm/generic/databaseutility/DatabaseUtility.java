package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection conn=null;
	public void getDbConnection(String url,String username,String password) throws SQLException {
		//step1:load/register the Database
		try {
		Driver driverreff=new Driver();
		DriverManager.registerDriver(driverreff);
		conn=DriverManager.getConnection(url, username, password);
		}catch(Exception e) {}
	}
	public void getDbConnection() throws SQLException {
		//step1:load/register the Database
		try {
		Driver driverreff=new Driver();
		DriverManager.registerDriver(driverreff);
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger", "root", "root");
		}catch(Exception e) {}
	}
	public void CloseDbConnection() throws SQLException {
		conn.close();
	}
	public int executeNonSelectQuery(String query) throws SQLException {
		int result=0;
		try {
			Statement stat=conn.createStatement();
			 result=stat.executeUpdate(query);
			
		}catch(Exception e) {}
	return result;
	}
	public ResultSet executeSelectQuery(String query) {
		ResultSet resultset=null;
		try {
			Statement stat=conn.createStatement();
			resultset=stat.executeQuery(query);
		} catch (SQLException e) {
			
		}
	return resultset;
	}
}
