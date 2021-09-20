package pages;

import core.BaseFunc;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage {
    private final By TOP_LEVEL_MENU_WOMENS = By.id("lnkTopLevelMenu_2192386");
    private final By COLLAPSE_MENU_FOOTWEAR = By.xpath(".//a[@href='#collapse4_dsk']");
    private final By MENU_WOMENS_TRAINERS = By.xpath(".//a[@href='/ladies/footwear/trainers']");
    private final By WOMENS_TRAINERS = By.xpath(".//img[@alt='Nike - Revolution 5 Women']");
    private final By TRAINERS_SIZES = By.id("ancLink");
    private final By PRODUCT_QUANTITY = By.id("ProductQty");
    private final By ADD_TO_BAG = By.id("aAddToBag");
    private final By BAG = By.id("aBagLink");
    private final By BAG_HEADER = By.id("BasketHeaderText");
    private final By TOP_HEADER = By.xpath(".//div[contains(@class,'topCatHeader')]");
    private final By SELLING_PRICE = By.id("lblSellingPrice");
    private final By PRICE_IN_BAG = By.xpath("//*[@id='gvBasketDetails']/table/tbody/tr/td[5]/span[2]");
    private final By QUANTITY_IN_BAG = By.id("Lines_0__Quantity");
    private final By CONTINUE_SECURELY = By.id("divContinueSecurely");


    public BaseFunc baseFunc;
    String productQuantity = "1";
    String productQuantityInBag;
    String sellingPrice;
    String priceInBag;
    String url = "https://lv.sportsdirect.com/";

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;

    }

    public void goToSportDirectPage() {
        baseFunc.goToUrl(url);
        assertTrue(baseFunc.findElement(TOP_HEADER).isDisplayed(), "Not SPORT DIRECT Page");
    }

    public void goToWomens() {
        baseFunc.waitClick(TOP_LEVEL_MENU_WOMENS);
    }

    public void goToWomensFootwear() {
        baseFunc.waitClick(COLLAPSE_MENU_FOOTWEAR);
    }

    public void goToWomentsTrainers() {
        baseFunc.clickOnElementById(0, MENU_WOMENS_TRAINERS);
    }

    public void selectWomensTrainers() {
        baseFunc.waitClick(WOMENS_TRAINERS);
        sellingPrice = baseFunc.findElement(SELLING_PRICE).getText();
    }

    public void selectTrainersSize() {
        baseFunc.clickOnElementInListByName(TRAINERS_SIZES, "4 (37.5)");
    }

    public void insertTrainersQuantity() {
        baseFunc.typeToField(PRODUCT_QUANTITY, productQuantity);
    }

    public void addToBag() {
        baseFunc.waitClick(ADD_TO_BAG);

    }

    public void goToBag() {
        baseFunc.waitClick(BAG);
        assertTrue(baseFunc.findElement(BAG_HEADER).isDisplayed(), "Not a Shopping Bag");
        priceInBag = baseFunc.findElement(PRICE_IN_BAG).getText();
        Assertions.assertEquals(sellingPrice, priceInBag, "Prices in bag differ from selling price");
        productQuantityInBag = baseFunc.findElement(QUANTITY_IN_BAG).getText();
    }
    public void continueSecurely(){
        baseFunc.waitClick(CONTINUE_SECURELY);
    }

    public void finishShopping() {
        baseFunc.quitBrowser();
    }
}
