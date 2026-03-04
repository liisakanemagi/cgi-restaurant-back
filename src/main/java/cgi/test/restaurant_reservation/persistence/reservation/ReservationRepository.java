package cgi.test.restaurant_reservation.persistence.reservation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

   List<Reservation> findAllByStartTimeBeforeAndEndTimeAfter(LocalDateTime endTime, LocalDateTime startTime);
}