package ifrs.edu.com;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ProfilePage
 */
public class ProfilePage {
	private WebDriver driver;

	// button
	private By logoutBy = By.name("logout-button");
	// button
	private By deleteAccountBy = By.name("delete-account-button");

	public ProfilePage(WebDriver driver) {
		this.driver = driver;

		if (!driver.getTitle().equals("Profile"))
			throw new IllegalStateException(
					"Está não é a página Profile, página atual: " + driver.getCurrentUrl());
	}

	public LoginPage logout() {
		this.driver.findElement(logoutBy).click();
		return new LoginPage(driver);
	}

	public LoginPage deleteAccount(String password) {
		this.driver.findElement(deleteAccountBy).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		alert.sendKeys(password);
		alert.accept();

		return new LoginPage(driver);
	}
}
