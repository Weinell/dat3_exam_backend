package facades;

import entities.Match;
import javassist.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
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
        EntityManager em = emf.createEntityManager();
        Match found = em.find(Match.class, match.getId());

        if (found == null) {
            throw new NotFoundException("Entity with ID: " + match.getId() + " not found");
        }

        try {
            em.getTransaction().begin();
            Match updated = em.merge(match);
            em.getTransaction().commit();
            return updated;
        } finally {
            em.close();
        }
    }

    @Override
    public Match delete(Long id) throws NotFoundException {
        return null;
    }

    @Override
    public Match getById(Long id) throws NotFoundException {
        EntityManager em = emf.createEntityManager();
        Match match;

        try {
            em.getTransaction().begin();
            match = em.find(Match.class, id);
        } finally {
            em.close();
        }
        return match;
    }

    @Override
    public List<Match> getAll() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Match> query = em.createQuery("SELECT m FROM Match m", Match.class);
        return query.getResultList();
    }

    @Override
    public long getCount() {
        return 0;
    }
}
