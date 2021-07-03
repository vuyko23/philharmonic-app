package philharmonic.app.service;

import philharmonic.app.model.Performance;
import philharmonic.app.model.ShoppingCart;
import philharmonic.app.model.User;

public interface ShoppingCartService {
    void addPerformance(Performance performance, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
