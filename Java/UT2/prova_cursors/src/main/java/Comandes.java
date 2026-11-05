import java.sql.*;

public class Comandes {
    static void main() {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "test", "test");
                CallableStatement call = conn.prepareCall("call info_comandes(?,?,?)");

                ){
            call.setInt(1, 10105);
            call.registerOutParameter(2, Types.INTEGER);
            call.registerOutParameter(3, Types.DECIMAL);

            call.execute();

            int n_lines = call.getInt("n_lines");
            double total = call.getDouble("total");

            IO.println("lines: " + n_lines + "  total: " + total);
        } catch (SQLException e) {
            IO.println(e.getMessage());
        }

    }
}
