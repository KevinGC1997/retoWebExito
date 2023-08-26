package com.exito.interactions;

import com.exito.utils.DatosExcel;
import com.exito.utils.LimpiarNumero;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;


import static com.exito.userInterfaces.CategoriaSeleccionadaExitoUI.*;




public class IrCarritoCompras implements Interaction {


    public static Target TXT_NOMBRE_PRUDCITO_CARRITO = null;
    public static Target TXT_CANTIDAD_PRODUCTO_CARRITO = null;
    public static Target TXT_VALOR_TOTAL_PRODUCTO_CARRITO = null;


    @Override
    public <T extends Actor> void performAs(T actor) {

        DatosExcel datos = new DatosExcel();
        actor.attemptsTo(Click.on(BTN_CARRITO), ExplicitWait.here(5));
        for (int i=0; i< 5; i++){
            try {
                String nombreProducto = datos.leerDatoExcel("Hoja de datos","data.xlsx",i,0);
                String cantidadProducto = datos.leerDatoExcel("Hoja de datos","data.xlsx",i,2);
                String valorTotalProducto = datos.leerDatoExcel("Hoja de datos","data.xlsx",i,3);
                //agregar signo
                String valorTotal ="$ "+valorTotalProducto;

                TXT_NOMBRE_PRUDCITO_CARRITO = Target.the("xpath nombre")
                        .locatedBy("//*[contains(text(), "+"'"+nombreProducto+"')]");
                TXT_CANTIDAD_PRODUCTO_CARRITO = Target.the("xpath cantidad ")
                        .locatedBy("//span[@data-molecule-quantity-und-value='true' and " +
                                "contains(text(), "+"'"+cantidadProducto+"')]");
                TXT_VALOR_TOTAL_PRODUCTO_CARRITO = Target.the("xpath cantidad")
                                .locatedBy("//*[contains(text(), "+"'"+valorTotalProducto+"')]");

                System.out.println("producto excel "+nombreProducto);
                System.out.println("cantidad producto excel "+cantidadProducto);
                System.out.println("valor total excel "+valorTotal);
                System.out.println("producto web "+TXT_NOMBRE_PRUDCITO_CARRITO.resolveFor(actor).getText());
                System.out.println("cantidad producto web "+TXT_CANTIDAD_PRODUCTO_CARRITO.resolveFor(actor).getText());
                System.out.println("total producto web "+TXT_VALOR_TOTAL_PRODUCTO_CARRITO.resolveFor(actor).getText());
                actor.attemptsTo(
                        Ensure.that(TXT_NOMBRE_PRUDCITO_CARRITO).text().contains(nombreProducto),
                        Ensure.that(TXT_CANTIDAD_PRODUCTO_CARRITO).text().isEqualTo(cantidadProducto),
                        Ensure.that(TXT_VALOR_TOTAL_PRODUCTO_CARRITO).text().isEqualTo(valorTotal)
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static IrCarritoCompras on(){
        return Instrumented.instanceOf(IrCarritoCompras.class).withProperties();
    }
}
