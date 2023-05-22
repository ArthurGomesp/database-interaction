package Application;
import DataBase.Db;
import DataBase.exceptions.DbException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class main {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = Db.getConnetion();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM  department");

            while (rs.next()){
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            Db.closeStatement(st);
            Db.closeResultSet(rs);
            Db.closeConnetion();
        }

    }
}
