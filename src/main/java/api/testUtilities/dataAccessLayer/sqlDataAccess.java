package api.testUtilities.dataAccessLayer;

import java.sql.*;

public class sqlDataAccess {

    public static String verifyDbValue(String dataBaseTable, String tableColumn, String fieldValue) {

        String dbValue = null;

        try {
            String connectionUrl = "";
            Connection conn = DriverManager.getConnection(connectionUrl, "", "");
            Statement stmt = conn.createStatement();
            ResultSet rs;

            StringBuilder query;
            rs = stmt.executeQuery("SELECT * FROM " + dataBaseTable + " where " + tableColumn + " = " + fieldValue + ";");
            while (rs.next()) {
                dbValue = rs.getString(tableColumn);

            }

            conn.close();


        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        return dbValue;

    }
}
