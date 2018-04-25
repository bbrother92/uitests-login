import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PanelPage;
import util.User;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LoginTest extends BaseTest {
	
	// login page url with russian language selected
	private static final String URL = "https://login.webim.ru/operator/login.php?admin_lang=ru";
	
	/**
	 * Login test
	 */
	@Test(invocationCount = 1)
	public void loginTest() {
		PanelPage panelPage = open(URL, LoginPage.class).login(User.Test.EMAIL, User.Test.PSWD);
		panelPage.dashboardHeader.shouldHave(Condition.text("Панель приборов"));
	}
	
	/**
	 * Login with wrong pass and email
	 */
	@Test(invocationCount = 1)
	public void loginWrongMailTest() {
		open(URL, LoginPage.class).login(User.NegativeTest.EMAIL, User.NegativeTest.PSWD);
		LoginPage loginPage = page(LoginPage.class);
		loginPage.alertField.shouldHave(Condition.text("Введите правильный адрес электронной почты и пароль"));
	}
	
	/**
	 * Login with empty pass
	 */
	@Test(invocationCount = 1)
	public void loginEmptyPassTest() {
		open(URL, LoginPage.class).login(User.NegativeTest2.EMAIL, User.NegativeTest2.PSWD);
		LoginPage loginPage = page(LoginPage.class);
		loginPage.alertField.shouldHave(Condition.text("Это поле обязательно!"));
	}
	
	/**
	 * Login with empty email
	 */
	@Test(invocationCount = 1)
	public void loginEmptyEmailTest() {
		open(URL, LoginPage.class).login(User.NegativeTest3.EMAIL, User.NegativeTest3.PSWD);
		LoginPage loginPage = page(LoginPage.class);
		loginPage.alertField.shouldHave(Condition.text("Это поле обязательно!"));
	}
}
