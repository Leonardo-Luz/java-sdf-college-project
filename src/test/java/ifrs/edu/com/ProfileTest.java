package ifrs.edu.com;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * ProfileTest
 */
public class ProfileTest {
	private WebDriver driver;
	private String username;
	private String password;

	@BeforeAll
	public void setup() {
		this.driver = new FirefoxDriver();
		driver.get("localhost:5173");

		this.username     = UUID.randomUUID().toString();
		this.password = UUID.randomUUID().toString();
	}

	@AfterAll
	public void end(){
		this.driver.close();
	}

	@Test
	public void signInTest(){
		LoginPage loginPage= new LoginPage(this.driver);
		SignInPage signInPage = loginPage.toSignInPage();

		signInPage.signInValidUser("This is a test USER", "99", this.username, this.password);
		//verify alert(user succefully created)
		//verify alert(user logged sucefully)
	}

	@Test
	public void logoutTest(){
		HomePage homePage = new HomePage(this.driver);
		ProfilePage profilePage = homePage.toProfilePage();

		profilePage.logout();
		// verify page title (login page)
	}

	@Test
	public void loginTest(){
		LoginPage loginPage= new LoginPage(this.driver);

		loginPage.loginValidUser(this.username, this.password);
		//verify alert(user logged successfully)
	}

	@Test
	public void sendMessageTest(){
		HomePage homePage = new HomePage(this.driver);

		assertTrue(homePage.sendMessage("textao"));
	}

	@Test
	public void clearMessagesTest(){
		HomePage homePage = new HomePage(this.driver);

		assertFalse(homePage.sendMessage("/clear"));
	}

	@Test
	public void deleteAccountTest(){
		HomePage homePage = new HomePage(this.driver);
		ProfilePage profilePage = homePage.toProfilePage();

		profilePage.deleteAccount(this.password);
		//verify alert(user succefully deleted)
	}

	@Test
	public void loginNotFoundTest(){
		LoginPage loginPage= new LoginPage(this.driver);

		loginPage.loginValidUser(this.username, this.password);
		//verify alert(login or password invalid)
	}
}
