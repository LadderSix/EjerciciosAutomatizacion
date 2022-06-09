import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Tarea_bci_automatizacion {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Matias.Rojas\\Documents\\chromedriver.exe");

        //Crear un objeto de tipo webdriver
        WebDriver driver = new ChromeDriver();
        String url = "https://www.spotify.com/cl/signup";
        driver.get(url);

        //By correo = By.cssSelector("#email");
        By correo = By.xpath("//*[@id=\"email\"]");
        driver.findElement(correo).sendKeys("matias.rojas@gmail.com");

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
        WebElement listaMeses = driver.findElement(birthdayMonth);

        //Select dropdown = new Select(listaMeses);
        //dropdown.deselectByVisibleText("Abril");

        List<WebElement> options = listaMeses.findElements(By.tagName("option"));
        for (int i=0; i < options.size(); i++){
            if (options.get(i).equals("Abril")){
                options.get(i).click();
            }

        }








    }


}
