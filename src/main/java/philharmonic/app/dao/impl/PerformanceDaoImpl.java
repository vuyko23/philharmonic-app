package philharmonic.app.dao.impl;

import java.time.LocalDate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import philharmonic.app.dao.AbstractDao;
import philharmonic.app.dao.PerformanceDao;
import philharmonic.app.exception.DataProcessingException;
import philharmonic.app.model.Performance;

@Repository
public class PerformanceDaoImpl extends AbstractDao<Performance> implements PerformanceDao {
    public PerformanceDaoImpl(SessionFactory factory) {
        super(factory, Performance.class);
    }

    @Override
    public List<Performance> findAvailablePerformances(Long concertId, LocalDate date) {
        try (Session session = factory.openSession()) {
            Query<Performance> getAvailablePerformances = session.createQuery(
                    "FROM Performance WHERE id = :id "
                            + "AND DATE_FORMAT(showTime, '%Y-%m-%d') = :date", Performance.class);
            getAvailablePerformances.setParameter("id", concertId);
            getAvailablePerformances.setParameter("date", date.toString());
            return getAvailablePerformances.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Session for concert with id "
                    + concertId + " and show date " + date + " not found", e);
        }
    }
}
