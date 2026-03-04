package cgi.test.restaurant_reservation.persistence.reservation;

import cgi.test.restaurant_reservation.controller.reservation.ReservationDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReservationMapper {
    Reservation toEntity(ReservationDto reservationDto);

    @Mapping(source = "restaurantTable.id", target = "restaurantTableId")
    ReservationDto toReservationDto(Reservation reservation);

    List<ReservationDto> toReservationDtos(List<Reservation> reservation);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Reservation partialUpdate(ReservationDto reservationDto, @MappingTarget Reservation reservation);
}