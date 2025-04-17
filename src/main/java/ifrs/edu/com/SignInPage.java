package ifrs.edu.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * SignInPage
 */
public class SignInPage {
	private WebDriver driver;

	// <input type="text" class="form-input" name="name">
	private By nameInputBy = By.name("name");
	// <input type="number" class="form-input" name="age">
	private By ageInputBy = By.name("age");
	// <input type="text" class="form-input" name="username">
	private By usernameInputBy = By.name("username");
	// <input type="password" class="form-input" name="password">
	private By passwordInputBy = By.name("password");
	// <input class="form-button" type="submit" value="Cadastrar">
	private By SignInBy = By.className("form-button");
	// <a class="form-to-link" href="/login">Já possui uma conta?
	// <em>Entre!</em></a>
	private By linkLoginBy = By.className("link-to-link");

	public SignInPage(WebDriver driver) {
		this.driver = driver;

		if (!driver.getTitle().equals("SignIn"))
			throw new IllegalStateException(
					"Está não é a página SignIn, página atual: " + driver.getCurrentUrl());
	}

	public HomePage signInValidUser(String name, String age, String username, String password) {
		this.driver.findElement(nameInputBy).sendKeys(name);
		this.driver.findElement(ageInputBy).sendKeys(age);
		this.driver.findElement(usernameInputBy).sendKeys(username);
		this.driver.findElement(passwordInputBy).sendKeys(password);

		this.driver.findElement(SignInBy).click();

		return new HomePage(driver);
	}

	public LoginPage toLoginPage() {
		this.driver.findElement(linkLoginBy).click();
		return new LoginPage(driver);
	}
}
