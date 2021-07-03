package philharmonic.app.service.impl;

import org.springframework.stereotype.Service;
import philharmonic.app.dao.ShoppingCartDao;
import philharmonic.app.dao.TicketDao;
import philharmonic.app.model.Performance;
import philharmonic.app.model.ShoppingCart;
import philharmonic.app.model.Ticket;
import philharmonic.app.model.User;
import philharmonic.app.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartDao shoppingCartDao;
    private final TicketDao ticketDao;

    public ShoppingCartServiceImpl(ShoppingCartDao shoppingCartDao, TicketDao ticketDao) {
        this.shoppingCartDao = shoppingCartDao;
        this.ticketDao = ticketDao;
    }

    @Override
    public void addPerformance(Performance performance, User user) {
        Ticket ticket = new Ticket();
        ticket.setPerformance(performance);
        ticket.setUser(user);
        ShoppingCart shoppingCart = shoppingCartDao.getByUser(user);
        ticketDao.add(ticket);
        shoppingCart.getTickets().add(ticket);
        shoppingCartDao.update(shoppingCart);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        return shoppingCartDao.getByUser(user);
    }

    @Override
    public void registerNewShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCartDao.add(shoppingCart);
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.setTickets(null);
        shoppingCartDao.update(shoppingCart);
    }
}
