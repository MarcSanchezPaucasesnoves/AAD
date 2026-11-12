import java.sql.*;

public class Procediments {
    static void main() {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/negoci", "test", "test");
                Statement st = conn.createStatement();
                CallableStatement call = conn.prepareCall("call empleatsAndSalariMitjaEMP(?,?,?)");
                ResultSet res = st.executeQuery("SELECT * FROM DEPT");
        ){
            while(res.next()) {
                call.setInt(1, res.getInt("DEPT_NO"));
                call.registerOutParameter(2, Types.INTEGER);
                call.registerOutParameter(3, Types.DECIMAL);

                call.execute();

                int n_empleats = call.getInt(2);
                double salari_mitja = call.getDouble(3);

                IO.println("Nombre empleats: " + n_empleats + "  Salari mitjà: " + salari_mitja);
            }


        } catch (SQLException e) {
            IO.println(e.getMessage());
        }
    }


}
