package DAO;

import com.enigma.config.HibernateConfig;
import com.enigma.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductDAOTest {

    private static SessionFactory sessionFactory;
    private Session session;

    @BeforeAll
    static void setUp() {
        sessionFactory = HibernateConfig.getSessionFactory();
        System.out.println("SessionFactory Created");
    }

    @AfterAll
    static void tearDown() {
        if (sessionFactory != null) sessionFactory.close();
        System.out.println("SessionFactory destroyed");
    }

    @Test
    @Order(1)
    void testCreate() {
        session.beginTransaction();

        Product product = new Product("Potato Chips", 10000L, 10, Date.valueOf(LocalDate.now()), null);
        Long id = (Long) session.save(product);
        session.getTransaction().commit();

        Assertions.assertTrue(id > 0);
    }

    @Test
    @Order(2)
    void testUpdate() {
        Long id = 47L;
        Product product = new Product(id, "Keripik Kentang", 5000L, 10, Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()));

        session.beginTransaction();
        session.update(product);
        session.getTransaction().commit();

        Product updateProduct = session.find(Product.class, id);

        Assertions.assertEquals("Keripik Kentang", updateProduct.getName());
    }

    @Order(3)
    @Test
    void testGet() {
        Long id = 47L;

        Product product = session.get(Product.class, id);

        Assertions.assertEquals("Keripik Kentang", product.getName());
    }

    @Order(4)
    @Test
    void testList() {
        Query<Product> query = session.createQuery("FROM Product", Product.class);
        List<Product> resultList = query.getResultList();

        Assertions.assertFalse(resultList.isEmpty());
    }

    @Order(5)
    @Test
    void testDelete() {
        Long id = 47L;
        Product product = session.find(Product.class, id);

        session.beginTransaction();
        session.delete(product);
        session.getTransaction().commit();

        Product deletedProduct = session.find(Product.class, id);

        Assertions.assertNull(deletedProduct);
    }

    @BeforeEach
    void openSession() {
        session = sessionFactory.openSession();
        System.out.println("Session Created");
    }

    @AfterEach
    void closeSeason() {
        if (session != null) session.close();
        System.out.println("Session Closed");
    }
}
