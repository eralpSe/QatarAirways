package methods;

import base.Base;
import base.Log;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;
import java.util.Random;


public class Methods extends Base  {



    public MobileElement findElement(MobileBy by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        Log.info(by +" Element bulundu.");
        return appiumDriver.findElement(by);
    }


    public List<MobileElement> findElements(MobileBy by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        Log.info(by +" Elementler bulundu.");

        return appiumDriver.findElements(by);
    }
    public int randomPick(int size) {
        Random rand = new Random();
        int minimum = 1;
        int pick = rand.nextInt(size - minimum) + minimum;
        return pick;
    }


    public void clickElement(MobileBy by){
            findElement(by).click();
        Log.info(by +" Element tıklandı.");

            }


    public void sendKeys(MobileBy by, String text) {

        findElement(by).sendKeys(text);
        Log.info(text +" text girildi.");
    }

    public void pageControl(MobileBy by){
        Assert.assertTrue("Sayfa bulunamadı.", findElement(by).isDisplayed());
        Log.info(by +" sayfa yüklendiği kontrol edildi.");
    }

    public String getText(MobileBy by)    {
        Log.info(by +" elementten text çekildi.");
        return findElement(by).getText();

    }

    public void waitByMilliSeconds(long milliSeconds){

        try {
            Thread.sleep(milliSeconds);
            Log.info(milliSeconds +" milisaniye beklendi.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public void swipeByUp(){
        final int ANIMATION_TIME = 200; // ms
        final int PRESS_TIME = 200; // ms

        int edgeBorder = 300; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;
        Dimension dims = appiumDriver.manage().window().getSize();
        System.out.println("dims====="+ dims);
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
        pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);

        new TouchAction(appiumDriver)
                .press(pointOptionStart)
                // a bit more reliable when we add small wait
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                .moveTo(pointOptionEnd)
                .release().perform();
    }


}




