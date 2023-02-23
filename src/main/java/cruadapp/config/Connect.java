package cruadapp.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Connect {
    static final private String DATABASE_URL = Connect.getPropertiesData("url");
    static final private String USER = Connect.getPropertiesData("username");
    static final private String PASSWORD = Connect.getPropertiesData("password");
    static final private String DRIVER = "com.mysql.cj.jdbc.Driver";


    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            return connection;
        }
    }


    private static String getPropertiesData(String nameProp){
        String propData = "";
        try (InputStream input = new FileInputStream("liquibase.properties")) {

            Properties prop = new Properties();

            prop.load(input);

            propData = prop.getProperty(nameProp);


        } catch (IOException ex) {
            ex.printStackTrace();
        }finally {
            return propData;
        }
    }


}
