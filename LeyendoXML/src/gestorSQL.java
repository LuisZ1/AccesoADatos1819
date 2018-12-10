import java.sql.Connection;

public class gestorSQL {

    gestorConexion gestConexion = new gestorConexion();
    Connection conexion = gestConexion.getConexion();

}
