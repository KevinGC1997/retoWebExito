package com.exito.tasks;

import com.exito.interactions.AgregarProducto;
import com.exito.interactions.IrCategoriaSubCategoria;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class AgregarProductoExito implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                IrCategoriaSubCategoria.on(),
                AgregarProducto.EnSitio()
        );

    }
    public static AgregarProductoExito EnSitio() {
        return Instrumented.instanceOf(AgregarProductoExito.class).withProperties();
    }
}
