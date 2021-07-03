package philharmonic.app.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import philharmonic.app.dto.request.PerformanceRequestDto;
import philharmonic.app.dto.response.PerformanceResponseDto;
import philharmonic.app.model.Performance;
import philharmonic.app.service.PerformanceService;
import philharmonic.app.service.mapper.PerformanceMapper;
import philharmonic.app.util.DateTimePatternUtil;

@Log4j2
@RestController
@RequestMapping("/performances")
public class PerformanceController {
    public static final String DATE_PATTERN = DateTimePatternUtil.DATE_PATTERN;
    private final PerformanceService performanceService;
    private final PerformanceMapper performanceMapper;

    public PerformanceController(PerformanceService performanceService,
                                 PerformanceMapper performanceMapper) {
        this.performanceService = performanceService;
        this.performanceMapper = performanceMapper;
    }

    @PostMapping
    public PerformanceResponseDto add(@RequestBody @Valid PerformanceRequestDto requestDto) {
        Performance performance = performanceMapper.mapToModel(requestDto);
        performanceService.add(performance);
        log.info("Performance with id " + performance.getId() + " was added");
        return performanceMapper.mapToDto(performance);
    }

    @GetMapping("/available")
    public List<PerformanceResponseDto> getAll(@RequestParam Long concertId,
                                               @RequestParam
                                                @DateTimeFormat(pattern = DATE_PATTERN)
                                                       LocalDate date) {
        return performanceService.findAvailablePerformances(concertId, date)
                .stream()
                .map(performanceMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public PerformanceResponseDto update(@PathVariable Long id,
                                         @RequestBody @Valid PerformanceRequestDto requestDto) {
        Performance performance = performanceMapper.mapToModel(requestDto);
        performance.setId(id);
        performanceService.update(performance);
        log.info("Performance with id " + id + " was updated");
        return performanceMapper.mapToDto(performance);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        performanceService.delete(id);
        log.info("Performance with id " + id + " was deleted");
    }
}
