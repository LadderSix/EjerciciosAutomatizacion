import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Tarea_bci_automatizacion {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Matias.Rojas\\Documents\\chromedriver.exe");

        //Crear un objeto de tipo webdriver
        WebDriver driver = new ChromeDriver();
        String url = "https://www.spotify.com/cl/signup";
        driver.get(url);
        driver.manage().window().maximize();

        //By correo = By.cssSelector("#email");
        By correo = By.xpath("//*[@id=\"email\"]");
        driver.findElement(correo).sendKeys("matias.rojasa@gmail.com");

        //By confirmaCorreo = By.cssSelector("#confirm");
        By confirmaCorreo = By.xpath("//*[@id=\"confirm\"]");
        driver.findElement(confirmaCorreo).sendKeys("matias.rojasa@gmail.com");

        By password = By.xpath("//*[@id=\"password\"]");
        driver.findElement(password).sendKeys("@Rojas651");

        By nombrePerfil = By.xpath("//*[@id=\"displayname\"]");
        driver.findElement(nombrePerfil).sendKeys("@Rojas651");

        By birthdayDay = By.xpath("//*[@id=\"day\"]");
        driver.findElement(birthdayDay).sendKeys("29");

        By birthdayMonth = By.xpath("//*[@id=\"month\"]");
        driver.findElement(birthdayDay).click();

        if (driver.findElement(birthdayDay).isDisplayed()){
            WebElement listaMeses = driver.findElement(birthdayMonth);
            Select dropdown = new Select(listaMeses);
            dropdown.selectByVisibleText("Abril");
        } else {
            System.out.println("Error!");
        }

        /*if (driver.findElement(birthdayDay).isDisplayed()) {
            WebElement listaMeses = driver.findElement(birthdayMonth);

            List<WebElement> options = listaMeses.findElements(By.tagName("option"));
            for (int i = 0; i < options.size(); i++) {
                System.out.println("Inicio recorrido");
                if (options.get(i).equals("Abril")) {
                    options.get(i).click();
                    System.out.println("mes actual " + options.get(i).getText());
                } else {
                    System.out.println("ERROR");
                }
            }
            System.out.println("fin recorrido");
        }*/

        By birthdayYear = By.xpath("//*[@id=\"year\"]");
        driver.findElement(birthdayYear).sendKeys("1992");
        Thread.sleep(1000);

        WebElement masculino = driver.findElement(By.xpath("//*[@id=\"gender_option_male\"]"));
        WebDriverWait wait = new WebDriverWait(driver,30);

        if(masculino.isEnabled()){
            wait.until(ExpectedConditions.elementToBeClickable(masculino));
            masculino.click();
            System.out.println("presionado");
        } else {
            System.out.println("error");
        }

    }
}
