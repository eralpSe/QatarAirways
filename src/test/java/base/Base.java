package base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Base {

    protected static AppiumDriver<MobileElement> appiumDriver;
    protected static WebDriverWait wait;



    protected boolean localAndroid=true;
    @BeforeScenario
    public void startScenario() throws MalformedURLException {
        if (localAndroid){
            System.out.println("------------------Local de Android Testi Başlıyor-------------");
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.m.qr");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.m.qr.home.main.ui.HomeActivity");
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,5000);
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            appiumDriver = new AppiumDriver(url,desiredCapabilities);

        }else{
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
            desiredCapabilities.setCapability(MobileCapabilityType.UDID,"İos udid bilgisi girilecek");
            desiredCapabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID,"Ios Uygulamasına ait bundle id bilgisi girilecek");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Lokalde kullanılan cihazın ismi girilecek");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"Localde kullanılan cihazın versiyon bilgisi girilecek");
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,3000);
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            appiumDriver = new IOSDriver(url,desiredCapabilities);
        }


        appiumDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(appiumDriver,20);


    }




    @AfterScenario
    public void afterScenario(){
        appiumDriver.quit();
    }



}
