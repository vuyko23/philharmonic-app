package philharmonic.app.dao;

import philharmonic.app.model.ShoppingCart;
import philharmonic.app.model.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    ShoppingCart update(ShoppingCart shoppingCart);
}
