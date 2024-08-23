import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class BaseTest {
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 5000;
    }

    @BeforeEach
    public void beforeClass() {
        setUp();
    }

    @AfterEach()
    public void afterClass() {
        Selenide.closeWebDriver();
    }
}
