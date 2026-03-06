package cgi.test.restaurant_reservation.Infrastructure;

import lombok.Getter;

@Getter
public class ForbiddenException extends RuntimeException {
    private final String message;
    private final int errorCode;

    public ForbiddenException(String message, int errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }

    public ForbiddenException(ErrorCode error) {
        this(error.getMessage(), error.getErrorCode());
    }
}
