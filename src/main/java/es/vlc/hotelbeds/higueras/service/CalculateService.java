package es.vlc.hotelbeds.higueras.service;

import java.math.BigDecimal;

public interface CalculateService {
    /**
     * Method to get the total amount of an order.
     * Discounts and taxes will be applied.
     *
     * @param itemDescription
     * @param itemPrice
     * @param numberOfItems
     * @param state
     * @return total amount
     */
    BigDecimal calculateTotalAmount(
            String itemDescription,
            BigDecimal itemPrice,
            Integer numberOfItems,
            String state);
}
