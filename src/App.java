import java.sql.*;

public class App {
    // Conexion con workbench mysql, es necesario tener xampp instalado y tener el
    // puerto 3306 corriendo para que esto funcione,
    public static void main(String[] args) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // El nombre de la base de datos debe cambiar |
            // v
            // Lo otro es el nombre del usuario y la contraseña (root y contraseña vacía en
            // este caso)
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebaSingleton", "root",
                    "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select nombre from data");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("Error en la conexion " + e);
        }
    }
}
