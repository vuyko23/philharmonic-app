package philharmonic.app.service.mapper;

import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import philharmonic.app.dto.response.ShoppingCartResponseDto;
import philharmonic.app.model.ShoppingCart;
import philharmonic.app.model.Ticket;

@Component
public class ShoppingCartMapper implements
        ResponseDtoMapper<ShoppingCartResponseDto, ShoppingCart> {

    @Override
    public ShoppingCartResponseDto mapToDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto responseDto = new ShoppingCartResponseDto();
        responseDto.setUserId(shoppingCart.getUser().getId());
        responseDto.setTicketIds(shoppingCart.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        return responseDto;
    }
}
