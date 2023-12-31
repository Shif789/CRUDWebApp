package in.ineuron.util;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcUtil {
    static {
        // Step 1. load and register the Driver //from jdbc 4.x version loading is
        // automated , codes for loading need to be written
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("jdbc driver loaded successfully...");
    }

    private JdbcUtil() {

    }

    public static Connection getJdbcConnection() throws SQLException, FileNotFoundException, IOException {
		
//		  String fileLoc="C:\\Users\\user-pc\\Desktop\\Self-Learning\\GitSession\\Servlet\\JDBCCrudWebApp3\\src\\in\\ineuron\\properties\\application2.properties";
//		  HikariConfig hikariConfig = new HikariConfig(fileLoc); HikariDataSource
//		  hikariDataSource = new HikariDataSource(hikariConfig); return
//		  hikariDataSource.getConnection();
		 
    	return physicalJdbcConnection();
    }

	public static Connection physicalJdbcConnection() throws FileNotFoundException, IOException, SQLException {
		// get connection data from properties file
    	String fileLoc="C:\\Users\\user-pc\\git\\repository3\\JDBCCrudWebApp3\\src\\in\\ineuron\\properties\\application.properties";
        FileInputStream fis = new FileInputStream(fileLoc);
        Properties properties = new Properties();
        properties.load(fis);

        // Step 2. Establish the connection
        String url = properties.getProperty("jdbcUrl");// if same jdk and databse is in the same machine then
        // host need not to be written. if db is stored in
        // default port, port no need not to be written
        String uName = properties.getProperty("userName");
        String pass = properties.getProperty("password");
        Connection connection = DriverManager.getConnection(url, uName, pass);
        System.out.println("connection established successfully...");
        return connection;
	}

    public static void cleanUp(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

}
