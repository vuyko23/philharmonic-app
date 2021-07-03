package philharmonic.app.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import philharmonic.app.model.Performance;

public interface PerformanceDao {
    Performance add(Performance performance);

    Optional<Performance> get(Long id);

    List<Performance> findAvailablePerformances(Long concertId, LocalDate date);

    Performance update(Performance performance);

    void delete(Long id);
}
