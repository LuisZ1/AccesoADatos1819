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
import org.hibernate.SessionFactory;
import probandohibernate.SesionFactory;

/**
 *
 * @author lzumarraga
 */
public class Main {
    
    public static void main(String[] args){
        System.out.println("Hola caracola");
        
        
        
        SessionFactory instancia = SesionFactory.getSessionFactory();
        Session ses = instancia.openSession(); 
        
        /*
        System.out.println("\n TODAS LAS CRIATURITAS ===========================");
        gestor.getTodasCriaturitas(ses);
        
        System.out.println("\n TODOS LOS REGALOS ===============================");
        gestor.getTodosRegalos(ses);
        
        System.out.println("\n CRIATURITA Y SUS REGALOS ========================");
        byte idC = 2;
        gestor.recuperaCriaturitaConRegalos (ses,idC);
        */
        System.out.println("\n QUITAR REGALO A CRIATURITA ======================");
        
        System.out.println("\n ASIGNAR REGALO A CRIATURITA =====================");
        System.out.println("\n CREAR CRIATURITA ================================");
        System.out.println("\n CREAR REGALO ====================================");
        System.out.println("\n BORRAR REGALO ===================================");
        System.out.println("\n BORRAR CRIATURITA Y SUS REGALOS =================");
        
        ses.close();
        
    }
    
}
