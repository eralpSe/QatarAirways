package Pages;

import io.appium.java_client.MobileBy;
import methods.Methods;

public class SummaryPage extends Methods {


    public static final MobileBy departureTimeTwo = (MobileBy) MobileBy.id("com.m.qr:id/from_time");
    public static final MobileBy arrivalTimeTwo = (MobileBy) MobileBy.id("ccom.m.qr:id/to_time");
    public void timeDurations(){

        getText(departureTimeTwo);
        getText(arrivalTimeTwo);
    }
}
