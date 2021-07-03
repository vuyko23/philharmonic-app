package philharmonic.app.service;

import java.time.LocalDate;
import java.util.List;
import philharmonic.app.model.Performance;

public interface PerformanceService {
    List<Performance> findAvailablePerformances(Long concertId, LocalDate date);

    Performance add(Performance performance);

    Performance get(Long id);

    Performance update(Performance performance);

    void delete(Long id);
}
