package Pages;

import io.appium.java_client.MobileBy;
import methods.Methods;

public class HomePage extends Methods {

    public static final MobileBy bookButton = (MobileBy) MobileBy.id("com.m.qr:id/nav_menu_book");

    public void clickBookButton(){
        clickElement(bookButton);
    }
}
