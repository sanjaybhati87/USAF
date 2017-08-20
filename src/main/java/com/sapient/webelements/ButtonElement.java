package com.sapient.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.sapient.core.TestLogging;
import com.sapient.driver.BrowserType;
import com.sapient.driver.WebUIDriver;

/**
 * @author ssi248
 *
 */
public class ButtonElement extends HtmlElement {

    public ButtonElement(final String label, final By by) {
        super(label, by);
    }

  /*  @Override
    public void click() {
        TestLogging.logWebStep(null, "click on " + toHTML(), false);

        BrowserType browser = WebUIDriver.getWebUIDriver().getConfig().getBrowser();
        if (browser == BrowserType.InternetExplore) {
            super.sendKeys(Keys.ENTER);
        } else {
            super.click();
        }
    }
*/
    
    @Override
    public void click() {
        TestLogging.logWebStep(null, "click on " + toHTML(), false);
        super.click();
    }
    public void submit() {
        TestLogging.logWebStep(null, "Submit form by clicking on " + toHTML(), false);
        findElement();
        element.submit();
    }
}
