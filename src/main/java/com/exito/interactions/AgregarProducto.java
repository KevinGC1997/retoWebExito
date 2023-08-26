package com.exito.interactions;

import com.exito.utils.CantidadesAleatorias;
import com.exito.utils.EscribirExcel;
import com.exito.utils.LimpiarNumero;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import java.text.NumberFormat;
import java.util.*;


import static com.exito.userInterfaces.CategoriaSeleccionadaExitoUI.*;

public class AgregarProducto implements Interaction {


    @Override
    public <T extends Actor> void performAs(T actor) {

        Map<String, Object[]> datos = new TreeMap<String, Object[]>();
        List<WebElementFacade> listButton = BTN_PRODUCTOS.resolveAllFor(actor);
        List<WebElementFacade> NameProduct = TXT_NOMBRE_PRODUCTO.resolveAllFor(actor);
        List<WebElementFacade> precie = TXT_PRECIO_PRODUCTO.resolveAllFor(actor);
        final List<Integer> arreglo = CantidadesAleatorias.cantidadesAleatorias(listButton);
        System.out.println("arreglo inicial: "+arreglo );

        for (int i=0; i<5; i++) {
            listButton.get(arreglo.get(i)).click();
            actor.attemptsTo(
                    Scroll.to(BTN_AGREGAR_CARRITO),
                    Click.on(BTN_AGREGAR_CARRITO),
                    SumarioProductos.EnSitio(arreglo, i)
            );

            //se optienen los valores de la interface
            String Name = NameProduct.get(arreglo.get(i)).getText();
            String PriceProducto = precie.get(arreglo.get(i)).getText();
            String valor = LimpiarNumero.LimpiarNumero(PriceProducto);
            int total = Integer.parseInt(valor) * arreglo.get(i);
            NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
            numberFormat.setGroupingUsed(true);
            String valorTotal = numberFormat.format(total);
            System.out.println("valor formateado " + valorTotal);

            //se crea el objeto Map para enviar a la clase escribir excel
            System.out.println("arreglo en carrito: "+arreglo);
            Object[] product = new Object[]{Name, PriceProducto, arreglo.get(i), valorTotal};
            datos.put(String.valueOf(i+1), product);
            EscribirExcel.EscribirExcel(datos);

            //
            actor.attemptsTo(
                    Scroll.to(BTN_CERRAR_COMPRA_RAPIDA),
                    Click.on(BTN_CERRAR_COMPRA_RAPIDA),
                    ExplicitWait.here(5),
                    Scroll.to(LBL_BUSCADOR)
            );
        }
    }
    public static AgregarProducto EnSitio() {
        return Instrumented.instanceOf(AgregarProducto.class).withProperties();
    }
}
