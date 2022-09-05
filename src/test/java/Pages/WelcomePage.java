package Pages;

import io.appium.java_client.MobileBy;
import methods.Methods;


public class WelcomePage extends Methods {

    public static final MobileBy skipButton = (MobileBy) MobileBy.id("com.m.qr:id/push_consent_decline");
    public static final MobileBy wellcomeScreen = (MobileBy) MobileBy.id("com.m.qr:id/push_consent_msg_header");


    public void pageControl(){
        pageControl(wellcomeScreen);
    }
    public void skipPage(){
        clickElement(skipButton);
    }





}
