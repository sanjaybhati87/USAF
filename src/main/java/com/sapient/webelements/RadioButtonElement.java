package com.sapient.webelements;

import org.openqa.selenium.By;

import com.sapient.core.TestLogging;

/**
 * @author ssi248
 *
 */
public class RadioButtonElement extends HtmlElement {

    public RadioButtonElement(final String label, final By by) {
        super(label, by);
    }

    public void check() {
        TestLogging.logWebStep(null, "check " + toHTML(), false);
        super.click();
    }

    @Override
    public void click() {
        TestLogging.logWebStep(null, "click on " + toHTML(), false);
        super.click();
    }

    public boolean isSelected() {
        findElement();
        return element.isSelected();
    }
}
