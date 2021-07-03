package philharmonic.app.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import philharmonic.app.dto.response.ShoppingCartResponseDto;
import philharmonic.app.model.Performance;
import philharmonic.app.model.User;
import philharmonic.app.service.PerformanceService;
import philharmonic.app.service.ShoppingCartService;
import philharmonic.app.service.UserService;
import philharmonic.app.service.mapper.ShoppingCartMapper;

@Log4j2
@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartMapper shoppingCartMapper;
    private final PerformanceService performanceService;
    private final UserService userService;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  ShoppingCartMapper shoppingCartMapper,
                                  UserService userService,
                                  PerformanceService performanceService) {
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartMapper = shoppingCartMapper;
        this.userService = userService;
        this.performanceService = performanceService;
    }

    @PostMapping("/performances")
    public void addToCart(Authentication auth, @RequestParam Long performanceId) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        User user = userService.findByEmail(details.getUsername());
        Performance performance = performanceService.get(performanceId);
        shoppingCartService.addPerformance(performance, user);
        log.info("Performance with id " + performance.getId()
                + " was added to user shopping cart " + user.getId());
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(Authentication auth) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        User user = userService.findByEmail(details.getUsername());
        return shoppingCartMapper.mapToDto(shoppingCartService.getByUser(user));
    }
}
