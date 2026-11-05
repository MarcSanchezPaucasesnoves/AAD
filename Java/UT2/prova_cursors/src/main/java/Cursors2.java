import java.sql.*;
import java.util.Scanner;

public class Cursors2 {

    private static final String URL = "jdbc:mysql://localhost:3306/negoci?user=test&password=test";
    private static final String USER = "test";
    private static final String PASSWORD = "test";

    public static void startCursors2() {
        String query = "SELECT CLIENT_COD, NOM, ADRECA, TELEFON FROM CLIENT ORDER BY CLIENT_COD ASC";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery(query);
             Scanner scanner = new Scanner(System.in)) {

            if (!rs.next()) {
                System.out.println("La taula de clients està buida.");
                return;
            }

            rs.first();
            mostrarClient(rs);

            boolean sortir = false;
            while (!sortir) {
                int opcio = -1;
                mostrarMenu();
                System.out.print("Tria una opció: ");

                try {
                    opcio = Integer.parseInt(scanner.nextLine().trim().toLowerCase());
                } catch (NumberFormatException e) {

                }


                switch (opcio) {
                    case 1:
                        rs.first();
                        mostrarClient(rs);
                        break;

                    case 2:
                        if (rs.isLast()) {
                            System.out.println("\n[ERROR] Ja ets al darrer client. No pots anar al següent.");
                        } else {
                            rs.next();
                            mostrarClient(rs);
                        }
                        break;

                    case 3:
                        if (rs.isBeforeFirst() || rs.isFirst()) {
                            System.out.println("\n[ERROR] Ja ets al primer client. No pots anar a l'anterior.");
                        } else {
                            rs.previous();
                            mostrarClient(rs);
                        }
                        break;

                    case 4:
                        rs.last();
                        mostrarClient(rs);
                        break;

                    case 5:
                        sortir = true;
                        System.out.println("Surtint del programa...");
                        break;

                    default:
                        System.out.println("\n[ERROR] Opció no vàlida. Intenta-ho de nou.");
                        break;
                }
            }

        } catch (SQLException e) {
            System.err.println("Error de Base de Dades: " + e.getMessage());
        }
    }

    private static void mostrarClient(ResultSet rs) throws SQLException {
        System.out.println("\n================ CLIENT ACTUAL ================");
        System.out.println("ID:       " + rs.getInt("CLIENT_COD"));
        System.out.println("Nom:      " + rs.getString("NOM"));
        System.out.println("Adreça:   " + rs.getString("ADRECA"));
        System.out.println("Telèfon:  " + (rs.getString("TELEFON") != null ? rs.getString("TELEFON") : "N/A"));
        System.out.println("===============================================");
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú de Navegació ---");
        System.out.println("1- Primer");
        System.out.println("2- Següent");
        System.out.println("3- Anterior");
        System.out.println("4- Darrer");
        System.out.println("5- Sortir");
    }
}
