package cgi.test.restaurant_reservation.controller.reservation;

import cgi.test.restaurant_reservation.service.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/api/reservations")
    @Operation(summary = "Reserveeringute pärimine", description = "Tagastab nimekirja reserveeringutest")

    public List<ReservationDto> getReservations(){
        return reservationService.getReservations();
    }

}
