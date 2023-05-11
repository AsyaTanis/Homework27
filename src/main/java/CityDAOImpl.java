import javax.persistence.*;
import java.util.Collection;

public class CityDAOImpl implements CityDAO{
    private final String user = "postgres";
    private final String password = "qwerty";
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    @Override
    public Collection<City> getAllCity() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createNativeQuery("SELECT *FROM city",City.class);
        return query.getResultList();
    }

    @Override
    public City getCityById(int id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        City city = entityManager.find(City.class,id);
        return city;

    }

    @Override
    public void createCity(City city) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(city);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();


    }

    @Override
    public void updateCity(City city) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.merge(city);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void deleteCity(int id, City city) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        city = entityManager.find(City.class,id );
        entityManager.remove(city);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

}
