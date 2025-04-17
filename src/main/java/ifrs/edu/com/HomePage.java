package ifrs.edu.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * HomePage
 */
public class HomePage {
	private WebDriver driver;
	
	// text
	private By messageBy = By.name("message");
	// input
	private By messageInputBy = By.name("input-message");
	// button
	private By messageSendBy = By.name("send-message");
	// button
	private By linkProfileBy = By.name("link-profile-button");

	public HomePage(WebDriver driver){
		this.driver = driver;

		if (!driver.getTitle().equals("Home")) throw new IllegalStateException("Está não é a página Home, página atual: " + driver.getCurrentUrl());
	}

	public boolean sendMessage(String message){
		this.driver.findElement(messageInputBy).sendKeys(message);
		this.driver.findElement(messageSendBy).click();
		return this.driver.findElements(messageBy).stream().map(mess -> mess.getText()).filter(mess -> mess == message).count() > 0;
	}

	public ProfilePage toProfilePage(){
		this.driver.findElement(linkProfileBy).click();
		return new ProfilePage(driver);
	}
}
