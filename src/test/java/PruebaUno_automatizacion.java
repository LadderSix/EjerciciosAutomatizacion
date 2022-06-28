import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        Thread.sleep(10000);

        By cuentas = By.xpath("//body[1]/main[1]/div[1]/div[1]/div[2]/div[2]/div[1]/private-dashboard[1]/private-dashboard-dashboard[1]/div[1]/div[1]");
        WebElement miTabla = driver.findElement(cuentas);
        System.out. println(miTabla.getText());

        List<WebElement> misCuentas = miTabla.findElements(By.tagName("ul"));

        for (int i = 0; i < misCuentas.size(); i++ ) {
            //System.out. println(misCuentas);
            if (miTabla.getText().equals("562267260251")) {
                System.out.println(miTabla.getText());

                By eliminar = By.xpath("//body[1]/main[1]/div[1]/div[1]/div[2]/div[2]/div[1]/private-dashboard[1]/private-dashboard-dashboard[1]/div[1]/div[1]/div[1]/div[1]/div[2]/tabset[1]/div[1]/tab[1]/private-dashboard-panel-abc[1]/div[1]/div[2]/ul[1]/li[5]/private-bill-card[1]/div[2]/div[1]/div[1]/span[1]/ul[1]/li[2]/img[1]");
                WebElement btnEliminar = wait.until(ExpectedConditions.elementToBeClickable(eliminar));
                btnEliminar.click();

                break;
            }
        }

    }
    /*@Test
    public void atc04_pagoRapido(){

        By pagoRapido = By.xpath("//a[contains(text(),'Pago Rápido')]");
        WebElement btnPagoRapido = wait.until(ExpectedConditions.elementToBeClickable(pagoRapido));
        btnPagoRapido.click();

        By seccionInternet = By.xpath("//body[1]/main[1]/div[1]/div[3]/payment-root[1]/app-listado-servicios[1]/div[2]/div[1]/div[1]/div[1]/div[1]/lib-payment-card[23]");
        WebElement internet = wait.until(ExpectedConditions.elementToBeClickable(seccionInternet));
        internet.click();

        By seleccionar_empresa = By.xpath("//body[1]/main[1]/div[1]/div[3]/payment-root[1]/app-listado-servicios[1]/div[2]/div[1]/div[1]/div[1]/div[1]/lib-payment-card[23]/app-select-company[1]/div[1]/div[1]/div[2]/form[1]/section[1]/div[1]/div[1]/div[1]/select[1]");

        if (driver.findElement(seleccionar_empresa).isDisplayed()){
            WebElement listaEmpresas = driver.findElement(seleccionar_empresa);
            Select dropdown = new Select(listaEmpresas);
            dropdown.selectByVisibleText("Movistar Hogar/Negocio Internet");
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
    public void atc05_pagoMultiple(){
        atc01_iniciarSesion();

    }*/

}
