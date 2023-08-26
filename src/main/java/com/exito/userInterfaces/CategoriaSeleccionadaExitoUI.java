package com.exito.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CategoriaSeleccionadaExitoUI {

    public static final Target BTN_PRODUCTOS = Target.the("lista de botones")
            .locatedBy("//div[@class='button-modal flex items-center vtex-button bw1 ba fw5 v-mid relative pa0 lh-solid br2 min-h-small t-action bg-action-primary b--action-primary c-on-action-primary hover-bg-action-primary hover-b--action-primary hover-c-on-action-primary pointer w-100']");

    public static final Target TXT_ELEMENTO = Target.the("elemento para esperar")
            .locatedBy("//*[contains(text(), 'Cabeceros para')]");
    public static final Target LBL_BUSCADOR = Target.the("elemento para scroll")
            .locatedBy("//a[@id='header-tabModa']");

    public static final Target BTN_AGREGAR_CARRITO = Target.the("buton para agregar a carrito")
            .locatedBy("//div[@class='exito-vtex-components-4-x-mainBuyButton']");
    public static final Target BTN_CERRAR_COMPRA_RAPIDA = Target.the("buton para cerrar compra rapida")
            .locatedBy("//span[@class='exito-vtex-components-4-x-defaultModalClose']");
    public static final Target BTN_AGREGAR_CANTIDAD = Target.the("buton para agregar mas cantidad de producto")
            .locatedBy("//button[@class='exito-vtex-components-4-x-buttonActions exito-vtex-components-4-x-productSummaryAddToCar  product-summary-add-to-car-plus']");
    public static final Target TXT_NOMBRE_PRODUCTO = Target.the("nombre producto")
            .locatedBy("//h3[@class='vtex-store-components-3-x-productNameContainer mv0 t-heading-4']//span");
    public static final Target TXT_PRECIO_PRODUCTO = Target.the("precio producto")
            .locatedBy("//div[@class='exito-vtex-components-4-x-PricePDP']//span[@class='exito-vtex-components-4-x-currencyContainer']");
    public static final Target TXT_TOTAL_PRECIOS_PRODUCTOS = Target.the("")
            .locatedBy("//div[@data-molecule-product-detail-price-best-price='true']//span[@class='exito-checkout-io-0-x-currencyContainer']");
    public static final Target BTN_CARRITO = Target.the("buton de carrito")
            .locatedBy("//a[@class='exito-header-3-x-minicartLink']");
}
