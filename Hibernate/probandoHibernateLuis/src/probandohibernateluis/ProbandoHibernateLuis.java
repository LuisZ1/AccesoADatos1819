/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probandohibernateluis;

import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author lzumarraga
 */
public class ProbandoHibernateLuis {

    private static SessionFactory sessionFactory = null;
    
    public static void main(String[] args) {
        Session session = null;
        try {
            try {
                sessionFactory = PersonFactory.getSessionFactory();
                session = sessionFactory.openSession();
 
                System.out.println("Insertando registro");
                Transaction tx = session.beginTransaction();
                
                //Creando un Objeto
                Personas fulanito = new Personas();
                fulanito.setApellidosPersona("Perico");
                fulanito.setNombrePersona("Tilla");
                fulanito.setFechaNacimiento(new Date(1995,10,14));
                fulanito.setTelefono("632541263");
                fulanito.setDireccion("Calle falsa 2");
                fulanito.setIddepartamento(3);
                
                Personas fulanito1 = new Personas("Alfredo", "AoC", new Date(1995,10,14), "965823154", "Alameda", 2);
                Personas fulanito2 = new Personas("Ernesto", "Sevilla", new Date(1996,3,25), "965823154", "Visual", 1);
                Personas fulanito3 = new Personas("Jolsensei", "Antonio", new Date(2001,10,14), "632512365", "Ratón", 2);
                Personas fulanito4 = new Personas("Rafalito", "Mateos", new Date(1990,4,2), "985563254", "Entorno", 3);
                
                //Guardando
                session.save(fulanito1);
                session.save(fulanito2);
                session.save(fulanito3);
                session.save(fulanito4);
                tx.commit();
                
                System.out.println("Finalizado...");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } finally {
            session.close();
        }
        
    }
    
}
