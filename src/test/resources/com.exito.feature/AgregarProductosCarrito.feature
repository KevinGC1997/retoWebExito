Feature: agregar productos a carrito exito

  Scenario Outline: agregar y validar productos agregados a carrito

    Given Brandon accede exitosamente al sitio de web del exito <url>
    When se dirige agregar diferentes productos
    Then valida el total de los productos agregados

    Examples:
      | url                    |
      | https://www.exito.com/ |



