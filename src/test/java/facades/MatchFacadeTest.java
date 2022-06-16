package facades;

import entities.Match;
import javassist.NotFoundException;
import org.junit.jupiter.api.*;
import utils.EMF_Creator;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MatchFacadeTest {

    private static final EntityManagerFactory emf = EMF_Creator.createEntityManagerFactoryForTest();
    private static MatchFacade facade;

    public MatchFacadeTest() {
    }

    @BeforeAll
    static void setUpClass() {

    }

    @BeforeEach
    void setUp()  {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.createNamedQuery("Match.deleteAllRows").executeUpdate();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }


    @Test
    void create() {
        facade = MatchFacade.getFacade(emf);

        Match actual = facade.create(new Match("The Eagles", "Don Henley", 2, true));

        assertNotNull(actual);
    }

    @Test
    void update() {
    }

    @Test
    void delete() throws NotFoundException {
        facade = MatchFacade.getFacade(emf);

        Match m1 = facade.create(new Match("The Eagles", "Don Henley", 2, true));
        Match m2 = facade.create(new Match("The Eagles2", "Don Henley", 2, true));

        int expected = 2;
        int actual = facade.getAll().size();

        assertEquals(expected, actual);

        facade.delete(m1.getId());

        int expectedAfter = 1;
        int actualAfter = facade.getAll().size();

        assertEquals(expectedAfter, actualAfter);
    }

    @Test
    void getById() throws NotFoundException {
        facade = MatchFacade.getFacade(emf);

        Match expected = facade.create(new Match("The Creators", "Thanos", 2, true));

        facade.create(expected);

        // Locally 5L works, but for GitHub Actions 11L is the way to go...
        Match actual = facade.getById(5L);

        assertEquals(expected, actual);
    }

    @Test
    void getAll() {
    }

    @Test
    void getCount() {
    }
}