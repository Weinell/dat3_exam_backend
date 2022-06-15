package facades;

import entities.Location;
import javassist.NotFoundException;

import java.util.List;

public class LocationFacade implements IFacade<Location>{
    @Override
    public Location create(Location location) {
        return null;
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
