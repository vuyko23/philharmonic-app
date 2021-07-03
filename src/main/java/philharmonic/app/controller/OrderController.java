package philharmonic.app.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import philharmonic.app.dto.response.OrderResponseDto;
import philharmonic.app.model.Order;
import philharmonic.app.model.ShoppingCart;
import philharmonic.app.model.User;
import philharmonic.app.service.OrderService;
import philharmonic.app.service.ShoppingCartService;
import philharmonic.app.service.UserService;
import philharmonic.app.service.mapper.OrderMapper;

@Log4j2
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final ShoppingCartService shoppingCartService;
    private final OrderService orderService;
    private final UserService userService;
    private final OrderMapper orderMapper;

    public OrderController(ShoppingCartService shoppingCartService,
                           OrderService orderService,
                           UserService userService,
                           OrderMapper orderMapper) {
        this.shoppingCartService = shoppingCartService;
        this.orderService = orderService;
        this.userService = userService;
        this.orderMapper = orderMapper;
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(Authentication auth) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        User user = userService.findByEmail(details.getUsername());
        ShoppingCart cart = shoppingCartService.getByUser(user);
        Order order = orderService.completeOrder(cart);
        log.info("User with email " + details.getUsername()
                + " complete order " + order.getId());
        return orderMapper.mapToDto(order);
    }

    @GetMapping
    public List<OrderResponseDto> getOrderHistory(Authentication auth) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        User user = userService.findByEmail(details.getUsername());
        return orderService.getOrdersHistory(user)
                .stream()
                .map(orderMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
