package philharmonic.app.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import philharmonic.app.dao.AbstractDao;
import philharmonic.app.dao.TicketDao;
import philharmonic.app.model.Ticket;

@Repository
public class TicketDaoImpl extends AbstractDao<Ticket> implements TicketDao {
    public TicketDaoImpl(SessionFactory factory) {
        super(factory, Ticket.class);
    }
}
