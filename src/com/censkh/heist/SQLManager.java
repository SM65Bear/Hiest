package com.censkh.heist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.censkh.heist.economy.EconomyAccount;

public class SQLManager {

	private static SQLManager instance;
	private Connection connection;
	
	private String dbDatabase = "James565";
	private String dbUsername = "James565";
	private String dbPassword = "5BhI5pPOsGuB";
	private String dbAddress = "193.35.58.210";

	public SQLManager() {
		instance = this;
		init();
	}

	public void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			setConnection(DriverManager.getConnection("jdbc:mysql://" + dbAddress, dbUsername, dbPassword));
		} catch (Exception e) {
			e.printStackTrace();
		}
		executeUpdate("USE " + getDbDatabase());
	}

	public static SQLManager getInstance() {
		return instance;
	}

	public String getDbUsername() {
		return dbUsername;
	}

	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public String getDbAddress() {
		return dbAddress;
	}

	public void setDbAddress(String dbAddress) {
		this.dbAddress = dbAddress;
	}

	public Connection getConnection() {
		try {
			if (connection == null) {
				init();
			} else if (connection.isClosed()) {
				init();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public String getDbDatabase() {
		return dbDatabase;
	}

	public void setDbDatabase(String dbDatabase) {
		this.dbDatabase = dbDatabase;
	}
	
	public void executeUpdate(String query) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void insertAccount(EconomyAccount account,int balance) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO economy (name,balance) VALUES (?,?)");
			ps.setString(1, account.getName());
			ps.setInt(2, balance);
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void updateAccount(EconomyAccount account,int balance) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("UPDATE economy SET balance=? WHERE name = ?");
			ps.setInt(1, balance);
			ps.setString(2, account.getName());
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public int getAccountBalance(EconomyAccount account) {
		int balance = 0;
		ResultSet rs = null;
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT `balance` FROM economy WHERE name = ?");
			ps.setString(1, account.getName());
			rs = ps.executeQuery();
			if (rs.next()) {
				balance = rs.getInt("balance");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return balance;
	}

	public boolean isAccountCreated(EconomyAccount account) {
		boolean e = false;
		ResultSet rs = null;
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT `id` FROM economy WHERE name = ?");
			ps.setString(1, account.getName());
			rs = ps.executeQuery();
			e = rs.next();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return e;
	}

}
