package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Hooks {

    @Before
    public void theSetStage(Scenario scenario){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Camilo");

        String featureTag = scenario.getSourceTagNames().iterator().next();
        System.out.println("Caso de prueba: " + featureTag + " " + scenario.getName());
    }
}
