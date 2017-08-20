package com.sapient.webelements;

import org.openqa.selenium.By;

import com.sapient.core.TestLogging;

/**
 * @author ssi248
 *
 */
public class LinkElement extends HtmlElement {

    public LinkElement(final String label, final By by) {
        super(label, by);
    }

    @Override
    public void click() {
        TestLogging.logWebStep(null, "click on " + toHTML(), false);
        super.click();
    }

    public String getUrl() {
        return super.getAttribute("href");
    }
}
