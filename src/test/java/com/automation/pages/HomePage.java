package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * @author cbuelvasc
 */
public class HomePage extends BasePage {

    @FindBy(id = "yt-masthead-signin")
    private WebElement loginButton;

    @FindBy(id = "Email")
    private WebElement boxEmail;

    @FindBy(name = "Passwd")
    private WebElement boxPass;

    @FindBy(id = "signIn")
    private WebElement signInButton;

    @FindBy(id = "next")
    private WebElement nextButton;

    @FindBy(css = "#masthead-search-term")
    public WebElement searchBox;

    @FindBy(id = "search-btn")
    private WebElement searchButton;

    private WebElement elementList;

    private WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * @param email
     * @param pass
     * @param criterioBusqueda
     * @param urlCancion
     */
    public void searchVideo(String email, String pass, String criterioBusqueda, String urlCancion) {
        this.loginButton.click();
        this.boxEmail.sendKeys(email);
        this.nextButton.click();
        this.boxPass.sendKeys(pass);
        this.signInButton.click();
        this.searchBox.sendKeys(criterioBusqueda);
        this.searchButton.click();
        this.elementList = this.extracToWebElement(
                webDriver.findElements(By.xpath(".//*[@id='results']/ol/li[2]/ol/li/div/div/div[2]/h3/a")), urlCancion);
        this.elementList.click();
    }

    /**
     * @param webElements
     * @param urlCancion
     * @return
     */
    public WebElement extracToWebElement(List<WebElement> webElements, String urlCancion) {
        WebElement webElementSpecific = null;
        for (WebElement webElement : webElements) {
            if (urlCancion.equals(webElement.getAttribute("href"))) {
                webElementSpecific = webElement;
                break;
            }
        }
        return webElementSpecific;
    }
}
