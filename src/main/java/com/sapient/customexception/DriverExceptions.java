package com.sapient.customexception;

/**
 * @author ssi248
 *
 */
public class DriverExceptions extends RuntimeException {

    public DriverExceptions(final String message, final Throwable throwable) {
        super(message, throwable);
    }

}
