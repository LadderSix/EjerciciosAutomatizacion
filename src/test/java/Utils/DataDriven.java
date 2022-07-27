package Utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;

public class DataDriven {
    public static ArrayList<String> getData(String nombreCasoPrueba){

        ArrayList<String> a =  new ArrayList<>();

        //Instanciamos un objeto tipo file con la ruta del excel
        FileInputStream file = null;
        try {
            file = new FileInputStream
                    ("C:\\Users\\matias.rojas\\IdeaProjects\\EjerciciosAutomatizacion\\src\\main\\resources\\Data\\DataDriven.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Instanciamos un objeto de tipo excel en base a la fila
        XSSFWorkbook excel = null;
        try {
            excel = new XSSFWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int sheets = excel.getNumberOfSheets();
        System.out.println("Cantidad de Hojas: " + sheets);

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

                int k = 0;
                int columna = 0;

                while(celda.hasNext()){
                    Cell celdaSeleccionada = celda.next();
                    System.out.println(celdaSeleccionada.getStringCellValue());
                    if(celdaSeleccionada.getStringCellValue().equalsIgnoreCase("TestCase")){
                        //identifique la celda con el titulo de la columna con los nombres de los TCs
                        columna = k;
                    }
                    k++;
                }

                while (filas.hasNext()){
                    Row r = filas.next();
                    if (r.getCell(columna).getStringCellValue().equalsIgnoreCase(nombreCasoPrueba)){

                        //Iteramos en la celda
                        Iterator<Cell> cv = r.cellIterator();

                        while (cv.hasNext()){
                            Cell cell = cv.next();
                            //System.out.println(cell.getCellType());
                            if (cell.getCellType() == CellType.STRING){
                                //System.out.println(cell.getStringCellValue());
                                a.add(cell.getStringCellValue());
                            }else if(cell.getCellType() == CellType.NUMERIC){
                                //System.out.println(NumberToTextConverter.toText(cell.getNumericCellValue()));
                                a.add(NumberToTextConverter.toText(cell.getNumericCellValue()));
                            }
                        }
                    }
                }
            }
        }
        return a;
    }
}
