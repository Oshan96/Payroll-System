package io.github.oshan96.payrollsystem.db.connection;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author oshan
 */
public class DBConnection {
    private static DBConnection dbConnection = null;
    private Connection connection = null;

    private DBConnection() throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.jdbc.Driver");
        Properties dbProperties = new Properties();
        File configFile = new File("config/dbconfig.properties");
        FileReader reader = new FileReader(configFile);
        dbProperties.load(reader);
        String strCon = String.format(
                "jdbc:mysql://%:%/%",
                dbProperties.getProperty("host"),
                dbProperties.getProperty("port"),
                dbProperties.getProperty("db")
        );
        connection = DriverManager.getConnection(
                strCon,
                dbProperties.getProperty("user"),
                dbProperties.getProperty("password")
        );
    }

    public static DBConnection getInstance() throws ClassNotFoundException, SQLException, IOException {
        if(dbConnection == null) {
            dbConnection = new DBConnection();
        }

        return dbConnection;
    }

    public Connection getConnection() {
        return this.connection;
    }
}
