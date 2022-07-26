package Utils;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataDriven {
    public static void main(String[] args) throws IOException {

        //Instanciamo un objeto tipo file con la ruta del excel
        FileInputStream file = new FileInputStream
                ("C:\\Users\\matias.rojas\\IdeaProjects\\EjerciciosAutomatizacion\\src\\main\\resources\\Data\\DataDriven.xlsx");

        //Instancia un objeto de tipo excel en base a la fila
        XSSFWorkbook excel = new XSSFWorkbook(file);

        int sheets = excel.getNumberOfSheets();
        System.out.println(sheets);

    }
}
