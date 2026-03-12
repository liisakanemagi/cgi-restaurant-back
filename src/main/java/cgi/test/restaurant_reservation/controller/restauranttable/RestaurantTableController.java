package cgi.test.restaurant_reservation.controller.restauranttable;


import cgi.test.restaurant_reservation.persistence.restauranttable.RestaurantTable;
import cgi.test.restaurant_reservation.service.RestaurantTableService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantTableController {

    private final RestaurantTableService restaurantTableService;

    @PutMapping("api/restaurant/table/{tableId}")
    @Operation(summary = "Laua andmete muutmine")

    public RestaurantTableDto updateRestaurantTable(@PathVariable Integer tableId, @RequestBody RestaurantTableDto restaurantTableDto) {
        return restaurantTableService.updateRestaurantTable(tableId, restaurantTableDto);


    }

}
