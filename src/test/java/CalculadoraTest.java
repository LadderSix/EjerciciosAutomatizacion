import Calculadora.Calculadora;
import org.junit.*;

public class CalculadoraTest {
    //Atributos
    private Calculadora calc;

    @Test
    public  void testNro5(){
        Assert.assertEquals(true,true);
    }

    @Test
    public  void testNro6(){
        Assert.assertEquals(true,true);
    }

    @Test
    public  void testNro7(){
        Assert.assertTrue(true);
    }

    @AfterClass
    public static void preparacionEjecucion(){
        System.out.println("Cierre de ejecución de pruebas unitarias...");
        System.out.println("Subiendo resultados...");
    }

    @BeforeClass
    public static void revisionEjecucion(){
        System.out.println("Preparación de ejecución de las pruebas unitarias...");
    }

    @Before
    public void preparacionTests(){
        System.out.println("Preparación de prueba.");
        calc = new Calculadora();
    }

    @After
    public void posEjecucionTests(){
        System.out.println("Pos Ejecución de prueba.");

    }

    //Método para probar el método sumar
    @Test
    public void testSumar(){
        System.out.println("Ejecución Método Sumar");
        Assert.assertEquals(30,calc.sumar(20,10));
    }

    @Test
    public void testRestar(){
        System.out.println("Ejecución Método Restar");
        Assert.assertEquals(10,calc.restar(20,10));
    }

    @Test
    public void testMultiplicar(){
        System.out.println("Ejecución Método Multiplicar");
        Assert.assertEquals(200,calc.multiplicar(20,10));
    }

    @Test
    public void testDividir(){
        System.out.println("Ejecución Método Dividir");
        Assert.assertEquals(2,calc.dividir(20,10));
    }

}

