package pageObjects.flight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.BaseKeywords;
import utils.Constant;

public class FlightPageKeyword extends BaseKeywords {

    private WebDriver driver;
    private FlightPageLocators locators;

    /**
     * Constructor
     * It will initialize FlightPageKeyword with WebDriver and also create FlightPageLocators instance
     * @param driver
     */
    public FlightPageKeyword(WebDriver driver) {
        super(driver);
        this.driver = driver;
        locators = new FlightPageLocators();
    }

    /**
     * It will select round trip option for flights
     */
    public void selectRoundTripOption(){
        getUiInstance().getElement(By.xpath(locators.radioRoundTrip), Constant.DEFAULT_TIMEOUT).click();
    }

    /**
     * It will select the departure city depends on city code
     * @param cityCode
     */
    public void selectDepartureCity(String cityCode){
        getUiInstance().getElement(By.xpath(locators.labelFromCity), Constant.DEFAULT_TIMEOUT).click();
        getUiInstance().getElement(By.xpath(locators.txtFromCity.replace("$cityCode$", cityCode)), Constant.DEFAULT_TIMEOUT).clickUsingJs();
    }

    /**
     * It will select return city depends on city code
     * @param cityCode
     */
    public void selectReturnCity(String cityCode){
        getUiInstance().getElement(By.xpath(locators.labelToCity), Constant.DEFAULT_TIMEOUT).click();
        getUiInstance().getElement(By.xpath(locators.txtToCity.replace("$cityCode$", cityCode)), Constant.DEFAULT_TIMEOUT).clickUsingJs();
    }

    /**
     * It will select departure date from departure calender
     * @param date
     */
    public void selectDepartureDateFromCalender(String date){
        String[] dateArr = date.split("-");
        String day = dateArr[0];
        String month = dateArr[1];
        getUiInstance().getElement(By.xpath(locators.lableDateDeparture), Constant.DEFAULT_TIMEOUT).click();
        getUiInstance().getElement(By.xpath(locators.celldate.replace("$month$", month).replace("$day$", day)), Constant.DEFAULT_TIMEOUT).click();
    }

    /**
     * It will select return date from retun calender
     * @param date
     */
    public void selectReturnDateFromCalender(String date){
        String[] dateArr = date.split("-");
        String day = dateArr[0];
        String month = dateArr[1];
        getUiInstance().getElement(By.xpath(locators.labelDateReyurn), Constant.DEFAULT_TIMEOUT).click();
        getUiInstance().getElement(By.xpath(locators.celldate.replace("$month$", month).replace("$day$", day)), Constant.DEFAULT_TIMEOUT).click();
    }

    /**
     * It will click on search button to search flights with all information.
     */
    public void clickSearchButton(){
        getUiInstance().getElement(By.xpath(locators.linkSearch), Constant.DEFAULT_TIMEOUT).clickUsingJs();
    }
}
