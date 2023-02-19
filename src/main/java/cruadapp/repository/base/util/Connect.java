package cruadapp.repository.base.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Connect {
    static final private String DATABASE_URL = Connect.getUrl();
    static final private String USER = Connect.getUser();
    static final private String PASSWORD = Connect.getPassword();
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
    private static String getUrl(){
        String url = "";
        try (InputStream input = new FileInputStream("liquibase.properties")) {

            Properties prop = new Properties();

            prop.load(input);

            url = prop.getProperty("url");

        } catch (IOException ex) {
            ex.printStackTrace();
        }finally {
            return url;
        }
    }
    private static String getUser(){
        String username = "";
        try (InputStream input = new FileInputStream("liquibase.properties")) {

            Properties prop = new Properties();

            prop.load(input);

            username = prop.getProperty("username");

        } catch (IOException ex) {
            ex.printStackTrace();
        }finally {
            return username;
        }
    }

    private static String getPassword(){
        String password = "";
        try (InputStream input = new FileInputStream("liquibase.properties")) {

            Properties prop = new Properties();

            prop.load(input);

            password = prop.getProperty("password");

        } catch (IOException ex) {
            ex.printStackTrace();
        }finally {
            return password;
        }
    }


}
