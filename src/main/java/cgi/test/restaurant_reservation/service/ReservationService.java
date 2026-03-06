package cgi.test.restaurant_reservation.service;

import cgi.test.restaurant_reservation.controller.reservation.ReservationDto;
import cgi.test.restaurant_reservation.controller.reservation.ReservationInfo;
import cgi.test.restaurant_reservation.persistence.reservation.Reservation;
import cgi.test.restaurant_reservation.persistence.reservation.ReservationMapper;
import cgi.test.restaurant_reservation.persistence.reservation.ReservationRepository;
import cgi.test.restaurant_reservation.persistence.restauranttable.RestaurantTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;
    private final RestaurantTableService restaurantTableService;

    public List<ReservationDto> getReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservationMapper.toReservationDtos(reservations);
    }

    public ReservationDto postReservation(ReservationInfo reservationInfo) {

        RestaurantTable restaurantTable = restaurantTableService.getValidRestaurantTable(reservationInfo.getRestaurantTableId());
        Reservation reservation = reservationMapper.toReservation(reservationInfo);

        reservation.setRestaurantTable(restaurantTable);
        Reservation savedReservation = reservationRepository.save(reservation);
        return reservationMapper.toReservationDto(savedReservation);
    }

}

