package es.vlc.hotelbeds.higueras.controller;

import es.vlc.hotelbeds.higueras.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.math.BigDecimal;

@RestController
public class ItemController {

    public static final String HELP_TEXT = "To calculate the total amount with discounts and regional taxes, it's necessary to do a petition to: {mainUrl}/order/totalprice/{itemDescription}/{itemPrice}/{numberOfItems}/{state}";

    @Autowired
    CalculateService calculateService;

    /**
     *
     *     1. Descripción del artículo (itemDescription)
     *     2. Precio por artículo (itemPrice)
     *     3. Número de artículos pedidos (numberOfItems)
     *     4. Provincia del pedido (código de 3 letras) (state)
     *
     * @return string JSON value
     */
    @GetMapping(value = "/order/totalprice/{itemDescription}/{itemPrice}/{numberOfItems}/{state}",
            produces = MediaType.APPLICATION_JSON_VALUE )
    public String totalPriceOrder(
            @PathVariable(value="itemDescription") String itemDescription,
            @PathVariable(value="itemPrice") String itemPrice,
            @PathVariable(value="numberOfItems") String numberOfItems,
            @PathVariable(value="state") String state ) {
        BigDecimal resultTotalAmount = calculateService.calculateTotalAmount(
                itemDescription,
                BigDecimal.valueOf(Double.parseDouble(itemPrice)),
                Integer.parseInt(numberOfItems),
                state);
        return String.format("The total amount of the order is: %s", (resultTotalAmount != null ? resultTotalAmount.toPlainString() : "NONE"));
    }

    @GetMapping(value = "/help",
            produces = MediaType.APPLICATION_JSON_VALUE )
    public String printHelpValue(){
        return HELP_TEXT;
    }

}
