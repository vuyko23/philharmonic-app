package philharmonic.app.service.impl;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import philharmonic.app.dao.PerformanceDao;
import philharmonic.app.exception.DataProcessingException;
import philharmonic.app.model.Performance;
import philharmonic.app.service.PerformanceService;

@Service
public class PerformanceServiceImpl implements PerformanceService {
    private final PerformanceDao performanceDao;

    public PerformanceServiceImpl(PerformanceDao performanceDao) {
        this.performanceDao = performanceDao;
    }

    @Override
    public List<Performance> findAvailablePerformances(Long concertId, LocalDate date) {
        return performanceDao.findAvailablePerformances(concertId, date);
    }

    @Override
    public Performance add(Performance performance) {
        return performanceDao.add(performance);
    }

    @Override
    public Performance get(Long id) {
        return performanceDao.get(id).orElseThrow(
                () -> new DataProcessingException("Session with id " + id + " not found"));
    }

    @Override
    public Performance update(Performance performance) {
        return performanceDao.update(performance);
    }

    @Override
    public void delete(Long id) {
        performanceDao.delete(id);
    }
}
