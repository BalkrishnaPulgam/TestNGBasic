package practiceTestCase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TablePrint {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/pages/examples/users.html");

		List<WebElement> column = driver.findElements(By.xpath("//table[@class='table table-hover']/tbody/tr/th"));
		int columnsize = column.size();
		System.out.println(columnsize);

		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-hover']/tbody/tr"));

		int rowsize = rows.size();
		System.out.println(rowsize);

		for (int i = 1; i <= 1; i++) {
			for (int j = 1; j <= columnsize; j++) {
				String text = driver
						.findElement(By.xpath("//table[@class='table table-hover']/tbody/tr[" + i + "]/th[" + j + "]"))
						.getText();
				System.out.print(text + "   | ");

			}
			System.out.println();
		}

		for (int i = 2; i <= rowsize; i++) {
			for (int j = 1; j <= columnsize; j++) {
				String text = driver
						.findElement(By.xpath("//table[@class='table table-hover']/tbody/tr[" + i + "]/td[" + j + "]"))
						.getText();
				System.out.print(text + "   | ");

			}
			System.out.println();
		}

	}

}
