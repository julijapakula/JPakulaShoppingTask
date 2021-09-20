package pages;

import core.BaseFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class PurchaseTest {
    private static final Logger LOGGER = LogManager.getLogger(PurchaseTest.class);
    public BaseFunc baseFunc = new BaseFunc();
    public HomePage homePage = new HomePage(baseFunc);

    @Test
    public void purchaseWomensTrainers() {
        LOGGER.info("Opening SportDirect web-page");
        homePage.goToSportDirectPage();
        LOGGER.info("Going to the Women department");
        homePage.goToWomens();
        LOGGER.info("Selecting Women footwear section");
        homePage.goToWomensFootwear();
        LOGGER.info("Selecting type of Women footwear - trainers");
        homePage.goToWomentsTrainers();
        LOGGER.info("Selecting model of Women trainers - NIKE Revolution 5 Women's Running Shoe");
        homePage.selectWomensTrainers();
        LOGGER.info("Selecting size of selected trainers - 37.5");
        homePage.selectTrainersSize();
        LOGGER.info("Selecting quantity of selected trainers - 1");
        homePage.insertTrainersQuantity();
        LOGGER.info("Adding trainers to the shopping bag");
        homePage.addToBag();
        LOGGER.info("Going to the shopping bag, comparing product price and quantity ");
        homePage.goToBag();
        LOGGER.info("Proceeding from the shopping bag");
        homePage.continueSecurely();
        //LOGGER.info("Shopping is finished");
        // homePage.finishShopping();
    }
}
