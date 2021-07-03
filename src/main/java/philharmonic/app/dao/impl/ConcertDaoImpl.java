package philharmonic.app.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import philharmonic.app.dao.AbstractDao;
import philharmonic.app.dao.ConcertDao;
import philharmonic.app.model.Concert;

@Repository
public class ConcertDaoImpl extends AbstractDao<Concert> implements ConcertDao {
    public ConcertDaoImpl(SessionFactory factory) {
        super(factory, Concert.class);
    }
}
