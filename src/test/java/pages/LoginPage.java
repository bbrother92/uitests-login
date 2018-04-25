package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

/**
 * "https://login.webim.ru/operator/login.php" page
 */
public class LoginPage {
	
	/**
	 * Login form fields
	 */
	private SelenideElement loginEmail = $x("//*[@id='login_or_email']");
	private SelenideElement loginPassword = $x("//input[@name='password']");
	private SelenideElement loginButton = $x("//button[@type='submit']");
	
	// status selector
	private SelenideElement statusButton = $("button.selectpicker");
	private SelenideElement statusSelector = $x("//a[contains(., 'Оффлайн')]");
	
	// wrong email and pass alert
	public SelenideElement alertField = $("div.alert");
	
	
	public PanelPage login(String email, String password) {
		loginEmail.setValue(email);
		loginPassword.setValue(password);
		statusButton.waitUntil(Condition.visible, 7000).click();
		screenshot("here");
		statusSelector.waitUntil(Condition.visible,7000).click();
		loginButton.waitUntil(Condition.visible, 7000).click(); // or just we could press enter
		return page(PanelPage.class);
		
	}
	
}
