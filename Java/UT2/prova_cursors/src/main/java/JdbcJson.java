import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcJson {
    static void main() {
        final String query = """
                SELECT d.DEPT_NO, d.DNOM, d.LOC, e.OFICI, e.EMP_NO, e.COGNOM, e.SALARI FROM DEPT AS d
                JOIN EMP AS e ON d.DEPT_NO = e.DEPT_NO ORDER BY d.DEPT_NO
                """;

        try (
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/negoci?user=test&password=test");
                Statement st = con.createStatement();
                ResultSet res = st.executeQuery(query);
        ){

            List<Departament> departaments = new ArrayList<>();
            while(res.next()) {
                int dept_no = res.getInt("DEPT_NO");
                String dnom = res.getString("DNOM");
                String loc = res.getString("LOC");
                String ofici = res.getString("OFICI");
                int emp_no = res.getInt("EMP_NO");
                String cognom = res.getString("COGNOM");
                double salari = res.getDouble("SALARI");

                Empleat empleat = new Empleat(emp_no, cognom, salari, ofici);
                Departament departament = null;

                boolean departamentExisteix = false;
                for (Departament dept : departaments) {
                    if (dept.getId() == dept_no) {
                        departament = dept;
                        departamentExisteix = true;
                    }
                }

                if (!departamentExisteix) departaments.add(departament = new Departament(dept_no, loc, new ArrayList<>()));

                departament.afegirEmpleat(empleat);
            }

            for (Departament dep : departaments) {
                IO.println(dep.getId());
            }
        } catch (SQLException e) {
            IO.println(e.getMessage());
            IO.println(e.getErrorCode());
            IO.println(e.getSQLState());
        }
    }


}
