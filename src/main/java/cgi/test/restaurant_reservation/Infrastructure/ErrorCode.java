package cgi.test.restaurant_reservation.Infrastructure;

import lombok.Getter;

@Getter
public enum ErrorCode {

    RESTAURANT_TABLE_NOT_FOUND("Lauda ei leitud", 111),
    RESTAURANT_TABLE_ALREADY_BOOKED("Laud on juba sellel kellaajal broneeritud", 112);

    private final String message;
    private final int errorCode;

    ErrorCode(String message, int errorCode){
        this.message = message;
        this.errorCode = errorCode;
    }

}
