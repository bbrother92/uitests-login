package pages;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$x;

/**
 * "*.webim.ru/operator/"
 */
public class PanelPage {
	Logger logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
	
	/**
	 * table title
	 */
	public SelenideElement dashboardHeader = $x("//section/h2");
	
}
