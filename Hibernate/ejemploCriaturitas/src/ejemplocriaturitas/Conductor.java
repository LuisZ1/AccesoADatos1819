package ejemplocriaturitas;

import ejemplocriaturitas.HibernateUtil;
import ejemplocriaturitas.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Leo
 */
public class Conductor {
    /*private static void recuperaRegaloConCriaturita(Session s, int id){
 
        Regalos surprise; //cambiar a regalocriaturitaconregalo

        surprise = (Regalos)s.get(Regalos.class, id);
        System.out.println(surprise.toString()+" Propietari-> "+surprise.getCriaturitas().toString());
    }*/
    private static void recuperaCriaturitaConRegalos(Session s, byte id){
 
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
    public static void main(String[] args) {

        System.out.println("======================================================");
        
        SessionFactory instancia = SesionFactory.getSessionFactory();
        Session ses = instancia.openSession(); 
            int idR = 6;
            byte idC = 2;
            //recuperaRegaloConCriaturita(ses,idR);
            System.out.println("======================================================");
            recuperaCriaturitaConRegalos (ses,idC);
            ses.close();
        
        
    }
}
