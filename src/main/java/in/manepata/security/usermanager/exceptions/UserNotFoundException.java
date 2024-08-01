package in.manepata.security.usermanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    private final Long userId;

    public UserNotFoundException(Long userId) {
        super("User with ID " + userId + " not found.");
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
}
