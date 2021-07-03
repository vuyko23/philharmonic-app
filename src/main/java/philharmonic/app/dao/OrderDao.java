package philharmonic.app.dao;

import java.util.List;
import philharmonic.app.model.Order;
import philharmonic.app.model.User;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
