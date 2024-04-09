import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    // Conexion con workbench mysql, es necesario tener xampp instalado y tener el
    // puerto 3306 corriendo para que esto funcione,
    public static void main(String[] args) throws Exception {
        try {
            Singleton singleton = Singleton.getInstance();
            Singleton singleton2 = Singleton.getInstance();
            try (Statement statement = singleton.getStatement()) {
                System.out.println(singleton);
                System.out.println(singleton2);
                Class.forName("com.mysql.cj.jdbc.Driver");
                // El nombre de la base de datos debe cambiar
                // Lo otro es el nombre del usuario y la contraseña (root y contraseña vacía en
                // este caso)
                ResultSet resultSet = statement.executeQuery("select nombre, apellido from data");
                while (resultSet.next()) {
                    System.out.println(
                            "Primer nombre " + resultSet.getString(1) + " Segundo nombre " + resultSet.getString(2));
                }
                statement.getConnection().close();
            } catch (Exception e) {
                System.out.println("Error en la conexion " + e);
            }
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            e.printStackTrace(System.err);
        }
    }
}
