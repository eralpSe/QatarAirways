package Pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BookPage extends Methods {
    public static final MobileBy fromLocation = (MobileBy) MobileBy.id("com.m.qr:id/rvmp_fragment_rtow_flight_selection_origin_holder");
    public static final MobileBy toLocation = (MobileBy) MobileBy.id("com.m.qr:id/rvmp_fragment_rtow_flight_selection_destination_select_destination_text_view");
    public static final MobileBy oneWay = (MobileBy) MobileBy.xpath("//*[@content-desc=\"One-way\"");
    public static final MobileBy fromLocationTextArea = (MobileBy) MobileBy.id("com.m.qr:id/rvmp_fragment_ond_selection_filter_edittext");
    public static final MobileBy toLocationTextArea = (MobileBy) MobileBy.id("com.m.qr:id/rvmp_fragment_ond_selection_filter_edittext");
    public static final MobileBy selectBerlin = (MobileBy) MobileBy.xpath("//*[@text='Berlin, Germany'][1]");
    public static final MobileBy selectIstanbul = (MobileBy) MobileBy.xpath("//*[@text='Istanbul, Turkey'][1]");
    public static final MobileBy dateSelect = (MobileBy) MobileBy.id("com.m.qr:id/rvmp_fragment_rtow_flight_selection_departure_date_holder");
    public static final MobileBy daySelect = (MobileBy) MobileBy.xpath("//*[@text='12']");
    public static final MobileBy calendarConfirmButton = (MobileBy) MobileBy.id("com.m.qr:id/fragment_calendar_confirm_button");
    public static final MobileBy selectEconomyMenu = (MobileBy) MobileBy.id("com.m.qr:id/fragment_rtow_flight_cabin_class_text_view");
    public static final MobileBy selectEconomyClass = (MobileBy) MobileBy.xpath("//*[@resource-id='com.m.qr:id/cabin_selection_economy_row']");
    public static final MobileBy flyingList = (MobileBy) MobileBy.id("com.m.qr:id/rvmp_fragment_search_result_list");
    public static final MobileBy searchFlights = (MobileBy) MobileBy.id("com.m.qr:id/rvmp_booking_search_flights_button");
    public static final MobileBy departureScreenCheckText = (MobileBy) MobileBy.xpath("//*[@text='Select your departure']");
    public static final MobileBy selectThisFareButton = (MobileBy) MobileBy.id("com.m.qr:id/rvmp_activity_flight_details_select_button");







    public void selectOneWay(){
        clickElement(oneWay);
    }
    public void pickFromLocation(){
        clickElement(fromLocation);
        }
    public void enterFromLocation(){
        clickElement(fromLocationTextArea);
        sendKeys(fromLocationTextArea,"Berlin");
        clickElement(selectBerlin);
    }

    public void enterToLocation(){
        clickElement(toLocation);
        clickElement(toLocationTextArea);
        sendKeys(toLocationTextArea,"Istanbul");
        clickElement(selectIstanbul);
    }
    public void selectDate(){
        clickElement(dateSelect);
        clickElement(daySelect);
        clickElement(calendarConfirmButton);
    }
    public void selectEconomyClass(){
        clickElement(selectEconomyMenu);
        clickElement(selectEconomyClass);
    }
    public void searchFlights(){
        clickElement(searchFlights);

    }
    public void assertionForFlyListScreen(){
        Assert.assertEquals("Uçuş listesi ekranı yüklenemedi","Select your departure",getText(departureScreenCheckText));
    }
    public void randomFlyPickClick( MobileBy by) {

            int a = randomPick(findElements(by).size());
            MobileElement element = findElements(by).get(a);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            MobileBy departureTimeOne;
            departureTimeOne = (MobileBy) by.xpath(element+ "/[@resource-id='com.m.qr:id/rvmp_departure_time']");
            String dprtureOne = getText(departureTimeOne);
            MobileBy arrivalTimeOne;
            arrivalTimeOne = (MobileBy) by.xpath(element+ "/[@resource-id='com.m.qr:id/rvmp_arrival_time']");
            String arrvlone= getText(arrivalTimeOne);
            element.click();
    }


    public void selectRandomFlyList(){
        randomFlyPickClick(flyingList);
    }
    public void clickFareButton() {
        clickElement(selectThisFareButton);
    }


}
