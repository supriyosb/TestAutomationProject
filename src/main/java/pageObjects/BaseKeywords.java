package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseKeywords {
    private WebDriver driver;

    /**
     * Constructor
     * It will initialize the WebDriver instance
     * @param driver
     */
    public BaseKeywords(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * It will vertically scroll from top to bottom
     */
    protected void verticalScrollUsingJS(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    /**
     * It will inject a hard wait
     * @param timeout
     */
    protected void sleep(Integer timeout){
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
        }
    }

    /**
     * It will vertically scroll from bottom to top
     */
    protected void scrollToTop(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    }

    /**
     * It will return the Element object
     * @return
     */
    protected Element getUiInstance(){
        Element element = new Element(driver);
        return element;
    }

    public class Element{

        private WebElement element;
        private WebDriver driver;

        /**
         * Constructor
         * To initialize WebDriver for Element class
         * @param driver
         */
        public Element(WebDriver driver) {
            this.driver = driver;
        }

        /**
         * It will initialize WebElement object and return the Element object
         * @param locator
         * @return
         */
        public Element getElement(By locator){
            element = driver.findElement(locator);
            return this;
        }

        /**
         * It will explicitely wait to initialize WebElement object and return Element object
         * @param locator
         * @param timeout
         * @return
         */
        public Element getElement(By locator, Integer timeout){
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return this;
        }

        /**
         * It will wait for specific time and then it will return true or false incase element is visible or not
         * @param locator
         * @param timeout
         * @return
         */
        public Boolean waitForElementToVisible(By locator, Integer timeout){
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();
        }

        /**
         * It will do the click operation
         */
        public void click(){
            element.click();
        }

        /**
         * It will do click operation using Javascript Executor
         */
        public void clickUsingJs(){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        }

        /**
         * It will return the text of WebElement
         * @return
         */
        public String getText(){
            return element.getText();
        }
    }
}
