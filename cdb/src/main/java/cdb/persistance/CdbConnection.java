package cdb.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CdbConnection {
	
	private final static String URL = "jdbc:mysql://localhost:3306/computer-database-db?zeroDateTimeBehavior=convertToNull";
	private final static String LOGIN= "admincdb";
	private final static String PASSWORD = "qwerty1234";
	private static  Connection con = null;
	// private static CdbConnection instance;
	
	/*
	public static CdbConnection getInstance() {
		if(instance == null) {
			instance = new CdbConnection();
		}
		return instance;
	}
	*/
	@Autowired
	public CdbConnection() {
		try {
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Etape 2 : récupération de la connexion
			con = DriverManager.getConnection(URL, LOGIN, PASSWORD); // On instancie un objet connection
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	

	public Connection getConnection() throws SQLException {
		if(con == null || con.isClosed()) {
			con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
		}
		return con;
	}
}
