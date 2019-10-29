package api.testUtilities.sqlDataAccessLayer;

import java.sql.*;

public class sqlDataAccess {

    public static String verifyRaasTransaction(String dataBaseColumn, String columnName, String fieldValue)
    {
        String dbValue = null;

        try{
            String connectionUrl = "";
            Connection conn = DriverManager.getConnection(connectionUrl, "", "");
            Statement stmt = conn.createStatement();
            ResultSet rs;

            StringBuilder query;
            rs = stmt.executeQuery("SELECT * FROM " + dataBaseColumn + " where " + columnName + " = " + fieldValue + ";");
            while (rs.next()){
                dbValue = rs.getString(columnName);
            }

            conn.close();
        }
        catch (Exception e){
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        return dbValue;
    }

}
