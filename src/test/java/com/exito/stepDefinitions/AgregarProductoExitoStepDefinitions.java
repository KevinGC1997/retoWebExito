package com.exito.stepDefinitions;


import com.exito.tasks.AgregarProductoExito;
import com.exito.tasks.IrCarritoValidarExito;
import com.exito.utils.WebDriverFactory;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class AgregarProductoExitoStepDefinitions {
    @Before
    public void setStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^Brandon accede exitosamente al sitio de web del exito (.*)$")
    public void brandonAccedeExitosamenteAlSitioDeWebDelExitoHttpsWwwExitoCom(String url) {
        OnStage.theActorCalled("brandon").can(BrowseTheWeb.with(WebDriverFactory.goToWeb(url)));
    }


    @When("^se dirige agregar diferentes productos$")
    public void seDirigeAgregarDiferentesProductos() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AgregarProductoExito.EnSitio()
        );
    }

    @Then("^valida el total de los productos agregados$")
    public void validaElTotalDeLosProductosAgregados() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IrCarritoValidarExito.EnSitio()
        );
    }
}
