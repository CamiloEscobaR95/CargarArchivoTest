package stepdefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Open;
import tasks.CargarArchivo;
import ui.PaginaCargaArchivo;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ArchivosDefinitions {

    @Given("el usuario ingresa al page de subir archivo")
    public void el_usuario_ingresa_al_page_de_subir_archivo() {

        PaginaCargaArchivo page = new PaginaCargaArchivo();
        theActorInTheSpotlight().wasAbleTo(
                Open.browserOn(page)
        );
    }
    @When("el usuario selecciona el archivo a cargar {string}")
    public void el_usuario_selecciona_el_archivo_a_cargar(String tipoArchivo) {
        theActorInTheSpotlight().wasAbleTo(
                CargarArchivo.subir(tipoArchivo)
        );
    }
    @Then("el usuario finaliza la carga")
    public void el_usuario_finaliza_la_carga() {

    }

}
