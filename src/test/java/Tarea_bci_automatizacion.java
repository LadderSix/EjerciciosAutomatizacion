import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

        // Seleccion de genero masculino -> Radiobutton
        //WebElement masculino = driver.findElement(By.xpath("//input[@id=\"gender_option_male\"]"));
        /* WebDriverWait wait = new WebDriverWait(driver,200);
        if(masculino.isDisplayed()){
           // wait.until(ExpectedConditions.elementToBeClickable(masculino));
            Thread.sleep(15000);
            masculino.click();
            System.out.println("presionado");
        } else {
            System.out.println("error");
        }*/
        //WebElement masculino = driver.findElement(By.cssSelector("#gender_option_male"));
        //WebDriverWait wait = new WebDriverWait(driver, 30);
        //wait.until(ExpectedConditions.elementToBeClickable(masculino));
        //masculino.click();

        Thread.sleep(2000);
        WebElement masculino = driver.findElement(By.xpath("//input[@id=\"gender_option_male\"]"));
        JavascriptExecutor executor =(JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", masculino);
        System.out.println(masculino.isSelected());


        Thread.sleep(2000);
        WebElement input = driver.findElement(By.id("marketing-opt-checkbox"));
        WebElement span = driver.findElement(By.xpath("//body/div[@id='__next']/main[1]/div[1]/div[1]/form[1]/div[6]/div[1]/label[1]/span[1]"));
        boolean b = input.isSelected();
        System.out.println(b);
        if(!b){
            span.click();
        }

        Thread.sleep(2000);
        WebElement input2 = driver.findElement(By.id("third-party-checkbox"));
        WebElement span2 = driver.findElement(By.xpath("//body/div[@id='__next']/main[1]/div[1]/div[1]/form[1]/div[7]/div[1]/label[1]/span[1]"));
        boolean b2 = input2.isSelected();
        System.out.println(b);
        if(!b2){
            span2.click();
        }

        WebElement btnRegister = driver.findElement(By.xpath("//body/div[@id='__next']/main[1]/div[1]/div[1]/form[1]/div[9]/div[1]/button[1]"));
        btnRegister.submit();

        WebElement robotConfirm = driver.findElement(By.xpath("//body/div[@id='__next']/main[1]/div[1]/div[1]/form[1]/div[8]/div[2]"));
        Assert.assertEquals("Confirma que no eres un robot.",robotConfirm.getText());




    }
}
