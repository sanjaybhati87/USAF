package com.sapient.webelements;

import org.openqa.selenium.By;

import com.sapient.core.TestLogging;

/**
 * @author ssi248
 *
 */
public class ImageElement extends HtmlElement {

    public ImageElement(final String label, final By by) {
        super(label, by);
    }

    public int getHeight() {
    	TestLogging.log("Get teh height of the element");
        return super.getSize().getHeight();
        
    }

    public int getWidth() {
    	TestLogging.log("Get teh width of the element");
        return super.getSize().getWidth();
    }

    public String getUrl() {
        return super.getAttribute("src");
    }
}
