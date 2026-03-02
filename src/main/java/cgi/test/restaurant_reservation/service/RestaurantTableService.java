package cgi.test.restaurant_reservation.service;

import cgi.test.restaurant_reservation.controller.restauranttable.RestaurantTableDto;
import cgi.test.restaurant_reservation.persistence.restauranttable.RestaurantTable;
import cgi.test.restaurant_reservation.persistence.restauranttable.RestaurantTableMapper;
import cgi.test.restaurant_reservation.persistence.restauranttable.RestaurantTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantTableService {

    private final RestaurantTableRepository restaurantTableRepository;
    private final RestaurantTableMapper restaurantTableMapper;

    public List<RestaurantTableDto> getTables(){
        List<RestaurantTable> restaurantTables = restaurantTableRepository.findAll();
        return restaurantTableMapper.toRestaurantTableDtos(restaurantTables);
    }

}
