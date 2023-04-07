package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SelectorRutasArchivos {

    public static String rutaArchivoWord(){
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/test/resources/rutas.properties"));
        }catch (IOException e){
            e.printStackTrace();
        }
        String ruta = prop.getProperty("archivo.word.up.load");
        System.out.println(ruta);
        return ruta;
    }

    public static String rutaArchivoPdf(){
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/test/resources/rutas.properties"));
        }catch (IOException e){
            e.printStackTrace();
        }
        String ruta = prop.getProperty("archivo.pdf.up.load");
        System.out.println(ruta);
        return ruta;
    }

    public static String seleccionarArchivo(String archivo){

        switch (archivo){

            case "documento word":
                return rutaArchivoWord();


            case "documento pdf":
                return rutaArchivoPdf();


            default: throw new IllegalArgumentException("El archivo no existe : " + archivo);

        }
    }

}
