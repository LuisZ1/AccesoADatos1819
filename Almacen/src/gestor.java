import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class gestor {

    gestorConexion GestorConexion = new gestorConexion();
    Connection conexion = GestorConexion.getConexion();

    public void MostrarEnvios(Statement sentencia){

        try {

            String query = "SELECT * FROM Envios";

            ResultSet res = sentencia.executeQuery(query);

            while (res.next()){

                System.out.println("ID: " + res.getInt(1) + " Contenedores: " + res.getString(2)
                        + " FechaCreacion: " + res.getDate(3) + " FechaAsignacion: " + res.getDate(4));
            }



        }catch (SQLException e){

            e.printStackTrace();

        }

    }

    public void PedididosSinAsignar(Statement sentencia){

        try {

            String query = "SELECT * FROM fnPedidosSinAsignar()";

            ResultSet res = sentencia.executeQuery(query);

            while (res.next()){

                System.out.println("ID: " + res.getInt(1) + " Contenedores: " + res.getString(2)
                        + " FechaCreacion: " + res.getDate(3) + " FechaAsignacion: " + res.getDate(4));
            }



        }catch (SQLException e){

            e.printStackTrace();

        }

    }

    public ResultSet PedidoSinAsignar(int id,Statement sentencia){

        ResultSet res = null;

        try {

            String query = "SELECT * FROM BuscarEnvioSinAsignar(" + id + ")";
            res = sentencia.executeQuery(query);


            while (res.next()){

                System.out.println("ID: " + res.getInt(1) + " Contenedores: " + res.getString(2)
                        + " FechaCreacion: " + res.getDate(3) + " FechaAsignacion: " + res.getDate(4));
            }

        }catch (SQLException e){

            e.printStackTrace();

        }

        return res;

    }

    public void AlmacenConCapacidadLibre(Statement sentencia,int id){


        try {

            //Utilizar como ejemplos.
            String query = "SELECT * FROM MostrarAlmacenConCapacidadLibre(" + id + ")";
            ResultSet res = sentencia.executeQuery(query);
            while (res.next()){

                System.out.println("ID: " + res.getInt(1) + " Capacidad:  " + res.getInt(2)
                        + " Usado: " + res.getInt(3) + " Disponible: " + res.getInt(4));
            }


        }catch (SQLException e){

            e.printStackTrace();

        }


    }

    public int ComprobarAlmacenes(Statement sentencia,int id,int capacidad){

        int ret = 0;
        try {
            String query = "exec ComprobarAlmacenes "+id+capacidad;
            System.out.println(query);

            ResultSet res = sentencia.executeQuery(query);

            ret = res.getInt(1);

        }catch (SQLException e){

            e.printStackTrace();

        }

        return ret;

    }

    public void ActualizarPedido(Connection conex, int id){
        //ToDo

    }

    public int AlmacenMasCercano(Connection conex,int idEnvio,int idAlmacenPrefe){

        int ret = 0;
        CallableStatement senllamable;
        try {

            //Utilizar como ejemplos.
            String miOrden = "exec BuscarAlmacenMasCercano ? ,? ,?";
            senllamable = conex.prepareCall(miOrden);
            senllamable.setInt(1,idEnvio);
            senllamable.setInt(2,idAlmacenPrefe);
            senllamable.registerOutParameter(3, Types.INTEGER);
            senllamable.executeUpdate();
            ret = senllamable.getInt(3);

        }catch (SQLException e){

            e.printStackTrace();

        }

        return ret;


    }

    public int ObtenerAlmacenPreferido(Connection conex,int idEnvio){

        int ret = 0;
            //TODO
        return ret;

    }

    public void InsertPedido(Connection conex,int idEnvio,int IdAlmacen){
        //TODO
    }


    public int ComprobarAlmacenCercano(Connection conex,int id,int almacenCercano){

        int ret = 0;
        //TODO
        return ret;
    }

    public boolean ValidarEnvio(ArrayList<Integer> Ids,int envio){

        boolean ret = false;
        //TODO
        return ret;

    }


}
