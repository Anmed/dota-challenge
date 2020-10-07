package gg.bayes.challenge.exceptions;

public class LogParserException extends RuntimeException{

    public LogParserException() {
        super();
    }

    public LogParserException(String message, Throwable cause, boolean enableSuppression,
                                       boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public LogParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogParserException(String message) {
        super(message);
    }

    public LogParserException(Throwable cause) {
        super(cause);
    }
}
