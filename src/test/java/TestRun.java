import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

public class TestRun {

  @Test
  public void testRunWebAutomation() throws InterruptedException {
   // ChromeOptions options = new ChromeOptions();
    //setting chrome capabilities https://peter.sh/experiments/chromium-command-line-switches/
    //options.addArguments("--start-maximized,--incognito");
    WebDriver driver = new ChromeDriver();
//    //for mac it --start-maximized not working properly. So need use this command to maximize
    driver.manage().window().maximize();
    driver.get("https://www.atlasid.tech/");
    Thread.sleep(5000);
//    driver.quit();
  }
  public void testArgument() throws InterruptedException {
    ChromeOptions options = new ChromeOptions();
   // options.addArguments("--headless");
    options.addArguments("--start-maximized");

    WebDriver driver = new ChromeDriver(options);
    driver.get("https://www.atlasid.tech/");
    driver.manage().window().maximize();
    Thread.sleep(5000);

    driver.quit();
  }

  @Test
  public void findLocator() throws InterruptedException{
    WebDriver driver = new ChromeDriver();
    driver.get("http://gosoft.web.id/wonderfulQuote/");
    driver.manage().window().maximize();
//    driver.findElement(By.id("btn_basic_example"));
//    driver.findElement(By.className("btn btn-success btn-outline-rounded green"));
    driver.findElement(By.xpath("//a[@id='btn_basic_example']"));
  }

  @Test
  public void testTestCafe() throws InterruptedException{
    WebDriver driver = new ChromeDriver();
    driver.get("https://devexpress.github.io/testcafe/example/");
    driver.manage().window().maximize();
    WebElement buttonPopulate = driver.findElement(By.xpath("//input[@id='populate']"));
    buttonPopulate.click();
   // System.out.println(buttonPopulate.getText());
    Thread.sleep(2000);

    driver.switchTo().alert().accept();
    WebElement inputName = driver.findElement(By.xpath("//input[@id='developer-name']"));
    String name = inputName.getAttribute("value");
    System.out.println("name"  +name);
    Thread.sleep(5000);

    Assert.assertEquals("Peter Parker",name);

    WebElement checkBox1 = driver.findElement(By.xpath("//input[@id='remote-testing']"));
    checkBox1.click();
    WebElement checkBox2 = driver.findElement(By.xpath("//input[@id='background-parallel-testing']"));
    checkBox2.click();

    Assert.assertTrue(checkBox1.isSelected());
    Assert.assertTrue(checkBox2.isSelected());


    WebElement dropDown = driver.findElement(By.xpath("//select[@id='preferred-interface']"));
    Select select = new Select(dropDown);
    int index = 1;
    select.selectByIndex(1);
    String textDropDown = select.getOptions().get(index).getText();
    Thread.sleep(5);
    Assert.assertEquals("JavaScript API", textDropDown);

    WebElement cbTestCafe = driver.findElement(By.xpath("//input[@id='tried-test-cafe']"));
    cbTestCafe.click();
    WebElement slider = driver.findElement(By.xpath("//div[@id='slider']"));
    Actions actions = new Actions(driver);
    Thread.sleep(2000);
    actions.dragAndDropBy(slider, 30, 0).build().perform();
    Thread.sleep(5000);
    driver.quit();
  }

}
