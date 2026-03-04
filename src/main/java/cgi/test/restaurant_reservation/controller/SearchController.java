package cgi.test.restaurant_reservation.controller;

import cgi.test.restaurant_reservation.controller.restauranttable.RestaurantTableDto;
import cgi.test.restaurant_reservation.service.SearchService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/api/available")
    @Operation(summary = "Vabade laudade pärimine",
            description = "Tagastab nimekirja laudadest vastavalt vabale kellajale ja külaliste arvule")

    public List<RestaurantTableDto> getAvailableRestaurantTables(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                       LocalDateTime startTime, @RequestParam Integer guestCount) {

        return searchService.getAvailableRestaurantTables(startTime, guestCount);

    }

}
