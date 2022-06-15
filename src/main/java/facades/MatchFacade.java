package facades;

import entities.Match;
import javassist.NotFoundException;

import java.util.List;

public class MatchFacade implements IFacade<Match> {


    @Override
    public Match create(Match match) {
        return null;
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
