package excpetions;

import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class ToManyTeamsException extends Exception {
    public ToManyTeamsException(String message) {
        LoggerFactory.getLogger(ToManyTeamsException.class.getName()).info(message);
    }

    public ToManyTeamsException() {
        LoggerFactory.getLogger(ToManyTeamsException.class.getName()).info("Your game has already 2 teams. You can't add teams anymore.");
    }
}
