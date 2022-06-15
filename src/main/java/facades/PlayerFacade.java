package facades;

import entities.Player;
import javassist.NotFoundException;

import java.util.List;

public class PlayerFacade implements IFacade<Player>{


    @Override
    public Player create(Player player) {
        return null;
    }

    @Override
    public Player update(Player player) throws NotFoundException {
        return null;
    }

    @Override
    public Player delete(Long id) throws NotFoundException {
        return null;
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
