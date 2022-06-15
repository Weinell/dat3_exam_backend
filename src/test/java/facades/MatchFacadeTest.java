package facades;

import entities.Match;
import org.junit.jupiter.api.*;
import utils.EMF_Creator;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MatchFacadeTest {

    private static EntityManagerFactory emf;
    private static MatchFacade facade;

    public MatchFacadeTest() {
    }

    @BeforeAll
    static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = MatchFacade.getFacade(emf);
    }

    @BeforeEach
    void setUp()  {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.createNamedQuery("Match.deleteAllRows").executeUpdate();
            em.persist(new Match("The Eagles", "Jens", 1, false));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }


    @Test
    void create() {
        Match actual = facade.create(new Match("The Eagles", "Jens", 1, false));

        assertNotNull(actual);
        System.out.println(actual);
        assertEquals(2, actual.getId());
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getById() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getCount() {
    }
}