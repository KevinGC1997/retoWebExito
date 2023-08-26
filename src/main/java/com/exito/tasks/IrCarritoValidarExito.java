package com.exito.tasks;

import com.exito.interactions.IrCarritoCompras;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class IrCarritoValidarExito implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                IrCarritoCompras.on()
        );
    }
    public static IrCarritoValidarExito EnSitio() {
        return Instrumented.instanceOf(IrCarritoValidarExito.class).withProperties();
    }
}
