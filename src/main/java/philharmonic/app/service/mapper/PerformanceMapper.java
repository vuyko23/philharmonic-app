package philharmonic.app.service.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;
import philharmonic.app.dto.request.PerformanceRequestDto;
import philharmonic.app.dto.response.PerformanceResponseDto;
import philharmonic.app.model.Performance;
import philharmonic.app.service.ConcertService;
import philharmonic.app.service.StageService;
import philharmonic.app.util.DateTimePatternUtil;

@Component
public class PerformanceMapper implements RequestDtoMapper<PerformanceRequestDto, Performance>,
        ResponseDtoMapper<PerformanceResponseDto, Performance> {
    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern(DateTimePatternUtil.DATE_TIME_PATTERN);
    private final StageService stageService;
    private final ConcertService concertService;

    public PerformanceMapper(StageService stageService, ConcertService concertService) {
        this.stageService = stageService;
        this.concertService = concertService;
    }

    @Override
    public Performance mapToModel(PerformanceRequestDto dto) {
        Performance performance = new Performance();
        performance.setConcert(concertService.get(dto.getConcertId()));
        performance.setStage(stageService.get(dto.getStageId()));
        performance.setShowTime(LocalDateTime.parse(dto.getShowTime(), formatter));
        return performance;
    }

    @Override
    public PerformanceResponseDto mapToDto(Performance movieSession) {
        PerformanceResponseDto responseDto = new PerformanceResponseDto();
        responseDto.setPerformanceId(movieSession.getId());
        responseDto.setStageId(movieSession.getStage().getId());
        responseDto.setConcertId(movieSession.getConcert().getId());
        responseDto.setConcertTitle(movieSession.getConcert().getTitle());
        responseDto.setShowTime(movieSession.getShowTime().format(formatter));
        return responseDto;
    }
}
