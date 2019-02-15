/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probandohibernateconle;

import java.util.ArrayList;
import modelos.Criaturita;
import modelos.CriaturitaConRegalos;
import modelos.RegaloParaCriaturitaConRegalos;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
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
    
    public static void quitarRegaloACriaturita(Session s, byte idC, byte idR){
        System.out.println("En construccion, id recibido: "+idC+", "+idR);
    }
    
    public static void asignarRegaloACriaturita(Session s, byte idC, byte idR){
        System.out.println("En construccion, id recibido: "+idC+", "+idR);
    }
    
    public static void crearCriaturita(){
        System.out.println("En construccion");
    }
    
    public static void crearRegalo(){
        System.out.println("En construccion");
    }
    
    public static void borrarRegalo(){
        System.out.println("En construccion");
    }
    
    public static void borrarCriaturitayRegalos(){
        System.out.println("En construccion");
    }
    
}