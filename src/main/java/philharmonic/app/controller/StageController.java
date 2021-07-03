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
import philharmonic.app.dto.request.StageRequestDto;
import philharmonic.app.dto.response.StageResponseDto;
import philharmonic.app.model.Stage;
import philharmonic.app.service.StageService;
import philharmonic.app.service.mapper.StageMapper;

@Log4j2
@RestController
@RequestMapping("/stages")
public class StageController {
    private final StageService stageService;
    private final StageMapper stageMapper;

    public StageController(StageService stageService,
                           StageMapper stageMapper) {
        this.stageService = stageService;
        this.stageMapper = stageMapper;
    }

    @PostMapping
    public StageResponseDto add(@RequestBody @Valid StageRequestDto requestDto) {
        Stage stage = stageService.add(stageMapper.mapToModel(requestDto));
        log.info("Stage with id " + stage.getId() + " was added");
        return stageMapper.mapToDto(stage);
    }

    @GetMapping
    public List<StageResponseDto> getAll() {
        return stageService.getAll()
                .stream()
                .map(stageMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
