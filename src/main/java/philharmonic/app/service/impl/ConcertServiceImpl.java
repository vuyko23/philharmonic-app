package philharmonic.app.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import philharmonic.app.dao.ConcertDao;
import philharmonic.app.exception.DataProcessingException;
import philharmonic.app.model.Concert;
import philharmonic.app.service.ConcertService;

@Service
public class ConcertServiceImpl implements ConcertService {
    private final ConcertDao concertDao;

    public ConcertServiceImpl(ConcertDao concertDao) {
        this.concertDao = concertDao;
    }

    @Override
    public Concert add(Concert concert) {
        return concertDao.add(concert);
    }

    @Override
    public Concert get(Long id) {
        return concertDao.get(id).orElseThrow(
                () -> new DataProcessingException("Can't get movie by id " + id));
    }

    @Override
    public List<Concert> getAll() {
        return concertDao.getAll();
    }
}
