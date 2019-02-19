/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probandohibernateconle;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import modelos.Criaturita;
import modelos.CriaturitaConRegalos;
import modelos.RegaloParaCriaturitaConRegalos;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author lzumarraga
 */
public class gestor {

    public static void recuperaCriaturitaConRegalos(Session s, byte id){

        CriaturitaConRegalos nene;

        nene = (CriaturitaConRegalos)s.get(CriaturitaConRegalos.class, id);

        System.out.println();
        System.out.println(nene.toString());
        System.out.println("Regalos");
        int cont = 1;
        for(RegaloParaCriaturitaConRegalos surprise:nene.getRegalitos()){
            System.out.println(cont+" -> "+surprise.toString());
            cont++;
        }
    }

    public static void getTodasCriaturitas(Session s){

        Query miQuery = s.createQuery("from Criaturita");
        ArrayList<Criaturita> listado = (ArrayList<Criaturita>) miQuery.list();

        for(Criaturita c:listado){
            System.out.println(c.toString());
        }
    }

    public static void getTodosRegalos(Session s){

        Query miQuery = s.createQuery("from RegaloParaCriaturitaConRegalos");
        ArrayList<RegaloParaCriaturitaConRegalos> listado = (ArrayList<RegaloParaCriaturitaConRegalos>) miQuery.list();

        for(RegaloParaCriaturitaConRegalos c:listado){
            System.out.println(c.toString());
        }
    }

    public static void quitarRegaloACriaturita(Session s, byte idC){

        CriaturitaConRegalos criatura;
        ArrayList<RegaloParaCriaturitaConRegalos> listaRegalos = new ArrayList<RegaloParaCriaturitaConRegalos>();
        Scanner teclado = new Scanner(System.in);

        criatura = (CriaturitaConRegalos)s.get(CriaturitaConRegalos.class, idC);

        int cont = 1;
        for( RegaloParaCriaturitaConRegalos surprise: criatura.getRegalitos() ){
            listaRegalos.add(surprise);
            cont++;
            System.out.println(cont+") "+surprise.toString());
        }

        System.out.println("num de regalo quiere quitar?");
        int regaloQuitar = teclado.nextInt();

        Transaction tran = s.beginTransaction();

        listaRegalos.get(regaloQuitar).setPropietario(null);
        criatura.EliminarRegalo(listaRegalos.get(regaloQuitar));

        tran.commit();
    }

    public static void asignarRegaloACriaturita(Session s, byte idC, byte idR){

        Transaction tran = s.beginTransaction();

        Query miQuery = s.createQuery("FROM CriaturitaConRegalos WHERE id="+idC);
        CriaturitaConRegalos criaturita = (CriaturitaConRegalos)miQuery.uniqueResult();

        miQuery = s.createQuery("FROM RegaloParaCriaturitaConRegalos WHERE id= :idR");
        miQuery.setInteger("idR", idR);
        RegaloParaCriaturitaConRegalos regalito = (RegaloParaCriaturitaConRegalos)miQuery.uniqueResult();

        criaturita.getRegalitos().add(regalito);
        regalito.setPropietario(criaturita);
        tran.commit();
    }

    public static void crearCriaturita(Session s){

        Transaction tran = s.beginTransaction();
        Scanner teclado = new Scanner(System.in);
        Criaturita miCriaturita = new Criaturita();

        //System.out.println("En construccion");
        System.out.println("Introduzca el nombre: ");
        miCriaturita.setNombre(teclado.next());

        s.save(s);

        tran.commit();
    }

    public static void crearRegalo(Session s){
        Transaction tran = s.beginTransaction();
        Scanner teclado = new Scanner(System.in);

        RegaloParaCriaturitaConRegalos regalito = new RegaloParaCriaturitaConRegalos();
        regalito.setDenominacion(teclado.next());
        regalito.setAlto(teclado.nextInt());
        regalito.setAncho(teclado.nextInt());
        regalito.setEdadMinima(teclado.nextInt());
        regalito.setLargo(teclado.nextInt());
        regalito.setPrecio(teclado.nextBigDecimal());
        regalito.setTipo(teclado.next().charAt(0));

        tran.commit();
    }

    public static void borrarRegalo(Session s){
        Scanner teclado = new Scanner(System.in);

        getTodosRegalos(s);
        int idR = teclado.nextInt();

        Transaction tran = s.beginTransaction();

        RegaloParaCriaturitaConRegalos regalito = (RegaloParaCriaturitaConRegalos) s.get(RegaloParaCriaturitaConRegalos.class, idR);
        s.delete(regalito);

        tran.commit();
    }

    public static void borrarCriaturitayRegalos(){
        System.out.println("En construccion");
    }
}
