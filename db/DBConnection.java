package db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;



public class DBConnection {
	
	private static Connection connection;
	private static DBConnection con;
	
	private String url, driver, user, pass;
	
	private DBConnection(File config){
		try {
			InputStream input = new FileInputStream(config);
			
			Properties prop = new Properties();
			prop.load(input);
			
			driver = prop.getProperty("db.driver");
			url = prop.getProperty("db.url");
			user = prop.getProperty("db.user");
			pass = prop.getProperty("db.pass");
			
			
			Class.forName(driver);
			
			connection = DriverManager.getConnection(url, user, pass);
		}catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}catch(FileNotFoundException e){
			System.out.println("The File was not found.");
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Connection connect(File properties){
		if(connection == null){
			System.out.println("Creating new Connection...");
			con = new DBConnection(properties);
		}
		return connection;
	}
	
}
