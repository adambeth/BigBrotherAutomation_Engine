/**
 *  The sqlDataAccess class is a handler class in order to be able the verify database entries and validate data quality
 *  Author: Juan-Claude Botha
 * https://confluence.clickatell.com/display/BIG/Sql+Data+Access+Layer
 */


package api.testUtilities.sqlDataAccessLayer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class sqlDataAccess{

    public static String verifyPostgreDb(String dataBaseTable, String columnName, String operator, String fieldValue)
    {
        Properties properties = loadPropertiesFile("config.properties");
        String dbValue = null;

        try{
            String connectionUrl = "jdbc:postgresql://pgdb.qa.za01.payd.co:5432/raas";
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(connectionUrl, "qa_appl_w_readyapi","api_rite" );
            Statement statement = connection.createStatement();
            ResultSet resultSet;

            resultSet = statement.executeQuery("SELECT * FROM " + dataBaseTable + " WHERE " + columnName + " " + operator + " '" + fieldValue + "' LIMIT 1 ;");
            while (resultSet.next()){
                dbValue = resultSet.getString(columnName);

            }

            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return dbValue;
    }

    public static String verifyPostgreCustomSql(String action, String columnName, String condition)
    {
        Properties properties = loadPropertiesFile("config.properties");
        String dbValue = null;

        try {
            String connectionUrl = properties.getProperty("CONNECTION_URL");
            Connection connection = DriverManager.getConnection(connectionUrl, properties.getProperty("RAAS_USER"), properties.getProperty("RAAS_PWD"));
            Statement statement = connection.createStatement();
            ResultSet resultSet;

            resultSet = statement.executeQuery(action + columnName + condition);
            while (resultSet.next()){
                dbValue = resultSet.getString(columnName);

            }

            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
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
