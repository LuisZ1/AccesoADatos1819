import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class gestorConexion{

    private String sourceURL = "jdbc:sqlserver://localhost";
    private String usuario = "sa";
    private String password = "mitesoro";
    private String baseDeDatos = "Ejemplos";
    private Connection conexion;

    public void abrirConexion(){
        try {
            this.conexion = DriverManager.getConnection(sourceURL, usuario, password);
            this.conexion.setCatalog(baseDeDatos);
            System.out.println("Conect");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cerrarConexion(){
        try {
            this.conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConexion(){
        return conexion;
    }

}
