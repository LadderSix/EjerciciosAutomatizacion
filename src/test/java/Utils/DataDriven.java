package Utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Iterator;

public class DataDriven {
    public static void main(String[] args) throws IOException {

        //Instanciamo un objeto tipo file con la ruta del excel
        FileInputStream file = new FileInputStream
                ("C:\\Users\\matias.rojas\\IdeaProjects\\EjerciciosAutomatizacion\\src\\main\\resources\\Data\\DataDriven.xlsx");

        //Instancia un objeto de tipo excel en base a la fila
        XSSFWorkbook excel = new XSSFWorkbook(file);

        int sheets = excel.getNumberOfSheets();
        System.out.println(sheets);

        for(int i = 0; i < sheets ; i++){
            if (excel.getSheetName(i).equalsIgnoreCase("Datos")){
                //encontre la hoja
                XSSFSheet hojaExcel = excel.getSheetAt(i);
                //Iteramos en la fila
                Iterator<Row> filas = hojaExcel.iterator();
                //fila toma el valor y sigue con el siguiente si existe
                Row fila = filas.next();
                //Iteramos en la celda
                Iterator<Cell> celda = fila.cellIterator();

                while(celda.hasNext()){
                    Cell celdaSeleccionada = celda.next();
                    //System.out.println(celdaSeleccionada.getStringCellValue());
                    if(celdaSeleccionada.getStringCellValue().equalsIgnoreCase("TestCase"));
                    //identifique la celda con el titulo de la columna con los nombres de los TCs
                }
            }
        }
    }
}
