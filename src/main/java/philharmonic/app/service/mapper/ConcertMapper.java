package philharmonic.app.service.mapper;

import org.springframework.stereotype.Component;
import philharmonic.app.dto.request.ConcertRequestDto;
import philharmonic.app.dto.response.ConcertResponseDto;
import philharmonic.app.model.Concert;

@Component
public class ConcertMapper implements RequestDtoMapper<ConcertRequestDto, Concert>,
        ResponseDtoMapper<ConcertResponseDto, Concert> {
    @Override
    public Concert mapToModel(ConcertRequestDto dto) {
        Concert concert = new Concert();
        concert.setTitle(dto.getTitle());
        concert.setDescription(dto.getDescription());
        return concert;
    }

    @Override
    public ConcertResponseDto mapToDto(Concert concert) {
        ConcertResponseDto responseDto = new ConcertResponseDto();
        responseDto.setId(concert.getId());
        responseDto.setTitle(concert.getTitle());
        responseDto.setDescription(concert.getDescription());
        return responseDto;
    }
}
