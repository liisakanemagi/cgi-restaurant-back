package cgi.test.restaurant_reservation.controller.restauranttable;


import cgi.test.restaurant_reservation.service.RestaurantTableService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantTableController {


    private final RestaurantTableService restaurantTableService;

    @GetMapping("/api/tables")
    @Operation(summary = "Laudade pärimine", description = "Tagastab nimekirja laudadest")

    public List<RestaurantTableDto> getTables() {
        return restaurantTableService.getTables();
    }

}
