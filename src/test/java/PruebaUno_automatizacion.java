import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.lang.ref.WeakReference;
import java.nio.file.Paths;
import java.util.List;

public class PruebaUno_automatizacion {
    private WebDriver driver;
    private WebDriverWait wait;
    private String url;

    @BeforeClass
    public void preparacionClase(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\matias.rojas\\Documents\\chromedriver.exe");
    }

    @BeforeMethod
    public void precondicionesTests() throws InterruptedException {
        driver = new ChromeDriver();
        url = "https://www.servipag.com";
        driver.get(url);
        Thread.sleep(2000);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,20);
    }
    @AfterMethod
    public void posTests(){
        driver.close();
    }

    @Test
    public void atc01_iniciarSesion(){
        By miServipag = By.xpath("//a[contains(text(),'Mi Servipag')]");
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

        /*driver.get("https://portal.servipag.com/private/profile");
        By miRut = By.xpath("//input[@formcontrolname='rut']");
        Assert.assertEquals("17555387-8", driver.findElement(miRut).getText());*/
    }
    @Test
    public void atc02_agregarCuenta(){
        atc01_iniciarSesion();

        By inscribirCuenta = By.xpath("//a[contains(text(),'Inscribir cuentas')]");
        WebElement btnInscribirCuenta = wait.until(ExpectedConditions.elementToBeClickable(inscribirCuenta));
        btnInscribirCuenta.click();

        //By buscarCuenta = By.name("InputSearch");
        By buscarCuenta = By.xpath("//body/modal-container[1]/div[1]/div[1]/modal-content[1]/div[1]/div[2]/app-add-account[1]/div[1]/div[1]/div[1]/div[1]/search-searchinput[1]/div[1]/div[1]/input[1]");
        WebElement input_BuscarCuenta = wait.until(ExpectedConditions.elementToBeClickable(buscarCuenta));
        input_BuscarCuenta.sendKeys("internet");
        input_BuscarCuenta.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);

        //By numeroCuenta = By.xpath("/html/body/modal-container/div/div/modal-content/div/div[2]/app-add-account/div/div/div/div/div[2]/div/section/div[2]/div[1]/input");
        By numeroCuenta = By.tagName("input");
        WebElement input_numeroCuenta = wait.until(ExpectedConditions.elementToBeClickable(numeroCuenta));
        input_numeroCuenta.sendKeys("562267260251");

        By agregar = By.xpath("//button[contains(text(),'Agregar')]");
        WebElement btnAgregar = wait.until(ExpectedConditions.elementToBeClickable(agregar));
        btnAgregar.click();

        By continuar = By.xpath("//a[contains(text(),'Continuar')]");
        WebElement btnContinuar = wait.until(ExpectedConditions.elementToBeClickable(continuar));
        btnContinuar.click();

        By aceptar = By.xpath("//button[contains(text(),'Aceptar')]");
        WebElement btnAceptar = wait.until(ExpectedConditions.elementToBeClickable(aceptar));
        btnAceptar.click();
    }
    @Test
    public void atc03_eliminarCuenta() throws InterruptedException {
        atc01_iniciarSesion();
        Thread.sleep(6000);

        By datos = By.xpath("//body[1]/main[1]/div[1]/div[1]/div[2]/div[2]/div[1]/private-dashboard[1]/private-dashboard-dashboard[1]/div[1]/div[1]");
        WebElement misDatos = driver.findElement(datos);
        System.out.println(misDatos.getText());

        List<WebElement> misCuentas = driver.findElements(By.xpath("//div[@class=\"id col-3 text-break\"]"));

        for (int i = 0; i < misCuentas.size(); i++ ) {
            if (misCuentas.get(i).getText().equals("562267260251")) {
                System.out.println(misCuentas.get(i).getText());
                Thread.sleep(1000);
                By borrar = By.xpath("//li[@class=\"delete\"]");
                WebElement btnBorrar = wait.until(ExpectedConditions.elementToBeClickable(borrar));

                btnBorrar.click();
                System.out.println("Click realizado !");

                By eliminar = By.xpath("//button[contains(text(),'Eliminar')]");
                WebElement btnEliminar = wait.until(ExpectedConditions.elementToBeClickable(eliminar));

                btnEliminar.click();
                System.out.println("Cuenta eliminada. !");

                break;
            } else {
                System.out.println(misCuentas.get(i).getText());
                System.out.println("Error dato no es correcto");
            }
        }

    }
    @Test
    public void atc04_pagoRapido() throws InterruptedException{

        By pagoRapido = By.xpath("//a[contains(text(),'Pago Rápido')]");
        WebElement btnPagoRapido = wait.until(ExpectedConditions.elementToBeClickable(pagoRapido));
        btnPagoRapido.click();
        Thread.sleep(3000);

        //By datos = By.xpath("//body[1]/main[1]/div[1]/div[3]/payment-root[1]/app-listado-servicios[1]/div[2]/div[1]/div[1]/div[1]/div[1]");
        //By datos = By.xpath("//div[@class=\"grid-2-3\"]");
        //WebElement misDatos = driver.findElement(datos);
        //System.out.println(misDatos.getText());

        List<WebElement> servicios = driver.findElements(By.tagName("lib-payment-card"));

        for (int i = 0; i < servicios.size(); i++ ) {
            if (servicios.get(i).getText().equals("Internet")) {
                System.out.println(servicios.get(i).getText());

                By miServicio = By.xpath("//body[1]/main[1]/div[1]/div[3]/payment-root[1]/app-listado-servicios[1]/div[2]/div[1]/div[1]/div[1]/div[1]/lib-payment-card[23]/app-category[1]/div[1]/a[1]/div[1]");
                WebElement btnMiServicio = wait.until(ExpectedConditions.elementToBeClickable(miServicio));
                btnMiServicio.click();

                System.out.println(".......!");
                break;
            } else {
                System.out.println(servicios.get(i).getText());
                System.out.println("Error");
            }
        }

        By select = By.tagName("select");

        if (driver.findElement(select).isDisplayed()){
            WebElement listadoServicios = driver.findElement(select);
            System.out.println(listadoServicios.getText());

            Select option = new Select(listadoServicios);
            option.selectByVisibleText("Movistar Hogar/Negocio Internet");
        } else {
            System.out.println("Error!");
        }


        By numeroCuenta = By.tagName("input");
        WebElement input_numeroCuenta = wait.until(ExpectedConditions.elementToBeClickable(numeroCuenta));
        input_numeroCuenta.sendKeys("562267260251");

        By continuar = By.xpath("//a[contains(text(),'Continuar')]");
        WebElement btnContinuar = wait.until(ExpectedConditions.elementToBeClickable(continuar));
        btnContinuar.click();

        By aceptar = By.xpath("//button[contains(text(),'Aceptar')]");
        WebElement btnAceptar = wait.until(ExpectedConditions.elementToBeClickable(aceptar));
        btnAceptar.click();

    }
    /*@Test
    public void atc05_pagoMultiple(){
        atc01_iniciarSesion();

    }*/

}
