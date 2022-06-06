
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InicioSesionFacebook {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Matias.Rojas\\Documents\\chromedriver.exe");

        WebDriver objWeb = new ChromeDriver();

        objWeb.get("http://www.facebook.com"); // obtiene la URL en el navegador
        objWeb.findElement(By.id("email")).sendKeys("matiaselvago_007@hotmail.com"); // busca un elemento de tipo id e ingresa dato
        objWeb.findElement(By.name("pass")).sendKeys("rojasmatias4545");
        //objWeb.findElement(By.linkText("Forgot account?")).click(); // busca un elemento de tipo linktext y hace click
        //objWeb.findElement(By.className("inputtext")).sendKeys("holamundo"); // busca un elemento de tipo classname
        objWeb.findElement(By.name("login")).click();
        //objWeb.findElement(By.xpath("//*[@id='u_0_d_j6']")).click(); // busca un elemento de tipo xpath

    }
}
