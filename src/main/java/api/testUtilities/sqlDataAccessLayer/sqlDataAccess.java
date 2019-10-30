package api.testUtilities.sqlDataAccessLayer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class sqlDataAccess {

    public static String verifyPostgreDb(String dataBaseTable, String columnName, String operator, String fieldValue)
    {
        Properties properties = loadPropertiesFile("config.properties");
        String dbValue = null;

        try{
            String connectionUrl = properties.getProperty("CONNECTION_URL");
            Connection connection = DriverManager.getConnection(connectionUrl, properties.getProperty("RAAS_USER"), properties.getProperty("RAAS_PWD"));
            Statement statement = connection.createStatement();
            ResultSet resultSet;

            resultSet = statement.executeQuery("SELECT * FROM " + dataBaseTable + " WHERE " + columnName + " " + operator + " " + "('" + fieldValue + "')" + ";");
            while (resultSet.next()){
                dbValue = resultSet.getString(columnName);

            }

            connection.close();
        }
        catch (Exception e){
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        return dbValue;
    }

    public static Properties loadPropertiesFile(String filePath) {
        Properties prop = new Properties();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(filePath);
            prop.load(inputStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + filePath);
        }

        return prop;

    }

}
