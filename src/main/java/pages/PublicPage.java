package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import framework.utils.PropsReader;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PublicPage {
    private final SelenideElement prodButton = $x("//li[2]/a/span");
    private final SelenideElement prodTitle = $(".products product-card h2:first-of-type");
    private final SelenideElement visButton = $x("//p[text() = 'Конструктор визитки']/..");
    private final SelenideElement modalWindow = $x("//product-feature-dialog");
    private final SelenideElement contactButton1 = $x("//li/a/span[text() = 'Контакты']");
    private final SelenideElement contactButton2 = $x("//span[contains(text(), 'Связаться с нами')]");
    private final SelenideElement inputFio = $("input[formcontrolname='fio']");
    private final SelenideElement inputEmail = $("input[formcontrolname='email']");
    private final SelenideElement inputPhone = $("input[formcontrolname='phone']");
    private final SelenideElement inputCode = $("input[formcontrolname='code']");
    private final SelenideElement checkBox1 = $x("//input[@id='mat-mdc-checkbox-1-input']");
    private final SelenideElement checkBox2 = $x("//input[@id='mat-mdc-checkbox-2-input']");
    private final SelenideElement checkBox3 = $x("//input[@id='mat-mdc-checkbox-3-input']");
    private final SelenideElement buttonSubmit1 = $x("//form/button");
    private final SelenideElement buttonSubmit2 = $("div.footer > button:last-of-type");


    public PublicPage(String link) {
        Selenide.open(link);
    }

    public void clickAndCheckProd() {
        prodButton.click();
        Assertions.assertTrue(prodTitle.isDisplayed());
    }

    public void clickAndCheckVis() {
        visButton.scrollTo();
        visButton.click();
        Assertions.assertTrue(modalWindow.isDisplayed());
    }

    public void clickAndSwap() {
        contactButton1.click();
        contactButton2.click();
        Selenide.switchTo().activeElement();
    }

    public void sendData() {
        buttonSubmit1.shouldHave(disabled);
        buttonSubmit1.shouldHave(disabled);
        inputFio.sendKeys(PropsReader.getProperty("FIO"));
        inputEmail.sendKeys(PropsReader.getProperty("EMAIL"));
        inputPhone.sendKeys(PropsReader.getProperty("PHONE"));
        inputCode.sendKeys(PropsReader.getProperty("CODE"));
        checkBox1.click();
        checkBox2.click();
        checkBox3.click();
    }

    public void checkResults() {
        buttonSubmit1.shouldNotHave(disabled);
        buttonSubmit2.shouldNotHave(disabled);
    }

}
