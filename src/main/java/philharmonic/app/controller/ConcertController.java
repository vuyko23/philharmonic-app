package philharmonic.app.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import philharmonic.app.dto.request.ConcertRequestDto;
import philharmonic.app.dto.response.ConcertResponseDto;
import philharmonic.app.model.Concert;
import philharmonic.app.service.ConcertService;
import philharmonic.app.service.mapper.ConcertMapper;

@Log4j2
@RestController
@RequestMapping("/concerts")
public class ConcertController {
    private final ConcertService concertService;
    private final ConcertMapper concertMapper;

    public ConcertController(ConcertService concertService, ConcertMapper concertMapper) {
        this.concertService = concertService;
        this.concertMapper = concertMapper;
    }

    @PostMapping
    public ConcertResponseDto add(@RequestBody @Valid ConcertRequestDto requestDto) {
        Concert concert = concertService.add(concertMapper.mapToModel(requestDto));
        log.info("Concert " + concert.getTitle() + " was added");
        return concertMapper.mapToDto(concert);
    }

    @GetMapping
    public List<ConcertResponseDto> getAll() {
        return concertService.getAll()
                .stream()
                .map(concertMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
