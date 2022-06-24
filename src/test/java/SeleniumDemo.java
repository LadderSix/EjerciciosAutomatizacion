import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Paths;

public class SeleniumDemo {
    public static void main(String[] args)throws InterruptedException {
        //Crear ruta para apuntar al wevbdriver
        /*String path = Paths.get(System.getProperty("user.dir"),"\\src\\main\\resources\\drivers\\chromedriver.exe").toString();
        System.setProperty("webdriver.chrome.driver",path);*/
        System.setProperty("webdriver.chrome.driver","C:\\Users\\matias.rojas\\Documents\\chromedriver.exe");

        //Crear un objeto de tipo webdriver
        WebDriver driver = new ChromeDriver();

        String url = "https://www.google.cl";
        driver.get(url);

        System.out.println("Titulo de la página: "+ driver.getTitle());

        System.out.println("URL de la página: "+ driver.getCurrentUrl());

        Thread.sleep(2000);

        driver.navigate().to("https://www.bci.cl");

        System.out.println("Titulo de la página: "+ driver.getTitle());

        System.out.println("URL de la página: "+ driver.getCurrentUrl());

        Thread.sleep(2000);

        driver.navigate().refresh();

        driver.navigate().back();

        Thread.sleep(2000);

        By localorTxtBusquedaGoogle = By.name("q");

        WebElement txtBusquedaGoogle = driver.findElement(localorTxtBusquedaGoogle);

        txtBusquedaGoogle.sendKeys("BCIfsefsa");

        Thread.sleep(2000);

        txtBusquedaGoogle.clear();

        Thread.sleep(2000);

        txtBusquedaGoogle.sendKeys("BCI");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[3]/center[1]/input[1]")).submit();

        driver.close();


    }
}
