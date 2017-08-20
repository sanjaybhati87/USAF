package com.sapient.customexception;

import org.openqa.selenium.WebDriverException;

/**
 * @author ssi248
 *
 */
public class WebSessionEndedException extends WebDriverException {

    private static final long serialVersionUID = -647233887439084123L;

    public WebSessionEndedException() {
        super();
    }

    public WebSessionEndedException(final Throwable ex) {
        super(ex);
    }
}
