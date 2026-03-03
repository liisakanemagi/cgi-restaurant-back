package cgi.test.restaurant_reservation.Infrastructure;

import lombok.Getter;

@Getter
public enum Error {

    TABLE_NOT_FOUND("Lauda ei leitud", 111);

    private final String message;
    private final Integer errorCode;

    Error(String message, Integer errorCode){
        this.message = message;
        this.errorCode = errorCode;
    }

}
