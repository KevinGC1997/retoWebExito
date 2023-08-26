package com.exito.userInterfaces;


import net.serenitybdd.screenplay.targets.Target;

public class InicioExitoUI {
    public static final Target BTN_HAMBURGUESA = Target.the("buton para ir a seleccionar categoria")
            .locatedBy("//div[@id='category-menu']");
    public static final Target BTN_CATEGORIA = Target.the("buton para selecionar categoria")
            .locatedBy("//li[@id='undefined-nivel2-Dormitorio']");
    public static final Target BTN_SUBCATEGORIA = Target.the("buton para seleccionar subcategoria")
            .locatedBy("//p[@id='Categorías-nivel3-Cabeceros']");
}
