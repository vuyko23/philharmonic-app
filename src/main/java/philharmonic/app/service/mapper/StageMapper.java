package philharmonic.app.service.mapper;

import org.springframework.stereotype.Component;
import philharmonic.app.dto.request.StageRequestDto;
import philharmonic.app.dto.response.StageResponseDto;
import philharmonic.app.model.Stage;

@Component
public class StageMapper implements RequestDtoMapper<StageRequestDto, Stage>,
        ResponseDtoMapper<StageResponseDto, Stage> {
    @Override
    public Stage mapToModel(StageRequestDto dto) {
        Stage stage = new Stage();
        stage.setDescription(dto.getDescription());
        stage.setCapacity(dto.getCapacity());
        return stage;
    }

    @Override
    public StageResponseDto mapToDto(Stage stage) {
        StageResponseDto responseDto = new StageResponseDto();
        responseDto.setId(stage.getId());
        responseDto.setDescription(stage.getDescription());
        return responseDto;
    }
}
