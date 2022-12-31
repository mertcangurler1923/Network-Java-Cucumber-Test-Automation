package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class NetworkPage extends BasePage{
    By cookie= By.id("onetrust-accept-btn-handler");
    By searchTextbox= By.cssSelector("form[id='search-form'] input[id='search']");
    By allPercentList=By.cssSelector("div[id*='product-1']");
    By discountPercent=By.cssSelector("div [class='product__discountPercent']");
    By size=By.cssSelector("div[class='product__size -productCart radio-box'] label[class='radio-box__label']");
    By goToCard=By.cssSelector("a[class*='button -primary header_']");
    By boxDiscountMoney=By.cssSelector("span[class='cartItem__price -sale']");
    By boxNotDiscountMoney=By.cssSelector("span[class='cartItem__price -old -labelPrice']");
    By boxSize=By.cssSelector("div[class='cartItem__attr -size'] span[class='cartItem__attrValue']");
    By showMore=By.cssSelector("button[class='button -secondary -sm relative']");
    By mailBox=By.cssSelector("input[class='input js-trim']");
    By passwordBox=By.cssSelector("input[class='input']");
    By login=By.cssSelector("button[type='submit']");
    By goOn=By.cssSelector("div[class='summary'] button[type='button']");
    By network=By.cssSelector("svg[class='img-fluid']");
    By box=By.cssSelector("button > svg[class='header__icon -shoppingBag']");
    By boxTrash=By.cssSelector("svg[class='header__basketProductRemove'] > use");
    By boxTrashYes=By.cssSelector("button[class='btn -black o-removeCartModal__button']");
    By boxEmpty=By.cssSelector("span[class='header__emptyBasketText']");
    List<String> data=new ArrayList<>();
    List<List<By>> discountPercentCard= new ArrayList<>();

    public List<String> data(){
        return data;
    }
    public NetworkPage(WebDriver driver) {
        super(driver);
    }
    public void networkHomepage(){
        driver.get("https://www.network.com.tr/");
        cookie(cookie);
    }
    public List<String> networkHomepageChecked(){
        data.add(getlocation());
        return data;
    }
    public void inputJacket(){
        inputEnter(searchTextbox,"ceket");
    }
    public void showMore(){
        scrollToPage(showMore);
        click(showMore);
    }
    public List<String> twoPageCheck(){
        data.add(getlocation());
        return data;
    }
    public void discountPercentClick(){
        discountPercentCard=discountPercentLocatorFind(allPercentList);
        scrollToPage(discountPercentCard.get(0).get(0));
        String afterSizeValue=getAttribute(discountPercentCard.get(1).get(0),"for");
        String afterMoneyValue=getText(discountPercentCard.get(2).get(0));
        data.add(afterMoneyValue);
        data.add(afterSizeValue);
        moveToElement(discountPercentCard.get(0).get(0));
        scrollToPage(discountPercentCard.get(1).get(0));
        click(discountPercentCard.get(1).get(0));
    }
    public void goToCard(){
        click(goToCard);
    }
    public void productPrice(){
        String boxSizeValue=getText(boxSize);
        String boxDiscountMoneyValue=getText(boxDiscountMoney);
        String boxNotDiscountMoneyValue=getText(boxNotDiscountMoney);
        data.add(boxDiscountMoneyValue);
        data.add(boxSizeValue);
        data.add(boxNotDiscountMoneyValue);
    }
    public void goOn(){
        click(goOn);
    }
    public void idPassword() throws FileNotFoundException{
        List<String> idPassword=csvRead();
        input(mailBox,idPassword.get(0));
        input(passwordBox,idPassword.get(1));
        data.add(wait(login));
        click(login);
    }
    public void networkLogo(){
        click(network);
    }
    public void box(){
        click(box);
    }
    public List<String> boxTrash(){
        click(boxTrash);
        click(boxTrashYes);
        click(box);
        sleep(2000);
        String boxEmptyValue=getText(boxEmpty);
        data.add(boxEmptyValue);
        return data;
    }
}
