import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main (String[] args){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        Persona persona = new Persona();
        persona.setId(1);
        persona.setNombre("Luis");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(persona);
        entityManager.getTransaction().commit();

        entityManagerFactory.close();

    }

}
