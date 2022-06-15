package facades;

import entities.Location;
import javassist.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class LocationFacade implements IFacade<Location>{

    private static EntityManagerFactory emf;
    private static LocationFacade instance;

    public static LocationFacade getFacade(EntityManagerFactory _emf)  {
        if (instance == null)   {
            emf = _emf;
            instance = new LocationFacade();
        }
        return instance;
    }

    @Override
    public Location create(Location location) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(location);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return location;
    }

    @Override
    public Location update(Location location) throws NotFoundException {
        return null;
    }

    @Override
    public Location delete(Long id) throws NotFoundException {
        return null;
    }

    @Override
    public Location getById(Long id) throws NotFoundException {
        return null;
    }

    @Override
    public List<Location> getAll() {
        return null;
    }

    @Override
    public long getCount() {
        return 0;
    }
}
