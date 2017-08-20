package com.sapient.webelements;

import org.openqa.selenium.By;

import com.sapient.core.CustomAssertion;
import com.sapient.core.TestLogging;

/**
 * @author ssi248
 *
 */
public class LabelElement extends HtmlElement {
    public LabelElement(final String label, final By by) {
        super(label, by);
    }

    @Override
    public String getText() {
        TestLogging.logWebStep(null, "get text from " + toHTML(), false);
        return super.getText();
    }

    public boolean isTextPresent(final String pattern) {
        String text = getText();
        return (text != null && (text.contains(pattern) || text.matches(pattern)));
    }

    @Deprecated
    public String getExpectedText() {
        CustomAssertion.assertTrue(false, "NOT supported!");
        return null;
    }
    
    public String getBacgroundColor()
    {
    	findElement();
    	return element.getCssValue("background-color"); 
    }
}
