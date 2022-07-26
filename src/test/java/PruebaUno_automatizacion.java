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
        wait = new WebDriverWait(driver,30);
    }
    @AfterMethod
    public void posTests(){
        driver.close();
    }

    @Test
    public void atc01_iniciarSesion() throws InterruptedException {
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

        Thread.sleep(4000);
        driver.get("https://portal.servipag.com/private/profile");
        Thread.sleep(2000);

        By titulo = By.xpath("//h4[contains(text(),'Hola Matias')]");
        WebElement txtTitulo = driver.findElement(titulo);
        System.out.println(txtTitulo.getText());

        By miRut = By.cssSelector("#rut");
        WebElement txtRut = driver.findElement(miRut);
        System.out.println(txtRut.getText());

        By miNombre = By.xpath("//input[@id='validationCustom01']");
        WebElement txtNombre = driver.findElement(miNombre);
        System.out.println(txtNombre.getText());

        By miApellido = By.xpath("//input[@id='validationCustom02']");
        WebElement txtApellido = driver.findElement(miApellido);
        System.out.println(txtApellido.getText());


        //Assert.assertEquals("Matias", txtNombre.getText());
        //Assert.assertEquals("Rojas Arias", txtApellido.getText());
        //Assert.assertEquals("17.555.387-8", txtRut.getText());
        Assert.assertEquals("Hola Matias",txtTitulo.getText());
    }
    @Test
    public void atc02_agregarCuenta() throws InterruptedException {
        atc01_iniciarSesion();
        Thread.sleep(2000);
        driver.get("https://portal.servipag.com/private/miservipag");

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

        Thread.sleep(3000);
        By titulo = By.xpath("//h3[contains(text(),'Excelente!')]");
        WebElement txtTitulo = driver.findElement(titulo);

        By sigueAgregando = By.xpath("//a[contains(text(),'Sigue agregando tus cuentas')]");
        WebElement txtsigueAgregando = driver.findElement(sigueAgregando);

        Assert.assertEquals("Excelente!", txtTitulo.getText());
        Assert.assertEquals("Sigue agregando tus cuentas", txtsigueAgregando.getText());

        By aceptar = By.xpath("//button[contains(text(),'Aceptar')]");
        WebElement btnAceptar = wait.until(ExpectedConditions.elementToBeClickable(aceptar));
        btnAceptar.click();
    }
    @Test
    public void atc03_eliminarCuenta() throws InterruptedException {
        atc01_iniciarSesion();
        Thread.sleep(4000);

        List<WebElement> misCuentas = driver.findElements(By.xpath("//div[@class=\"id col-3 text-break\"]"));

        for (int i = 0; i < misCuentas.size(); i++ ) {
            if (misCuentas.get(i).getText().equals("562267260251")) {
                System.out.println(misCuentas.get(i).getText());

                By borrar = By.xpath("//li[@class=\"delete\"]");
                WebElement btnBorrar = wait.until(ExpectedConditions.elementToBeClickable(borrar));
                Thread.sleep(1000);
                btnBorrar.click();
                System.out.println("Click realizado !");

                By eliminar = By.xpath("//button[contains(text(),'Eliminar')]");
                WebElement btnEliminar = wait.until(ExpectedConditions.elementToBeClickable(eliminar));
                Thread.sleep(1000);
                btnEliminar.click();
                System.out.println("Cuenta eliminada. !");

                By titulo = By.xpath("//p[contains(text(),'Su cuenta ha sido eliminada')]");
                WebElement txtTitulo = driver.findElement(titulo);

                Assert.assertEquals("Su cuenta ha sido eliminada",txtTitulo.getText());

                By entendido = By.xpath("//button[contains(text(),'Entendido')]");
                WebElement btnEntendido = driver.findElement(entendido);
                btnEntendido.click();

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
        Thread.sleep(3500);

        List<WebElement> servicios = driver.findElements(By.tagName("lib-payment-card"));

        for (int i = 0; i < servicios.size(); i++ ) {
            if (servicios.get(i).getText().equals("Internet")) {
                System.out.println(servicios.get(i).getText());

                servicios.get(i).click();
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
    @Test
    public void atc05_pagoMultiple() throws InterruptedException {
        atc01_iniciarSesion();
        driver.get("https://portal.servipag.com/private/miservipag");
        Thread.sleep(4000);
        List<WebElement> misCuentas = driver.findElements(By.xpath("//div[@class=\"id col-3 text-break\"]"));

        for (int i = 0; i < misCuentas.size(); i++ ) {
            if (misCuentas.get(i).getText().equals("175553878")) {
                System.out.println(misCuentas.get(i).getText());

                By agregar = By.xpath("//body[1]/main[1]/div[1]/div[1]/div[2]/div[2]/div[1]/private-dashboard[1]/private-dashboard-dashboard[1]/div[1]/div[1]/div[1]/div[1]/div[2]/tabset[1]/div[1]/tab[1]/private-dashboard-panel-abc[1]/div[1]/div[2]/ul[1]/li[2]/private-bill-card[1]/div[2]/div[1]/div[4]/span[1]/show-cost[1]/div[1]");
                WebElement btnAgregar = wait.until(ExpectedConditions.elementToBeClickable(agregar));

                btnAgregar.click();
                System.out.println("Click realizado !");
                break;
            } else {
                System.out.println(misCuentas.get(i).getText());
                System.out.println("Error dato no es correcto");
            }
        }


    }

}
