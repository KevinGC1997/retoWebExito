package com.exito.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.exito.userInterfaces.InicioExitoUI.*;
import static com.exito.userInterfaces.CategoriaSeleccionadaExitoUI.TXT_ELEMENTO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IrCategoriaSubCategoria implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_HAMBURGUESA, isVisible()).forNoMoreThan(50).seconds(),
                Click.on(BTN_HAMBURGUESA),
                Click.on(BTN_CATEGORIA),
                Click.on(BTN_SUBCATEGORIA),
                WaitUntil.the(TXT_ELEMENTO, isVisible()).forNoMoreThan(20).seconds()
        );

    }
    public static IrCategoriaSubCategoria on(){
        return Instrumented.instanceOf(IrCategoriaSubCategoria.class).withProperties();
    }
}
