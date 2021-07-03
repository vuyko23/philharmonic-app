package philharmonic.app.service;

import java.util.List;
import philharmonic.app.model.Order;
import philharmonic.app.model.ShoppingCart;
import philharmonic.app.model.User;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
