package Application;

import DataBase.Db;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class app {
    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        Connection conn = null;
        PreparedStatement st = null;
        try{
            conn = Db.getConnetion();

            st = conn.prepareStatement(
                    "INSERT INTO seller " +
                            "(Name, Email, BirthDate, BaseSalary, DepartmentId) " +
                            "VALUES " +
                            "(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            st.setString(1, "Arthur Gomes");
            st.setString(2, "ag0134486@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("24/02/2005").getTime()));
            st.setDouble(4, 3500.0);
            st.setInt(5, 4);


            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("Done! Id: " + id);
                }
            }
            else {
                System.out.println("No rows affected!");
            }

        }   catch (SQLException e){
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            Db.closeStatement(st);
            Db.closeConnetion();
        }

    }
}
