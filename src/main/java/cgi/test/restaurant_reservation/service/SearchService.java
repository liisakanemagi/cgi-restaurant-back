package cgi.test.restaurant_reservation.service;

import cgi.test.restaurant_reservation.controller.restauranttable.RestaurantTableDto;
import cgi.test.restaurant_reservation.persistence.reservation.Reservation;
import cgi.test.restaurant_reservation.persistence.reservation.ReservationRepository;
import cgi.test.restaurant_reservation.persistence.restauranttable.RestaurantTable;
import cgi.test.restaurant_reservation.persistence.restauranttable.RestaurantTableMapper;
import cgi.test.restaurant_reservation.persistence.restauranttable.RestaurantTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final ReservationRepository reservationRepository;
    private final RestaurantTableRepository restaurantTableRepository;
    private final RestaurantTableMapper restaurantTableMapper;

    public List<RestaurantTableDto> getAvailableRestaurantTables(LocalDateTime startTime, Integer guestCount) {

        LocalDateTime endTime = startTime.plusHours(2);
        List<Reservation> reservations = reservationRepository.findAllByStartTimeBeforeAndEndTimeAfter(endTime, startTime);
        List<Integer> occupiedRestaurantTableIds = reservations.stream()
                .map(reservation -> reservation.getRestaurantTable().getId()).toList();
        List<RestaurantTable> restaurantTables = restaurantTableRepository.findAll();

        List<RestaurantTable> freeRestaurantTables = new ArrayList<>();
        for (RestaurantTable restaurantTable : restaurantTables) {
            if (!occupiedRestaurantTableIds.contains(restaurantTable.getId()) && restaurantTable.getCapacity() >= guestCount) {
                freeRestaurantTables.add(restaurantTable);
            }
        }
        return restaurantTableMapper.toRestaurantTableDtos(freeRestaurantTables);

    }

}
