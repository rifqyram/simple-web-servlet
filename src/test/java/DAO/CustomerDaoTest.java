package DAO;

import com.enigma.config.HibernateConfig;
import com.enigma.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerDaoTest {

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

        Customer customer = new Customer(
                "Rifqi",
                "Depok",
                "08123451519",
                Date.valueOf("1999-04-12"),
                true,
                Date.valueOf(LocalDate.now()),
                null
        );

        Long id = (Long) session.save(customer);
        session.getTransaction().commit();

        Assertions.assertTrue(id > 0);
    }

    @Test
    @Order(2)
    void testUpdate() {
        Long id = 9L;

        Customer customer = new Customer(
                id,
                "Rifqi Ramadhan",
                "Depok",
                "08123451519",
                Date.valueOf("1999-04-12"),
                true,
                Date.valueOf(LocalDate.now()),
                Date.valueOf(LocalDate.now()));

        session.beginTransaction();
        session.update(customer);
        session.getTransaction().commit();

        Customer updateCustomer = session.get(Customer.class, id);

        Assertions.assertEquals("Rifqi Ramadhan", updateCustomer.getName());
    }

    @Test
    @Order(3)
    void testGet() {
        Long id = 9L;

        Customer customer = session.get(Customer.class, id);

        Assertions.assertEquals("Rifqi Ramadhan" , customer.getName());
    }

    @Test
    @Order(4)
    void testList() {
        Query<Customer> query = session.createQuery("FROM  Customer", Customer.class);
        List<Customer> customer = query.getResultList();

        Assertions.assertFalse(customer.isEmpty());
    }

    @Test
    @Order(5)
    void testDelete() {
        Long id = 9L;
        Customer customer = session.get(Customer.class, id);
        session.beginTransaction();
        session.delete(customer);
        session.getTransaction().commit();

        Customer deletedCustomer = session.get(Customer.class, id);

        Assertions.assertNull(deletedCustomer);
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
