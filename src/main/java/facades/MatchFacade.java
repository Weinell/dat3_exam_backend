package facades;

import entities.Match;
import javassist.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class MatchFacade implements IFacade<Match> {

    private static EntityManagerFactory emf;
    private static MatchFacade instance;

    public MatchFacade() {
    }

    public static MatchFacade getFacade(EntityManagerFactory _emf)  {
        if (instance == null)   {
            emf = _emf;
            instance = new MatchFacade();
        }
        return instance;
    }

    @Override
    public Match create(Match match) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(match);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return match;
    }

    @Override
    public Match update(Match match) throws NotFoundException {
        return null;
    }

    @Override
    public Match delete(Long id) throws NotFoundException {
        return null;
    }

    @Override
    public Match getById(Long id) throws NotFoundException {
        return null;
    }

    @Override
    public List<Match> getAll() {
        return null;
    }

    @Override
    public long getCount() {
        return 0;
    }
}
