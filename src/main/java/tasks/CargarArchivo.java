package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import util.SelectorRutasArchivos;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static ui.PaginaCargaArchivo.*;

public class CargarArchivo implements Task {

    private final String tipoArchivo;

    public CargarArchivo(String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    public static Performable subir(String tipoArchivo) {
        return instrumented(CargarArchivo.class, tipoArchivo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String fileLocation = SelectorRutasArchivos.seleccionarArchivo(tipoArchivo);
        StringSelection filePath = new StringSelection(fileLocation);

        //En esta linea de codigo guardamos la ruta en un portapales para despues poder hacer ctrl+v con ella
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
        try {
            Robot robot = new Robot();

            //EL actor hace TAB dos veces para llegar al boton
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            //EL actor presiona el boton suir archivo y lo suelta
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(2000);
            //EL actor pega la ruta donde see encuentra el archivo
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);

            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        }catch (AWTException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actor.attemptsTo(
                Click.on(BTN_UPLOAD)
        );

    }
}
