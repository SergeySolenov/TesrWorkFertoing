import framework.utils.PropsReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import pages.PublicPage;

public class PublicPageTest extends BaseTest {
    private final Logger log = LogManager.getLogger("AutomationFramework");

    @Test
    public void verifyButtonTest() {
        log.info("Открываем нужную страницу");
        PublicPage publicPage = new PublicPage(PropsReader.getProperty("URL"));
        log.info("Клик на кнопку продукты и проверка результата");
        publicPage.clickAndCheckProd();
        log.info("Клик на кнопку 'Конструктор визитки' и проверка результата");
        publicPage.clickAndCheckVis();
    }
    @Test
    public void fillFormTest() {
        log.info("Открываем нужную страницу");
        PublicPage publicPage = new PublicPage(PropsReader.getProperty("URL"));
        log.info("Открываем нужную страницу");
        publicPage.clickAndSwap();
        publicPage.sendData();
        publicPage.checkResults();


    }
}
