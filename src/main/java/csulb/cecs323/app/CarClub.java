package csulb.cecs323.app;

// Import all of the entity classes that we have written for this application.
import csulb.cecs323.model.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CarClub {
   /**
    * You will likely need the entityManager in a great many functions throughout
    * your application. Rather than make this a global variable, we will make it an
    * instance variable within the CarClub class, and create an instance of CarClub
    * in the main.
    */
   private EntityManager entityManager;
   private static final Logger LOGGER = Logger.getLogger(CarClub.class.getName());

   public CarClub(EntityManager manager) {
      this.entityManager = manager;
   }

   public static void main(String[] args) {
      LOGGER.fine("Creating EntityManagerFactory and EntityManager");
      EntityManagerFactory factory = Persistence.createEntityManagerFactory("CarClub");
      EntityManager manager = factory.createEntityManager();
      // Create an instance of CarClub and store our new EntityManager as an instance
      // variable.
      CarClub carclub = new CarClub(manager);

      // Any changes to the database need to be done within a transaction.
      // See: https://en.wikibooks.org/wiki/Java_Persistence/Transactions

      LOGGER.fine("Begin of Transaction");
      EntityTransaction tx = manager.getTransaction();

      tx.begin();
      // List of owners that I want to persist. I could just as easily done this with
      // the seed-data.sql
      List<Owners> owners = new ArrayList<Owners>();
      List<Cars> cars = new ArrayList<Cars>();
      // Load up my List with the Entities that I want to persist. Note, this does not
      // put them
      // into the database.
      owners.add(new Owners("Reese", "Mike", "714-892-5544"));
      owners.add(new Owners("Leck", "Carl", "714-321-3729"));
      owners.add(new Owners("Guitierez", "Luis", "562-982-2899"));
      carclub.createEntity(owners);
      // Create the list of owners in the database.
      cars.add(new Cars("123", "Mike", "HONDA-CIVIC"));
      cars.add(new Cars("321", "Carl", "TOYOTA-COROLA"));
      carclub.createEntity(cars);
      // Create the list of Cras in the database.
      // Commit the changes so that the new data persists and is visible to other
      // users.
      tx.commit();
      LOGGER.fine("End of Transaction");

   } // End of the main method

   public <E> void createEntity(List<E> entities) {
      for (E next : entities) {
         LOGGER.info("Persisting: " + next);
         // Use the CarClub entityManager instance variable to get our EntityManager.
         this.entityManager.persist(next);
      }
      for (E next : entities) {
         LOGGER.info("Persisted object after flush (non-null id): " + next);
      }
   } // End of createEntity member method

   public auto_body_styles getStyle(String name) {
      // Run the native query that we defined in the auto_body_styles entity to find
      // the right style.
      List<auto_body_styles> styles = this.entityManager.createNamedQuery("ReturnAutoBodyStyle", auto_body_styles.class)
            .setParameter(1, name).getResultList();
      if (styles.size() == 0) {
         // Invalid style name passed in.
         return null;
      } else {
         // Return the style object that they asked for.
         return styles.get(0);
      }
   }// End of the getStyle method
} // End of CarClub class