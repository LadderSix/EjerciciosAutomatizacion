package Utils;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> dataCP01 = DataDriven.getData("ATC01_IniciarSesion");

        for(int i=0; i< dataCP01.size();i++){
            System.out.println(dataCP01.get(i));
        }
    }
}
