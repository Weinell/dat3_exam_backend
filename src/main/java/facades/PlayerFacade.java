package facades;

import entities.Player;
import javassist.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class PlayerFacade implements IFacade<Player>{

    private static EntityManagerFactory emf;
    private static PlayerFacade instance;

    public static PlayerFacade getFacade(EntityManagerFactory _emf)  {
        if (instance == null)   {
            emf = _emf;
            instance = new PlayerFacade();
        }
        return instance;
    }

    @Override
    public Player create(Player player) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(player);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return player;
    }

    @Override
    public Player update(Player player) throws NotFoundException {
        return null;
    }

    @Override
    public Player delete(Long id) throws NotFoundException {
        EntityManager em = emf.createEntityManager();
        Player found = em.find(Player.class, id);
        if (found == null) {
            throw new NotFoundException("Could not remove Entity with id: " + id);
        }

        try {
            em.getTransaction().begin();
            em.remove(found);
            em.getTransaction().commit();
            return found;
        } finally {
            em.close();
        }
    }

    @Override
    public Player getById(Long id) throws NotFoundException {
        return null;
    }

    @Override
    public List<Player> getAll() {
        return null;
    }

    @Override
    public long getCount() {
        return 0;
    }
}
