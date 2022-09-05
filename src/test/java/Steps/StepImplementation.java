package Steps;

import Pages.BookPage;
import Pages.HomePage;
import Pages.SummaryPage;
import Pages.WelcomePage;
import base.Base;
import com.thoughtworks.gauge.Step;


public class StepImplementation extends Base {
BookPage bookPage = new BookPage();
HomePage homePage = new HomePage();
SummaryPage summaryPage = new SummaryPage();
WelcomePage welcomePage = new WelcomePage();


    @Step("Uygulamanın acildigi kontrol edildi")
    public void isAppOpen(){
        welcomePage.pageControl();
    }
    @Step("Karsılama ekranı skip edildi")
    public void skipWellcomePage() {
        welcomePage.skipPage();
        }
    @Step("Alt menuden book tabına gecis yapildi")
    public void crossToBookTab(){
        homePage.clickBookButton();
    }
    @Step("Seyahat tipi olarak OneWay secildi")
    public void chooseOneWay(){
    bookPage.selectOneWay();
    }
    @Step("Kalkis havaalanı Berlin secildi")
    public void chooseFirstAirLand(){
    bookPage.pickFromLocation();
    bookPage.enterFromLocation();
    }
    @Step("Varis havaalanı Istanbul secildi")
    public void chooseLastAirLand(){
        bookPage.enterToLocation();

    }
    @Step("Economy class secenegine tiklandı")
    public void pickEconomyClass(){
    bookPage.selectEconomyClass();
    }
    @Step("Gidis tarihi secildi")
    public void selectDate(){
    bookPage.selectDate();
    }
    @Step("Arama butonu ile ucuslar arandı")
    public void findAirplanes(){
        bookPage.searchFlights();
    }
    @Step("Rastgele ucus secildi")
    public void selectRandomAirplane(){
        bookPage.selectRandomFlyList();
        bookPage.clickFareButton();
    }
    @Step("Ucus ekranı yuklenmesi kontrolu yapılır")
    public void flyListControl(){
        bookPage.assertionForFlyListScreen();
    }
    @Step("Ucus secim ekranı degerleri ile Ucus detay degerleri kontrolü yapıldı")
    public void assertionDatas(){
        summaryPage.timeDurations();
    }



}
