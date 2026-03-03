package cgi.test.restaurant_reservation.service;

import cgi.test.restaurant_reservation.Infrastructure.DataNotFoundException;
import cgi.test.restaurant_reservation.Infrastructure.Error;
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

    public void getValidTable(Integer tableId){
        restaurantTableRepository.findById(tableId)
                .orElseThrow((() -> new DataNotFoundException(Error.TABLE_NOT_FOUND.getMessage(), Error.TABLE_NOT_FOUND.getErrorCode())));
    }

    public List<RestaurantTableDto> getTables(){
        List<RestaurantTable> restaurantTables = restaurantTableRepository.findAll();
        return restaurantTableMapper.toRestaurantTableDtos(restaurantTables);
    }

}
