package philharmonic.app.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import philharmonic.app.dao.AbstractDao;
import philharmonic.app.dao.ShoppingCartDao;
import philharmonic.app.exception.DataProcessingException;
import philharmonic.app.model.ShoppingCart;
import philharmonic.app.model.User;

@Repository
public class ShoppingCartDaoImpl extends AbstractDao<ShoppingCart> implements ShoppingCartDao {
    public ShoppingCartDaoImpl(SessionFactory factory) {
        super(factory, ShoppingCart.class);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        try (Session session = factory.openSession()) {
            Query<ShoppingCart> getByUser = session.createQuery(
                    "SELECT DISTINCT sc FROM ShoppingCart sc "
                            + "left join fetch sc.tickets t "
                            + "left join fetch t.performance p "
                            + "left join fetch p.concert "
                            + "left join fetch p.stage "
                            + "left join fetch sc.user u "
                            + "left join fetch u.roles "
                            + "WHERE sc.id = :id", ShoppingCart.class);
            getByUser.setParameter("id", user.getId());
            return getByUser.getSingleResult();
        } catch (Exception e) {
            throw new DataProcessingException("Not found shopping cart for user " + user, e);
        }
    }
}
