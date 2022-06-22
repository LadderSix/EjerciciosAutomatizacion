import net.bytebuddy.description.type.TypeDescription;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.ref.WeakReference;
import java.nio.file.Paths;

public class PruebaUno_automatizacion {
    private WebDriver driver;
    private WebDriverWait wait;
    private String url;

    @BeforeClass
    public void preparacionClase(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Matias.Rojas\\Documents\\chromedriver.exe");
    }
    @BeforeMethod
    public void precondicionesTests() throws InterruptedException {
        driver = new ChromeDriver();
        url = "https://www.servipag.com";
        driver.get(url);
        Thread.sleep(3000);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,20);
    }
    @AfterMethod
    public void posTests(){
        driver.close();
    }

    @Test
    public void atc01_iniciarSesion(){
        By miServipag = By.xpath("//*[@id=\"single-spa-application:@servipagFenix/header\"]/header-root/header-home/header/div/div/nav[3]/ul/li[1]/a");
        WebElement btnMiServipag = wait.until(ExpectedConditions.elementToBeClickable(miServipag));
        btnMiServipag.click();

        By rut = By.name("username");
        WebElement input_Rut = wait.until(ExpectedConditions.elementToBeClickable(rut));
        input_Rut.sendKeys("175553878");

        By password = By.xpath("/html/body/modal-container/div/div/login-modal-login/div/div[2]/form/section/div[2]/input");
        WebElement input_Password = wait.until(ExpectedConditions.elementToBeClickable(password));
        input_Password.sendKeys("Rojas651");

        By ingresar = By.xpath("/html/body/modal-container/div/div/login-modal-login/div/div[2]/form/section/button");
        WebElement btnIngresar = wait.until(ExpectedConditions.elementToBeClickable(ingresar));
        btnIngresar.click();
    }

}
